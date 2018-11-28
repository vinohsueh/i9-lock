package org.i9.lock.platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.i9.lock.platform.dao.CardDao;
import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.PasswordDao;
import org.i9.lock.platform.dao.UserDao;
import org.i9.lock.platform.dao.vo.LockReleaseDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.dao.vo.LockUpdateDto;
import org.i9.lock.platform.dao.vo.SyncLockDto;
import org.i9.lock.platform.dao.vo.UserLongPasswordDto;
import org.i9.lock.platform.model.Card;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建时间：2017年11月22日 下午4:38:13
 * 
 * @author lby
 * @version
 * 
 */
@Service
@Transactional
public class LockServiceImpl implements LockService {

    @Autowired
    private LockDao lockDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordDao passwordDao;
    
    @Autowired
    private CardDao cardDao;

    @Override
    public void addLock(Lock lock) throws BusinessException {
        try {
            lock.setCreateTime(new Date());
            lock.setSynTime(new Date());
            lockDao.addLock(lock);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "添加锁失败", e.getMessage());
        }
    }

    @Override
    public void updateLock(Lock lock) throws BusinessException {
        try {
            lockDao.updateLock(lock);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "更新锁失败", e.getMessage());
        }

    }

    @Override
    public void deleteLock(Long id) throws BusinessException {
        try {
            lockDao.deleteLock(id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "删除锁失败", e.getMessage());
        }
    }

    @Override
    public Lock getLockById(Long id) throws BusinessException {
        try {
            return lockDao.getLockById(id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "根据id查询锁失败", e.getMessage());
        }
    }

    @Override
    public Lock getLockByLockname(String lockname) throws BusinessException {
        try {
            return lockDao.getLockByLockname(lockname);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "根据锁名查询锁失败", e.getMessage());
        }
    }

    @Override
    public PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto, int currectPage, int pageSize)
            throws BusinessException {
        try {
            return lockDao.selectByLimitPage(lockSearchDto, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "分页查询锁失败", e.getMessage());
        }
    }

    @Override
    public void releaseLockValidate(LockReleaseDto lockReleaseDto) throws BusinessException {
        try {
            Lock lock = lockDao.getLockById(lockReleaseDto.getLockId());
            if (lock == null) {
                throw new BusinessException(ErrorCode.RECEIVE_DATA_ERROR, "锁id错误");
            }
            User user = userDao.getUserById(lock.getUserId());

            // 验证输入的房主信息和锁信息和数据库的是否匹配
            if (lock != null && user != null) {
                if (!user.getPhone().equals(lockReleaseDto.getPhone())) {
                    throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR, "房主用户名错误");
                }
                String md5Password = StringUtil.MD5(lockReleaseDto.getPassword());
                if (!md5Password.equals(user.getPassword())) {
                    throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR, "房主密码错误");
                }
                if (!String.valueOf(lock.getKeyAdmin()).equals(lockReleaseDto.getKeyAdmin())) {
                    throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR, "锁具码错误");
                }
            } else {
                throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR, "该门锁已被移交");
            }
        } catch (BusinessException e) {
            throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "查询锁和用户失败", e.getMessage());
        }

    }

    @Override
    public void releaseLock(Long lockId) throws BusinessException {
        try {
            lockDao.deleteLock(lockId);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "移交锁具失败", e.getMessage());
        }
    }

    @Override
    public PageBounds<Lock> selectAuthorizeLocks(LockSearchDto lockSearchDto, int currectPage, int pageSize)
            throws BusinessException {
        try {
            return lockDao.selectAuthorizeLocks(lockSearchDto, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "查询租户已授权的锁具失败", e.getMessage());
        }
    }

    @Override
    public List<Lock> selectByExample(LockExample example) throws BusinessException {
        try {
            return lockDao.selectByExample(example);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "条件查询锁具失败", e.getMessage());
        }
    }

    @Override
    public Integer selectCount() throws BusinessException {
        try {
            return lockDao.selectCount();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Lock> selectByLockDto(LockSearchDto lockSearchDto) throws BusinessException {
        try {
            return lockDao.selectByLockDto(lockSearchDto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Lock> selectByLockKeyDto(LockSearchDto lockSearchDto) throws BusinessException {
        try {
            return lockDao.selectByLockKeyDto(lockSearchDto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateDepartmentType(Integer lockId, Integer departmentType) {
        try {
            lockDao.updateDepartmentType(lockId, departmentType);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateLocks(Lock lock) {
        try {
            lockDao.updateLocks(lock);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateClickLock(Integer lockId, Integer clickLock) throws BusinessException {
        try {
            lockDao.updateClickLock(lockId, clickLock);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public String getLockWarnTime(Long lockId) throws BusinessException {
        try {
            return lockDao.getLockWarnTime(lockId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Date getKeyAdminUptime(Long lockId) throws BusinessException {
        try {
            return lockDao.getKeyAdminUptime(lockId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateLockes(LockUpdateDto lockDto) throws BusinessException {
        try {
            lockDao.updateLockes(lockDto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public String getPwdByUidAndLockId(UserLongPasswordDto userLongPassword) throws BusinessException {
        try {
            return lockDao.getPwdByUidAndLockId(userLongPassword);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void insertPwdByUidAndLockId(UserLongPasswordDto userLongPassword) throws BusinessException {
        try {
            lockDao.insertPwdByUidAndLockId(userLongPassword);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deletePwdByUidAndLockId(UserLongPasswordDto userLongPassword) throws BusinessException {
        try {
            lockDao.deletePwdByUidAndLockId(userLongPassword);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void insertClickByUidAndLockId(UserLongPasswordDto userLongPassword) throws BusinessException {
        try {
            lockDao.insertClickByUidAndLockId(userLongPassword);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Integer getClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto) throws BusinessException {
        try {
            return lockDao.getClickByUidAndLockId(userLongPasswordDto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto) throws BusinessException {
        try {
            lockDao.updateClickByUidAndLockId(userLongPasswordDto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto) throws BusinessException {
        try {
            lockDao.deleteClickByUidAndLockId(userLongPasswordDto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void syncLockPwd(SyncLockDto syncLockDto) throws BusinessException {
        try {
            //1.1 根据lockID，userID查询用户相关密码组
            List<Integer> pwdSelectList = passwordDao.selectExistOrderNumber3(syncLockDto.getLockId(),
                    syncLockDto.getUserId());
            //2.1把相关值转换为1或0
            ArrayList<Integer> pwdList = StringUtil.pwdToBinary(pwdSelectList);
            //3.1 将接受的 Stringpwd转化为集合pwdAcceptList
            ArrayList<Integer> pwdAcceptList = StringUtil.StringArrayToArrayList(syncLockDto.getFingerPwd());
            //4.1 将pwdAcceptList与pwdList进行比对，为1则新增，为0则删除
            this.checkPwdOrderNumber(pwdList, syncLockDto, pwdAcceptList);
        } catch (Exception e) {
            throw new BusinessException("匹对指纹锁密码失败",e.getMessage());
        }
    }
    
    @Override
    public void syncICCard(SyncLockDto syncLockDto) throws BusinessException {
        try {
            //1.1 根据lockID，userID查询用户相关密码组
            List<Integer> pwdSelectList = cardDao.selectExistOrderNumber2(syncLockDto.getLockId(),
                    syncLockDto.getUserId());
            //2.1把相关值转换为1或0
            ArrayList<Integer> pwdList = StringUtil.pwdToBinary(pwdSelectList);
            //3.1 将接受的 Stringpwd转化为集合pwdAcceptList
            ArrayList<Integer> pwdAcceptList = StringUtil.StringArrayToArrayList(syncLockDto.getIcCardPwd());
            //4.1 将pwdAcceptList与pwdList进行比对，为1则新增，为0则删除
            this.checkPwdOrderNumber2(pwdList, syncLockDto, pwdAcceptList);
        } catch (Exception e) {
            throw new BusinessException("匹对Ic卡用户组失败",e.getMessage());
        }
    }
    
    public void checkPwdOrderNumber(List<Integer> pwdSelectList,SyncLockDto syncLockDto,
            ArrayList<Integer> pwdAcceptList){
        ArrayList<Password> pwdSameList = new ArrayList<Password>();
        ArrayList<Integer> unPwdSameList = new ArrayList<Integer>();
        for(int i=0;i<pwdAcceptList.size();i++) {
            Password password = new Password();
            if(pwdAcceptList.get(i) !=pwdSelectList.get(i) && pwdAcceptList.get(i) ==0) {
                unPwdSameList.add(i);
            }else if(pwdAcceptList.get(i) !=pwdSelectList.get(i) && pwdAcceptList.get(i) ==1) {
                password.setLockId(syncLockDto.getLockId());
                password.setUserId(syncLockDto.getUserId());
                password.setName("第"+(i+1)+"组密码");
                password.setOrderNumber(i);
                pwdSameList.add(password);
            }
        }
        try {
            if(pwdSameList.size()>0) {
                passwordDao.insertPwdByLockIdAndUserId(pwdSameList);
            }
            if(unPwdSameList.size()>0) {
                passwordDao.delPwdByLockIdAndUserId(syncLockDto.getLockId(),syncLockDto.getUserId(),unPwdSameList);
            }
        } catch (Exception e) {
            throw new BusinessException("校对指纹密码组失败",e.getMessage());
        }
    }
    
    public void checkPwdOrderNumber2(List<Integer> pwdSelectList,SyncLockDto syncLockDto,
            ArrayList<Integer> pwdAcceptList){
        ArrayList<Card> pwdSameList = new ArrayList<Card>();
        ArrayList<Integer> unPwdSameList = new ArrayList<Integer>();
        for(int i=0;i<pwdAcceptList.size();i++) {
            Card card = new Card();
            if(pwdAcceptList.get(i) !=pwdSelectList.get(i) && pwdAcceptList.get(i) ==0) {
                unPwdSameList.add(i);
            }else if(pwdAcceptList.get(i) !=pwdSelectList.get(i) && pwdAcceptList.get(i) ==1) {
                card.setLockId(syncLockDto.getLockId());
                card.setUserId(syncLockDto.getUserId());
                card.setName("第"+(i+1)+"组IC卡");
                card.setOrderNumber(i);
                pwdSameList.add(card);
            }
        }
        try {
            if(pwdSameList.size()>0) {
                cardDao.insertPwdByLockIdAndUserId(pwdSameList);
            }
            if(unPwdSameList.size()>0) {
                cardDao.delPwdByLockIdAndUserId(syncLockDto.getLockId(),syncLockDto.getUserId(),unPwdSameList);
            }
        } catch (Exception e) {
            throw new BusinessException("校对IC卡密码组失败",e.getMessage());
        }
    }
}
