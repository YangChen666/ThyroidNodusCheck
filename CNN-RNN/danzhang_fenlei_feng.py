from keras.applications.xception import Xception
from keras.callbacks import ModelCheckpoint
from keras.engine import Input
from keras.layers import merge
from keras.layers import GlobalAveragePooling2D, Dense, Reshape, Lambda, K, LSTM
from keras.preprocessing.image import ImageDataGenerator
from keras.models import Model
from keras.callbacks import TensorBoard
from keras.optimizers import Adam
from keras.preprocessing import image
from keras.applications.imagenet_utils import preprocess_input

import time
import numpy as np

np.random.seed(1337)


class CustomImageDataGenerator(ImageDataGenerator):
    """
    Because Xception utilizes a custom preprocessing method, the only way to utilize this
    preprocessing method using the ImageDataGenerator is to overload the standardize method.

    The standardize method gets applied to each batch before ImageDataGenerator yields that batch.
    """

    def standardize(self, x):
        """
        Taken from keras.applications.xception.preprocess_input
        """
        if self.featurewise_center:
            x /= 255.
            x -= 0.5
            x *= 2.
        return x

def rgb_to_grayscale(input):
    """Average out each pixel across its 3 RGB layers resulting in a grayscale image"""
    return K.mean(input, axis=3)


def rgb_to_grayscale_output_shape(input_shape):
    return input_shape[:-1]

def ree():
    batch_size_phase_one = 32
    batch_size_phase_two = 16
    nb_val_samples = 5000

    nb_epochs = 2

    img_width = 299
    img_height = 299

    # Loading dataset
    # print("Loading the dataset with batch size of {}...".format(batch_size_phase_one))
    # train_generator, val_generator = get_training_generator(batch_size_phase_one)
    # print("Dataset loaded")

    print("Building model...")
    input_tensor = Input(shape=(img_width, img_height, 3))

    # Creating CNN
    cnn_model = Xception(weights='imagenet', include_top=False, input_tensor=input_tensor)

    x = cnn_model.output
    cnn_bottleneck = GlobalAveragePooling2D()(x)

    # Make CNN layers not trainable
    for layer in cnn_model.layers:
        layer.trainable = False

    # Creating RNN
    x = Lambda(rgb_to_grayscale, rgb_to_grayscale_output_shape)(input_tensor)
    x = Reshape((23, 3887))(x)  # 23 timesteps, input dim of each timestep 3887
    x = LSTM(2048, return_sequences=True)(x)
    rnn_output = LSTM(2048)(x)#rnn_output = LSTM(2048)(x)

    # Merging both cnn bottleneck and rnn's output wise element wise multiplication
    x = merge([cnn_bottleneck, rnn_output], mode='mul')
    predictions = Dense(2, activation='softmax')(x)#predictions = Dense(100, activation='softmax')(x)

    model = Model(input=input_tensor, output=predictions)
    return model