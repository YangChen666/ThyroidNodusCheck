#coding = utf-8
import cv2                            
import numpy as np 
import sys

if __name__ == '__main__':
  #def ROI_tuo(image_name):
    reload(sys)
    sys.setdefaultencoding("utf-8")
    image_path ="E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/Thyroid_images/"+sys.argv[1]
    srcImg = cv2.imread(image_path)            
    img_roi_y      = 100                 
    img_roi_x      = 100                             
    img_roi_height = 950                          
    img_roi_width  = 950                
    
    img_roi = srcImg[img_roi_y:(img_roi_y+img_roi_height),img_roi_x:(img_roi_x+img_roi_width)]   
    
    new_name="ROI_tuo_"+image_name

    cv2.imwrite("E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/Thyroid_images/%s" % new_name,img_roi)  
    cv2.waitKey(0)
    cv2.destroyAllWindows() 

