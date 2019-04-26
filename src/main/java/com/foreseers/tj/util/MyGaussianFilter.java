package com.foreseers.tj.util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;

import com.sun.javafx.image.PixelUtils;

public class MyGaussianFilter  {
	 
    public static int CLAMP_EDGES = 1;
    public static int WRAP_EDGES = 2;
    protected Kernel kernel;
    protected boolean alpha = false;
    protected boolean premultiplyAlpha = false;
 
    protected float radius;
 
    public MyGaussianFilter() {
        this(2.0F);
    }
 
    public MyGaussianFilter(float radius) {
        this.setRadius(radius);
    }
 
    public void setRadius(float radius) {
        this.radius = radius;
        this.kernel = makeKernel(radius);
    }
 
    public float getRadius() {
        return this.radius;
    }
 
    public BufferedImage filter(BufferedImage src, BufferedImage dst) {
        int width = src.getWidth();
        int height = src.getHeight();
        if (dst == null) {
            dst = this.createCompatibleDestImage(src, (ColorModel)null);
        }
 
        int[] inPixels = new int[width * height];
        int[] outPixels = new int[width * height];
        src.getRGB(0, 0, width, height, inPixels, 0, width);
        if (this.radius > 0.0F) {
            //这里是对图片进行处理
            convolveAndTranspose(this.kernel, inPixels, outPixels, width, height, this.alpha, this.alpha && this.premultiplyAlpha, false, CLAMP_EDGES, 1);
            convolveAndTranspose(this.kernel, outPixels, inPixels, height, width, this.alpha, false, this.alpha && this.premultiplyAlpha, CLAMP_EDGES, 2);
        }
 
        dst.setRGB(0, 0, width, height, inPixels, 0, width);
        return dst;
    }
 
    public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel dstCM) {
        if (dstCM == null) {
            dstCM = src.getColorModel();
        }
   //    WritableRaster name =  dstCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight());
   //    boolean name1 =  dstCM.isAlphaPremultiplied();
       
        return new BufferedImage(dstCM, dstCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight()), dstCM.isAlphaPremultiplied(), null);
    }
 
    public static Kernel makeKernel(float radius) {
        int r = (int)Math.ceil((double)radius);
        int rows = r * 2 + 1;
        float[] matrix = new float[rows];
        float sigma = radius / 3.0F;
        float sigma22 = 2.0F * sigma * sigma;
        float sigmaPi2 = 6.2831855F * sigma;
        float sqrtSigmaPi2 = (float)Math.sqrt((double)sigmaPi2);
        float radius2 = radius * radius;
        float total = 0.0F;
        int index = 0;
 
        int i;
        for(i = -r; i <= r; ++i) {
            float distance = (float)(i * i);
            if (distance > radius2) {
                matrix[index] = 0.0F;
            } else {
                matrix[index] = (float)Math.exp((double)(-distance / sigma22)) / sqrtSigmaPi2;
            }
 
            total += matrix[index];
            ++index;
        }
 
        for(i = 0; i < rows; ++i) {
            matrix[i] /= total;
        }
 
        return new Kernel(rows, 1, matrix);
    }
 
    public static void convolveAndTranspose(Kernel kernel, int[] inPixels, int[] outPixels, int width, int height, boolean alpha, boolean premultiply, boolean unpremultiply, int edgeAction,
                                            int type) {
        float[] matrix = kernel.getKernelData((float[])null);
        int cols = kernel.getWidth();
        int cols2 = cols / 2;
 
        int y = 0;
        //这里的height相当于要模糊图片的width（x轴），默认从0开始，我们修改这里的开始值，就能定义模糊位置
        if (type == 2) {
            y = height/3;
        }
 
        for(; y < height; ++y) {
            int index = y;
            int ioffset = y * width;
 
            for(int x = 0; x < width; ++x) {
                float r = 0.0F;
                float g = 0.0F;
                float b = 0.0F;
                float a = 0.0F;
                int moffset = cols2;
 
                int ia;
                int ix;
                int rgb;
                for(ia = -cols2; ia <= cols2; ++ia) {
                    float f = matrix[moffset + ia];
                    if (f != 0.0F) {
                        ix = x + ia;
                        if (ix < 0) {
                            if (edgeAction == CLAMP_EDGES) {
                                ix = 0;
                            } else if (edgeAction == WRAP_EDGES) {
                                ix = (x + width) % width;
                            }
                        } else if (ix >= width) {
                            if (edgeAction == CLAMP_EDGES) {
                                ix = width - 1;
                            } else if (edgeAction == WRAP_EDGES) {
                                ix = (x + width) % width;
                            }
                        }
 
                        rgb = inPixels[ioffset + ix];
                        int pa = rgb >> 24 & 255;
                        int pr = rgb >> 16 & 255;
                        int pg = rgb >> 8 & 255;
                        int pb = rgb & 255;
                        if (premultiply) {
                            float a255 = (float)pa * 0.003921569F;
                            pr = (int)((float)pr * a255);
                            pg = (int)((float)pg * a255);
                            pb = (int)((float)pb * a255);
                        }
 
                        a += f * (float)pa;
                        r += f * (float)pr;
                        g += f * (float)pg;
                        b += f * (float)pb;
                    }
                }
 
                if (unpremultiply && a != 0.0F && a != 255.0F) {
                    float f = 255.0F / a;
                    r *= f;
                    g *= f;
                    b *= f;
                }
              //  ia = alpha ? PixelUtils.clamp(((double)a + 0.5D)) : 255;
               // PixelUtils.RgbToGray();
//                ia = alpha ? PixelUtils.clamp((int)((double)a + 0.5D)) : 255;
//                int ir = PixelUtils.clamp((int)((double)r + 0.5D));
//                ix = PixelUtils.clamp((int)((double)g + 0.5D));
//                rgb = PixelUtils.clamp((int)((double)b + 0.5D));
//                outPixels[index] = ia << 24 | ir << 16 | ix << 8 | rgb;
                index += height;
            }
        }
 
    }
 
}
