package org.i9.lock.platform.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 字符串工具
 * 
 * 
 * @author lby
 *
 * @create 2017年8月17日
 *
 */
public class StringUtil {
    
    private static final String LOG_1 = "领取了";
    
    private static final String LOG_2 = "的钥匙";
    
    
    public static String MD5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }
    public static void main(String[] args) {
        System.out.println(MD5("12345678"));
    }
    /**
     * 日期转换
     * 
     * @param date
     * @return
     */
    public static String dateToStringWithoutTime(Date date) {
        if (null != date) {
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");
            return sdm.format(date);
        } else {
            return "";
        }
    }
    
    /**
     * 日期转换
     * 
     * @param date
     * @return
     */
    public static String dateToStringToS(Date date) {
        if (null != date) {
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdm.format(date);
        } else {
            return "-";
        }
    }    
    /**
     * 日期转换
     * @param date
     * @param rep
     * @return
     */
    public static String dateToStringByRep(Date date,String rep) {
        if (null != date) {
            SimpleDateFormat sdm = new SimpleDateFormat(rep);
            return sdm.format(date);
        } else {
            return "";
        }
    }
    
    /**
     * 生成领取钥匙的锁日志
     */
    public static String getLockLog(String username, String name) {
        return username+LOG_1+name+LOG_2;
    }
    /*
     * 测试2018年1月2日 10:52:05
     */
	public static String datetoLong(Date date) {
		if(null !=date) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
			String dateString = simpleDateFormat.format(date);
			return dateString;
		}else {
			return "";
		}
	}
	
	/***
	 * String（Integer）转成List
	* @Title: StringArrayToArrayList
	* @param @param str
	* @param @return
	 */
	public static ArrayList<Integer> StringArrayToArrayList(String str){
	    ArrayList<Integer> pwdAcceptList = new ArrayList<Integer>();
	    String[] pwdAcceptArray =str.split(",");
	    for(int i=0;i<pwdAcceptArray.length;i++) {
            pwdAcceptList.add(Integer.parseInt(pwdAcceptArray[i]));
        }
	    return pwdAcceptList;
	}
	
	/**
	 * 密码组转成二进制
	* @Title: pwdToBinary
	* @param @param pwdSelectList
	* @param @return
	 */
	public static ArrayList<Integer> pwdToBinary(List<Integer> pwdSelectList){
	    ArrayList<Integer> pwdList = new ArrayList<Integer>(); 
        for(int i=0;i<10;i++) {
            if(!pwdSelectList.contains(i)) {
                pwdList.add(0);
            }else {
                pwdList.add(1);
            }
        }
        return pwdList;
	}
}
