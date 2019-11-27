#-*- coding: UTF-8 -*-
from PIL import Image  
from PIL import ImageEnhance  
import cv2
from matplotlib import pyplot as plt
import sys

if __name__ == '__main__':
	#原始图像
	image_path ="E:/IntelliJ Projects/Thyroid/Thyroid Maven Webapp/out/artifacts/Thyroid_Maven_Webapp_Web_exploded/Thyroid_images/"+sys.argv[1] 
	image = Image.open(image_path)  
	#image.show()  
	  
	#亮度增强  
	enh_bri = ImageEnhance.Brightness(image)  
	brightness = 1.5  
	image_brightened = enh_bri.enhance(brightness)  
	#image_brightened.show()
	# cv2.imwrite("f:/ps/1.jpg",image_brightened)
	  
	  
	# #色度增强  
	# enh_col = ImageEnhance.Color(image)  
	# color = 1.5  
	# image_colored = enh_col.enhance(color)  
	# image_colored.show()  
	  
	# #对比度增强  
	# enh_con = ImageEnhance.Contrast(image)  
	# contrast = 1.5  
	# image_contrasted = enh_con.enhance(contrast)  
	# image_contrasted.show()
	# plt.imsave('f:/1.jpg', image_contrasted)  
	  
	# #锐度增强  
	# enh_sha = ImageEnhance.Sharpness(image)  
	# sharpness = 3.0  
	# image_sharped = enh_sha.enhance(sharpness)  
	# image_sharped.show()

	image_brightened.save("E:/IntelliJ Projects/Thyroid/Thyroid Maven Webapp/out/artifacts/Thyroid_Maven_Webapp_Web_exploded/Thyroid_images/liang%s" % sys.argv[2])
