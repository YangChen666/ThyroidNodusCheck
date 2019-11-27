#coding = utf-8
import cv2                            
import numpy as np 
import sys
# reload(sys)
# sys.setdefaultencoding("utf-8")
if __name__ == '__main__':
    #https://blog.csdn.net/sunshine_in_moon/article/details/51105014   +sys.argv[1]

    with open("E:\\IntelliJ Projects\\Thyroid\\error.txt","w")as f:
        f.write("start")
    image_path ="E:/IntelliJ Projects/Thyroid/Thyroid Maven Webapp/out/artifacts/Thyroid_Maven_Webapp_Web_exploded/Thyroid_images/"+sys.argv[1]

    with open("E:\\IntelliJ Projects\\Thyroid\\error.txt", "w")as f:
        f.write("图片名称"+sys.argv[1])

    with open("E:\\IntelliJ Projects\\Thyroid\\error.txt", "w")as f:
        f.write("裁剪参数"+sys.argv[2])

    clipParameter=[int(strNumber) for  strNumber in sys.argv[2].split('_')]

    # print(clipParameter)

    fakeHeight=clipParameter[0]
    fakeWidth=clipParameter[1]
    fakeTop=clipParameter[2]
    fakeBottom=clipParameter[3]
    fakeLeft=clipParameter[4]
    fakeRight=clipParameter[5]
    
    fakeY=fakeTop
    fakeX=fakeLeft
    fakeClipHeight=fakeBottom-fakeTop
    fakeClipWidth=fakeRight-fakeLeft

    srcImg = cv2.imread(image_path)
    # print(srcImg.shape)

    realHeight,realWidth,_=srcImg.shape
    rateH=float(realHeight)/float(fakeHeight)
    rateW=float(realWidth)/float(fakeWidth)

    

    img_roi_y      = int(fakeY*rateH)                
    img_roi_x      = int(fakeX*rateW)                                 
    img_roi_height = int(fakeClipHeight*rateH)                          
    img_roi_width  = int(fakeClipWidth*rateW) 
    
    img_roi = srcImg[img_roi_y:(img_roi_y+img_roi_height),img_roi_x:(img_roi_x+img_roi_width)]   
    
    #new_name="quzao"+sys.srgv[1]
    with open("error","w")as f:
        f.write("aaaaaaaaa")
    cv2.imwrite("E:/IntelliJ Projects/Thyroid/Thyroid Maven Webapp/out/artifacts/Thyroid_Maven_Webapp_Web_exploded/Thyroid_images/ROI_tuo%s" % sys.argv[1],img_roi)
    with open("error","w")as f:
        f.write("3333")
    # cv2.imwrite("C:\\Users\\YangChen\Desktop\\result.jpg",img_roi)
  
  

