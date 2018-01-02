package org.i9.lock.platform.dao.vo;

import java.io.Serializable;

/** 
 * 创建时间：2017年11月6日 上午10:43:30
 * @author  lby
 * @version  
 * 
 */
public class UserSearchDto extends PageListDto implements Serializable{
    
    /**
     * <code>serialVersionUID</code> - 
     */
    private static final long serialVersionUID = 144890267006805792L;

    
    private String username;
    
    private String phone;

    private String familyPhone;
    
    private String orderByClause;
    
    

    public String getOrderByClause() {
        return orderByClause;
    }


    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFamilyPhone() {
		return familyPhone;
	}


	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
    
    
    
}
