#coding = utf-8
import cv2                            
import numpy as np 
import sys
# reload(sys)
# sys.setdefaultencoding("utf-8")
if __name__ == '__main__':
    #https://blog.csdn.net/sunshine_in_moon/article/details/51105014   +sys.argv[1]

    image_path ="E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/Thyroid_images/1.jpg"
    srcImg = cv2.imread(image_path)            
    img_roi_y      = 100                 
    img_roi_x      = 100                             
    img_roi_height = 950                          
    img_roi_width  = 950                
    
    img_roi = srcImg[img_roi_y:(img_roi_y+img_roi_height),img_roi_x:(img_roi_x+img_roi_width)]   
    


    cv2.imwrite("E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/Thyroid_images/99999999999999999999.jpg" ,img_roi)  
    cv2.waitKey(0)
    cv2.destroyAllWindows() 

