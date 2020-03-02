"""
imageEnhance.py

YOUR WORKING FUNCTION

"""
import numpy as np
import cv2
import os


input_dir = 'input/input'
output_dir = 'output/output'

# you are allowed to import other Python packages above
##########################
def enhanceImage(img):
	# Inputs
    # inputImg: Input image, a 3D numpy array of row*col*3 in BGR format
    #
    # Output
    # outputImg: Enhanced image
    #
    #########################################################################
    # ADD YOUR CODE BELOW THIS LINE
	gamma = 0.5
	invGamma = 1.0 / gamma
	# build a lookup table mapping the pixel values [0, 255] to
	# their adjusted gamma values
	table = np.array([((i / 255.0) ** invGamma) * 255
		for i in np.arange(0, 256)]).astype("uint8")
	# apply gamma correction using the lookup table
	outputImg = cv2.LUT(img, table)
	img_resized = cv2.resize(img,None,fx=0.5,fy=0.5)

	##############
	#Equalize the image splitting the image after HSV conversion and applying cv2.equalizeHist()
    #to the V channel, merging the channels and convert back to the BGR color space
    
	H, S, V = cv2.split(cv2.cvtColor(outputImg, cv2.COLOR_BGR2HSV))
	eq_V = cv2.equalizeHist(V)
	eq_image = cv2.cvtColor(cv2.merge([H, S, eq_V]), cv2.COLOR_HSV2BGR)
	eq_image = cv2.GaussianBlur(eq_image,(3,3),0)
	outputImg = eq_image
	#cv2.imwrite(os.path.join(output_dir + str(x+1) + '.jpg'), eq_image)
	eq_image_resized = cv2.resize(eq_image,None,fx=0.5,fy=0.5)
	#############
	
	cv2.imshow("Images", np.hstack([img_resized, eq_image_resized]))
	cv2.waitKey(0)
	# END OF YOUR CODE
    #########################################################################
	return outputImg