package org.i9.lock.platform.dao.vo;
/** 
 * 创建时间：2018年1月3日 下午3:49:54
 * @author  lby
 * @version  
 * 
 */
public class InfoSearchDto {
    
    private Long userId;
    
    private String orderByClause;
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
}
