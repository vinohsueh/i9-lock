package org.i9.lock.platform.dao.pageQueryDto;

import org.i9.lock.platform.dao.vo.PageListDto;

/** 
 * 创建时间：2017年12月26日 上午10:42:29
 * @author  lby
 * @version  
 * 
 */
public class ManagerPageDto extends PageListDto{
    private String usename;

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }
    
}
