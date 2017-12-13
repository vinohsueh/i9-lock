package org.i9.lock.platform.dao.vo;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 创建时间：2017年11月30日 下午2:35:22
 * @author  lby
 * @version  
 * 
 */
public class LockAddDto {
    @NotBlank(message="keyAdmin不能为空")
    private String keyAdmin;
    
    @NotBlank(message="名字不能为空") 
    private String name;
    
    @NotBlank(message="keyNumber不能为空")
    private String keyNumber;
    
    @NotBlank(message="keyDev不能为空")
    private String keyDev;
    
    @NotBlank(message="keyUser不能为空")
    private String keyUser;
    
    
    
    public String getKeyUser() {
        return keyUser;
    }

    public void setKeyUser(String keyUser) {
        this.keyUser = keyUser;
    }

    public String getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(String keyNumber) {
        this.keyNumber = keyNumber;
    }

    public String getKeyDev() {
        return keyDev;
    }

    public void setKeyDev(String keyDev) {
        this.keyDev = keyDev;
    }

    public String getKeyAdmin() {
        return keyAdmin;
    }

    public void setKeyAdmin(String keyAdmin) {
        this.keyAdmin = keyAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
