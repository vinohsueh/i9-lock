package org.i9.lock.platform.dao.enums;

import java.util.ArrayList;
import java.util.List;

/** 
 * 创建时间：2017年11月28日 上午9:27:56
 * @author  lby
 * @version  
 * 
 */
public enum PasswordTypeEnum {
    PWD((byte)0,"密码"),LOOPS((byte)1,"指纹"),ALL((byte)2,"密码和指纹");
    
    private static final List<PasswordTypeEnum> TYPES = new ArrayList<PasswordTypeEnum>();
    
    static{
        TYPES.add(PWD);
        TYPES.add(LOOPS);
        TYPES.add(ALL);
    }
    
    private PasswordTypeEnum(byte id,String name){
        this.id = id;
        this.name = name;
    } 
    
    private byte id;
    
    private String name;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<PasswordTypeEnum> getTypes() {
        return TYPES;
    }
    
    public static String getNameById(short id){
        for (PasswordTypeEnum passwordTypeEnum : PasswordTypeEnum.values()) {
            if (passwordTypeEnum.getId() == id) {
                return passwordTypeEnum.getName();
            }
        }
        return "";
    }
    public static Byte getIdByName(String name){
        for (PasswordTypeEnum passwordTypeEnum : PasswordTypeEnum.values()) {
            if (passwordTypeEnum.getName().equals(name)) {
                return passwordTypeEnum.getId();
            }
        }
        return null;
    }
    
}
