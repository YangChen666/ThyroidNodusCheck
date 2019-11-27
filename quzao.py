#coding = utf-8
import cv2                            
import numpy as np 
import sys

if __name__ == '__main__':

    image_path ="E:/IntelliJ Projects/Thyroid/Thyroid Maven Webapp/out/artifacts/Thyroid_Maven_Webapp_Web_exploded/Thyroid_images/"+sys.argv[1]
    img = cv2.imread(image_path)
              
    image = cv2.medianBlur(img, 5)
    
    cv2.imwrite("E:/IntelliJ Projects/Thyroid/Thyroid Maven Webapp/out/artifacts/Thyroid_Maven_Webapp_Web_exploded/Thyroid_images/quzao%s" % sys.argv[2],image)  
  

