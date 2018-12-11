package org.i9.lock.platform.service;

import java.util.Date;
import java.util.List;

import org.i9.lock.platform.dao.vo.LockReleaseDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.dao.vo.LockUpdateDto;
import org.i9.lock.platform.dao.vo.SyncLockDto;
import org.i9.lock.platform.dao.vo.UserLongPasswordDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:37:52
 * @author  lby
 * @version  
 * 
 */
public interface LockService {
    /**
     * 添加锁
     * @param Lock
     * @throws BusinessException
     */
    void addLock(Lock lock) throws BusinessException;
    
    /**
     * 更新锁
     * @param Lock
     * @throws BusinessException
     */
    void updateLock(Lock lock) throws BusinessException;
    
    /**
     * 删除锁
     * @param kid
     * @throws BusinessException
     */
    void deleteLock(Long id) throws BusinessException;
    
    /**
     * 根据ID获取锁
     * @param kid
     * @return
     * @throws BusinessException
     */
    Lock getLockById(Long id) throws BusinessException;
    
    /**
     * 根据锁名搜索
     * @param Lockname
     * @return
     * @throws BusinessException
     */
    Lock getLockByLockname(String lockname) throws BusinessException;
    
    /**
     * 分页查询锁
     * @param LockSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) throws BusinessException;
    
    /**
     * 锁具移交验证
     * @param lockReleaseDto
     */
    void releaseLockValidate(LockReleaseDto lockReleaseDto) throws BusinessException;
    
    /**
     * 锁具移交
     * @param lockId
     */
    void releaseLock(Long lockId) throws BusinessException;
    
    /**
     * 选择租户已授权的锁具
     * @return
     */
    PageBounds<Lock> selectAuthorizeLocks(LockSearchDto lockSearchDto,
            int currectPage, int pageSize)throws BusinessException;
    
    /**
     * 条件查询锁
     * @param example
     * @return
     * @throws BusinessException
     */
    List<Lock> selectByExample(LockExample example) throws BusinessException;
    
    /**
     * 查询全部房东数量
     * @return
     * @throws BusinessException
     */
    Integer selectCount() throws BusinessException;
    
    /**
     * 房东条件查询锁
    * @Title: selectByLockDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
    * @throws BusinessException
     */
    List<Lock> selectByLockDto(LockSearchDto lockSearchDto) throws BusinessException;
    
    /**
     * 若是租户查询锁
    * @Title: selectByLockKeyDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
    * @throws BusinessException
     */
    List<Lock> selectByLockKeyDto(LockSearchDto lockSearchDto) throws BusinessException;
    
    /**
     * 更新租房类型
     */
	void updateDepartmentType(Integer lockId, Integer departmentType);

	/**
     * 修改房屋水电煤气费用单价
     */
	void updateLocks(Lock lock);
	 /**
     * 双击开锁
     */
	void updateClickLock(Integer lockId, Integer clickLock) throws BusinessException;
	
	String getLockWarnTime(Long lockId)throws BusinessException;
	 /**
     * 查询最近修改的keyAdmin的时间
     */
	Date getKeyAdminUptime(Long lockId)throws BusinessException;
	/**
     * 
     * 更换门锁
     */
	void updateLockes(LockUpdateDto lockDto)throws BusinessException;
	
	/**
	 * 查询
	* @Title: getPwdByUidAndLockId
	* @param @param userLongPassword
	* @param @return
	* @return String
	 */
	String getPwdByUidAndLockId(UserLongPasswordDto userLongPassword)throws BusinessException;
	
	/**
	 * 新增
	* @Title: insertPwdByUidAndLockId
	* @param @param userLongPassword
	* @param @throws BusinessException
	* @return void
	 */
	void insertPwdByUidAndLockId(UserLongPasswordDto userLongPassword)throws BusinessException;
	
	/**
	 * 删除
	* @Title: deletePwdByUidAndLockId
	* @param @param userLongPassword
	* @param @throws BusinessException
	* @return void
	 */
	void deletePwdByUidAndLockId(UserLongPasswordDto userLongPassword)throws BusinessException;
	
	/**
	 * 新增双认证
	* @Title: insertClickByUidAndLockId
	* @param @param userLongPassword
	* @param @throws BusinessException
	* @return void
	 */
	void insertClickByUidAndLockId(UserLongPasswordDto userLongPassword)throws BusinessException;
	
	/**
	 * 查询双认证
	* @Title: getClickByUidAndLockId
	* @param @param userLongPasswordDto
	* @param @return
	* @param @throws BusinessException
	* @return Integer
	 */
	Integer getClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto)throws BusinessException;
	
	/**
	 * 更新双认证
	* @Title: updateClickByUidAndLockId
	* @param @param userLongPasswordDto
	* @param @throws BusinessException
	* @return void
	 */
	void updateClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto)throws BusinessException;
	
	/**
	 * 删除双认证
	* @Title: deleteClickByUidAndLockId
	* @param @param userLongPasswordDto
	* @param @throws BusinessException
	* @return void
	 */
	void deleteClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto)throws BusinessException;
	
	/**
	 * 同步锁指纹密码
	* @Title: syncLockPwdAndIDcard
	* @param @param syncLockDto
	* @param @throws BusinessException
	 */
    void syncLockPwd(SyncLockDto syncLockDto)throws BusinessException;
	
    /**
     * 同步IcCard密码
    * @Title: syncICCard
    * @param @param syncLockDto
    * @param @throws BusinessException
     */
    void syncICCard(SyncLockDto syncLockDto)throws BusinessException;
    
    /**
     * 更新字段(全部)
    * @Title: updateById
    * @param @param lock
    * @param @throws BusinessException
     */
    void updateById(Lock lock)throws BusinessException;
}
