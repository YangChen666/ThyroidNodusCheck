import numpy as np
from keras.layers import Dense
from keras.models import Model
from keras.preprocessing import image
from keras.applications.xception import Xception
from keras.engine import Input
from keras.layers import GlobalAveragePooling2D, Dense, Reshape, Lambda, K, LSTM
from keras.applications.imagenet_utils import preprocess_input
#%%%%%%%%%%%%%%%%%%%%%%
from danzhang_fenlei_feng import ree

model=ree()
########################
model.load_weights('E:/IntelliJ Projects/Thyroid/CNN-RNN/finetuned_cnn_rnn_weights_2.hdf5')

image_path = 'E:\\IntelliJ Projects\\Thyroid\\Thyroid Maven Webapp\\out\\artifacts\\Thyroid_Maven_Webapp_Web_exploded\\Thyroid_images\\14.jpg'

img = image.load_img(image_path, target_size=(299, 299))

x = image.img_to_array(img)
x = np.expand_dims(x, axis=0)
x = preprocess_input(x)
#print x
print ("****")
preds =model.predict(x)

print ('Predicted:', preds)

print ("NO_1:")
print (preds[0][0])
print ("NO_2:")
print (preds[0][1])
print ("******")
if(preds[0][1]>preds[0][0]):
    print ("ZhengChang")
else:
    print ("jiejie")
