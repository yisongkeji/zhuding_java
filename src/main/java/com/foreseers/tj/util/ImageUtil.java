package com.foreseers.tj.util;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class ImageUtil {

	
	/*
	 * 用高斯滤波器平滑原图像  
	 * @param image 输入图像  
	 * @return 高斯滤波后的图像  
	 */  
	public static BufferedImage gaussFiltering(BufferedImage image) {  
		int size= 5;// 高斯模板  
		float[] elements = getGaussTemplate(1,size);  
		/**
		 * Kernel 类定义了一个矩阵，描述指定的像素及其周围像素如何影响过滤操作输出图像中像素位置的计算值。
		 * X 原点和 Y 原点指示 kernel 矩阵元素对应于为其计算输出值的像素位置。
		 */
		Kernel kernel = new Kernel(size, size, elements);//只接受float类型的  
		/**
		 * ConvolveOp类实现从源到目标的卷积。使用卷积核的卷积是一种通过输入像素来计算输出像素的空间运算，
		 * 方法是将核与输入像素邻域相乘。这种运算使得直接邻域可按核数学指定的方式影响输出像素。 
		 */
		ConvolveOp blur = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
		image= blur.filter(image, null);  return image; 
	} 
	/**  
	 * 高斯模板  
	 * @param sigma 标准差  
	 * @param size 高斯模板高，宽  
	 * @return  高斯模板  
	 */  
	public static float[] getGaussTemplate(int sigma,int size){  
		float[] temp=new float[size*size];  
		double[][] Gaussian_Temp = new double[size][size];    
		int i,j;    
		double sum = 0;    
		double weight= 2*Math.PI*sigma*sigma; 
		for(i =0;i <size;i++){    
			for(j = 0;j < size;j++){    
				Gaussian_Temp[i][j] =weight* Math.exp(-((i-size/2)*(i-size/2)+(j-size/2)*(j-size/2))/(2.0*sigma*sigma));      
				sum += Gaussian_Temp[i][j];    
			}    
		}  
		int k=0;  
		for(i = 0; i < size;i++){    
			for(j = 0;j < size;j++){    
				Gaussian_Temp[i][j] = Gaussian_Temp[i][j]/sum;//归一化处理    
				temp[k++]=Float.parseFloat(String.valueOf(Gaussian_Temp[i][j]));//double转float  
				temp[k-1]=Float.parseFloat(String .format("%.6f",temp[k-1]));//统一5位小数  
			}    
		} 
		return temp;  
	}

}
