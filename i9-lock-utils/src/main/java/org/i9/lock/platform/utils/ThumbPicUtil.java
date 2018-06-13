package org.i9.lock.platform.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;

/** 
* 创建时间：2018年6月1日 上午11:11:28
* @author  lby
* @version  
* 
*/
public class ThumbPicUtil {
		
	private static final Logger logger = LoggerFactory.getLogger(ThumbPicUtil.class);
	
	/** 
     * 根据指定大小和指定精度压缩图片 
     *  
     * @param srcPath 
     *            源图片地址 
     * @param desPath 
     *            目标图片地址 
     * @param desFilesize 
     *            指定图片大小，单位kb 
     * @param accuracy 
     *            精度，递归压缩的比率，建议小于0.9 
     * @return 
     */  
    public static String commpressPicForScale(InputStream uploadFileInputStream, String desPath,  
            long desFileSize, double accuracy) {  
        if (uploadFileInputStream == null) {  
            return null;  
        }  
        try {  
            // 1、先转换成jpg  
            Thumbnails.of(uploadFileInputStream).scale(1f).toFile(desPath);  
            // 递归压缩，直到目标文件大小小于desFileSize  
            commpressPicCycle(desPath, desFileSize, accuracy);  
  
            File desFile = new File(desPath);  
            logger.info("目标图片：" + desPath + "，大小" + desFile.length()  
                    / 1024 + "kb");  
            logger.info("图片压缩完成！");  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
        return desPath;  
    }  
  
    private static void commpressPicCycle(String desPath, long desFileSize,  
            double accuracy) throws IOException {  
        File srcFileJPG = new File(desPath);  
        long srcFileSizeJPG = srcFileJPG.length();  
        // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩  
        if (srcFileSizeJPG <= desFileSize * 1024) {  
            return;  
        }  
        // 计算宽高  
        BufferedImage bim = ImageIO.read(srcFileJPG);  
        int srcWdith = bim.getWidth();  
        int srcHeigth = bim.getHeight();  
        int desWidth = new BigDecimal(srcWdith).multiply(  
                new BigDecimal(accuracy)).intValue();  
        int desHeight = new BigDecimal(srcHeigth).multiply(  
                new BigDecimal(accuracy)).intValue();  
  
        Thumbnails.of(desPath).size(desWidth, desHeight)  
                .outputQuality(accuracy).toFile(desPath);  
        commpressPicCycle(desPath, desFileSize, accuracy);  
    }  
}
