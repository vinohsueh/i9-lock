package org.i9.lock.platform.dao.enums;

import java.util.ArrayList;
import java.util.List;

/** 
 * 创建时间：2017年11月28日 上午9:27:56
 * @author  lby
 * @version  
 * 
 */
public enum HireTypeEnum {
    MONTH((byte)1,"月"),DAY((byte)2,"日"),HOUR((byte)3,"时");
    
    private static final List<HireTypeEnum> TYPES = new ArrayList<HireTypeEnum>();
    
    static{
        TYPES.add(MONTH);
        TYPES.add(DAY);
        TYPES.add(HOUR);
    }
    
    private HireTypeEnum(byte id,String name){
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

    public static List<HireTypeEnum> getTypes() {
        return TYPES;
    }
    
    public static String getNameById(short id){
        for (HireTypeEnum hireTypeEnum : HireTypeEnum.values()) {
            if (hireTypeEnum.getId() == id) {
                return hireTypeEnum.getName();
            }
        }
        return "";
    }
    public static Byte getIdByName(String name){
        for (HireTypeEnum hireTypeEnum : HireTypeEnum.values()) {
            if (hireTypeEnum.getName().equals(name)) {
                return hireTypeEnum.getId();
            }
        }
        return null;
    }
    
}
