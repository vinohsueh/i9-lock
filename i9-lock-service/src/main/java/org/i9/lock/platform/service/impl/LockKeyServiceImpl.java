package org.i9.lock.platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.i9.lock.platform.dao.ConfigDao;
import org.i9.lock.platform.dao.InfoDao;
import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.LockKeyDao;
import org.i9.lock.platform.dao.LockLogDao;
import org.i9.lock.platform.dao.UserDao;
import org.i9.lock.platform.dao.enums.HireTypeEnum;
import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.Constants;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.PushUtils;
import org.i9.lock.platform.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建时间：2017年11月29日 下午3:37:39
 * 
 * @author lby
 * @version
 * 
 */
@Service
@Transactional
public class LockKeyServiceImpl implements LockKeyService {

    @Autowired
    private LockKeyDao lockKeyDao;

    @Autowired
    private LockDao lockDao;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private InfoDao infoDao;
    
    @Autowired
    private LockLogDao lockLogDao;

    @Autowired
    private ConfigDao configDao;
    private static final String INFO_MID = "的开门密码:";
    @Override
    public void addLockKey(LockKeyDto lockKeyDto) throws BusinessException {
        try {
            // 查询1-9的编号 最小未使用编号
            List<Integer> list = lockKeyDao.selectExistOrderNumber(lockKeyDto
                    .getLockId());
            //查询最大可用编号数
            Config config = configDao.selectMaxHirer();
            int max = config.getConfigValue();
            if (list.size() >= max-1) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,
                        "该锁租户已满,不能再添加了");
            }
            Integer orderNumber = selectOrderNumber(list,max);
            LockKey lockKey = lockKeyDto.getLockKey();
            // 将最小编号赋给钥匙
            lockKey.setOrderNumber(orderNumber);

            // 根据填写的手机号把用户id赋给钥匙
            User user = userDao.getUserByPhone(lockKeyDto.getHirerPhone());
            if (user == null) {
                throw new BusinessException(ErrorCode.CRUD_ERROR, "该手机号没有对应的用户");
            }
            lockKey.setUserId(user.getId());

            LockKey existLockKey = lockKeyDao.selectLockKeyByLockIdAndUserId(
                    lockKeyDto.getLockId(), user.getId());
            if (existLockKey != null) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"该用户已经是该房的租客,无法重复添加");
            }
            lockKey.setCreateTime(new Date());
            lockKeyDao.addLockKey(lockKey);
            // 更新锁的合租状态和安全模式
            Lock lock = lockDao.getLockById(lockKeyDto.getLockId());
            lock.setIfShared(lockKeyDto.getIfShare());
            lock.setSafeMode(lockKeyDto.getSafeMode());
            lockDao.updateLock(lock);
            
            //给输入的房客添加消息通知
            String infoContent = lock.getName()+INFO_MID+lockKeyDto.getPassword();
            Info info = new Info();
            info.setContent(infoContent);
            info.setCreateTime(new Date());
            info.setUserId(user.getId());
            infoDao.addInfo(info);
            //给输入的房客发送推送  开门密码
            PushUtils.sendPush(String.valueOf(user.getId()), infoContent);
            
            //生成锁日志
            LockLog lockLog = new LockLog();
            lockLog.setCreateTime(new Date());
            lockLog.setLockId(lock.getId());
            lockLog.setUserId(user.getId());
            lockLog.setContent(StringUtil.getLockLog(user.getUsername(),lock.getName()));
            lockLogDao.addLockLog(lockLog);
        } catch (BusinessException e) {
            throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * 查询1-9的编号 最小未使用编号
     * 
     * @param list
     * @return
     */
    private static Integer selectOrderNumber(List<Integer> list,int max) {
        //最大可用编号数集合
        List<Integer> maxArray = new ArrayList<Integer>();
        for (int i = 1; i < max; i++) {
            maxArray.add(i);
        }
        
        List<Integer> array = new ArrayList<Integer>();
        for (Integer integer : maxArray) {
            if (!array.contains(integer) && !list.contains(integer)) {
                array.add(integer);
            }
        }
        Integer orderNumber = Collections.min(array);
        return orderNumber;
    }

    @Override
    public void updateLockKey(LockKey lockKey) throws BusinessException {
        try {
            lockKeyDao.updateLockKey(lockKey);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteLockKey(Integer id) throws BusinessException {
        try {
            lockKeyDao.deleteLockKey(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public LockKey getLockKeyById(Integer id) throws BusinessException {
        try {
            return lockKeyDao.getLockKeyById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public PageBounds<LockKey> selectByLimitPage(LockKeyExample example,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return lockKeyDao.selectByLimitPage(example, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<LockKey> getLockKeyByLockId(Long lockId)
            throws BusinessException {
        try {
            return lockKeyDao.getLockKeyByLockId(lockId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateLockKeyByTwoId(LockKey lockKey) throws BusinessException {
        try {
            lockKeyDao.updateLockKeyByTwoId(lockKey);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public LockKey selectLockKeyByLockIdAndUserId(Long lockId, Long userId)
            throws BusinessException {
        try {
            return lockKeyDao.selectLockKeyByLockIdAndUserId(lockId, userId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateEndTime(LockKey lockKey) throws BusinessException {
        try {
            lockKeyDao.updateLockKey(lockKey);
            LockKey lockKey2 = lockKeyDao.getLockKeyById(lockKey.getId());
            Lock lock = lockDao.getLockById(lockKey2.getLockId());
            //生成锁日志
            LockLog lockLog = new LockLog();
            lockLog.setCreateTime(new Date());
            lockLog.setLockId(lockKey2.getLockId());
            SimpleDateFormat sdf = null;
            //设置日志内容
            String startDateString = null;
            String endDateString = null;
            if (lockKey.getHireType() == 2) {
                sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                startDateString = sdf.format(lockKey.getStartTime());
                endDateString = sdf.format(lockKey.getEndTime());
            }else{
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                startDateString = sdf.format(lockKey.getStartTime());
                endDateString = sdf.format(lockKey.getEndTime());
            }
            String content = lock.getName()+Constants.LOG_3+HireTypeEnum.getNameById(lockKey.getHireType())+Constants.LOG_4+startDateString+Constants.LOG_5+endDateString;
            lockLog.setContent(content);
            lockLogDao.addLockLog(lockLog);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        
    }

    @Override
    public void deleteAll(Long lockId) throws BusinessException {
        try {
            lockKeyDao.deleteAll(lockId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        
    }
}
