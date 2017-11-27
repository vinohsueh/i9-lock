package org.i9.lock.platform.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * 创建时间：2017年11月27日 上午11:39:53
 * @author  lby
 * @version  
 * 
 */
public class DateUtils {
    public static String dateToString(Date date) {
        if (null != date) {
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            return sdm.format(date);
        } else {
            return "";
        }
    }
}
