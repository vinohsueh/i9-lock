package org.i9.lock.platform.dao.vo;

/**
 * 同步锁具
* @ClassName: SyncLockDto
* @author xph
* @date 2018年11月26日
 */
public class SyncLockDto {
    
    /*
     * 锁id
     */
    private int lockId;
    
    /**
     * 用户组编号
     */
    private int userNumber;
    
    /**
     * 指纹密码组
     */
    private String fingerPwd;
    
    /**
     * ic卡密码组
     */
    private String icCardPwd;
    
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getLockId() {
        return lockId;
    }

    public void setLockId(int lockId) {
        this.lockId = lockId;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getFingerPwd() {
        return fingerPwd;
    }

    public void setFingerPwd(String fingerPwd) {
        this.fingerPwd = fingerPwd;
    }

    public String getIcCardPwd() {
        return icCardPwd;
    }

    public void setIcCardPwd(String icCardPwd) {
        this.icCardPwd = icCardPwd;
    }
    
}
