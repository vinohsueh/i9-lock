package org.i9.lock.platform.dao.vo;

import java.util.Comparator;

import org.i9.lock.platform.model.LockKey;

/** 
 * 创建时间：2018年1月9日 上午10:26:56
 * @author  lby
 * @version  
 * 
 */
public class LockKeyComparator implements Comparator<LockKey>{

    @Override
    public int compare(LockKey o1, LockKey o2) {
        if (o1.getEndTime().getTime() > o2.getEndTime().getTime()) {
            return 1;
        } else if(o1.getEndTime().getTime() < o2.getEndTime().getTime()){
            return -1;
        } else {
            return 0;
        }
    }

}
