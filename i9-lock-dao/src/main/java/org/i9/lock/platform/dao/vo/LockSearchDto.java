    package org.i9.lock.platform.dao.vo;
/** 
 * 创建时间：2017年11月22日 下午4:13:49
 * @author  lby
 * @version  
 * 
 */
public class LockSearchDto {
    
    private Long userId;
    
    private String orderByClause;
    
    
    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}
