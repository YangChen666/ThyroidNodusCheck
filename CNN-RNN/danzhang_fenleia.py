# -*- coding: UTF-8 -*- 

import os
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
import sys
import cv2

if __name__ == '__main__':
    
    model=ree()
    ########################
    model.load_weights('E:\\IntelliJ Projects\\Thyroid\model\\firstStage.hdf5')
    image_path = 'E:\\IntelliJ Projects\\Thyroid\\Thyroid Maven Webapp\\out\\artifacts\\Thyroid_Maven_Webapp_Web_exploded\\Thyroid_images\\'+sys.argv[1]
    
    #bimg=cv2.imread(image_path)
    #cv2.namedWindow('input_image', cv2.WINDOW_AUTOSIZE)
    #cv2.imshow('input_image', bimg)
    #cv2.waitKey(0)
    #cv2.destroyAllWindows()
    

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
        #zhengchang
        output = open('E:/IntelliJ Projects/Thyroid/fenleia.txt', 'w')
        output.write("z");#z:zhengchang
        output.close();
        # print ("ZhengChang")
    else:
        #jiejie
        output = open('E:/IntelliJ Projects/Thyroid/fenleia.txt', 'w')
        output.write("j");#j:jiejei
        output.close();
        # print ("jiejie")
