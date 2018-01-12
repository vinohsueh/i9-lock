package org.i9.lock.platform.dao.vo;

import java.util.Comparator;

import org.i9.lock.platform.model.Password;

/** 
 * 创建时间：2018年1月3日 下午5:10:33
 * @author  lby
 * @version  
 * 
 */
public class PasswordComparator implements Comparator<Password>{

    @Override
    public int compare(Password o1, Password o2) {
        if (o1.getOrderNumber() > o2.getOrderNumber()) {
            return 1;
        } else if(o1.getOrderNumber() < o2.getOrderNumber()){
            return -1;
        } else {
            return 0;
        }
    }

}
