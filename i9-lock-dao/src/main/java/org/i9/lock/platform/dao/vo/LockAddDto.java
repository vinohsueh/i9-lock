package org.i9.lock.platform.dao.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 创建时间：2017年11月30日 下午2:35:22
 * @author  lby
 * @version  
 * 
 */
public class LockAddDto {
    
    @NotBlank(message="锁具码不能为空") 
    @Pattern(regexp="^[0-9]{8}$",message="请输入8个数字")
    private String keyAdmin;
    
    @NotBlank(message="名字不能为空") 
    private String name;

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
