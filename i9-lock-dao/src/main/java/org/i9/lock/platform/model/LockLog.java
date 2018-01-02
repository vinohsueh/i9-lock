package org.i9.lock.platform.model;

import java.util.Date;

import org.i9.lock.platform.utils.DateUtils;

/**
 * 锁日志实体类
 * 
 * 
 * @author lby
 *
 * @create 2017年12月26日
 *
 */
public class LockLog {
    private Integer id;
    
    /**
     * 锁id
     */
    private Long lockId;
    
    /**
     * 操作人id
     */
    private Long userId;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    private Short operation;
    
    /**
     * 操作内容
     */
    private String content;
    
    private String username;
    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getLockId() {
        return lockId;
    }

    public void setLockId(Long lockId) {
        this.lockId = lockId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getOperation() {
        return operation;
    }

    public void setOperation(Short operation) {
        this.operation = operation;
    }
    
    public String getTimeString() {
        return DateUtils.dateToString(createTime);
    } 
}