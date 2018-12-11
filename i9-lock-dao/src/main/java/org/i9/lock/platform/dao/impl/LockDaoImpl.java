package org.i9.lock.platform.dao.impl;

import java.util.Date;
import java.util.List;

import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.mapper.LockMapper;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.dao.vo.LockUpdateDto;
import org.i9.lock.platform.dao.vo.UserLongPasswordDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2017年11月22日 下午4:31:09
 * @author  lby
 * @version  
 * 
 */
@Repository
public class LockDaoImpl implements LockDao{

    @Autowired
    private LockMapper lockMapper;
    
    @Override
    public void addLock(Lock lock) throws Exception {
        lockMapper.insertSelective(lock);
    }

    @Override
    public void updateLock(Lock lock) throws Exception {
        lockMapper.updateByPrimaryKeySelective(lock);
    }

    @Override
    public void deleteLock(Long id) throws Exception {
        lockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Lock getLockById(Long id) throws Exception {
        return lockMapper.selectByPrimaryKey(id);
    }

    @Override
    public Lock getLockByLockname(String lockname) throws Exception {
        LockExample example = new LockExample();
        example.createCriteria().andNameEqualTo(lockname);
        List<Lock> list = lockMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = lockMapper.countByExample(lockSearchDto);
        PageBounds<Lock> pageBounds = new PageBounds<Lock>(currectPage, totalSize, pageSize);
        List<Lock> list = lockMapper.selectByLimitPage(lockSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

    @Override
    public void releaseLock(Long id) throws Exception {
        lockMapper.releaseLock(id);
    }

    @Override
    public PageBounds<Lock> selectAuthorizeLocks(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) {
        final int totalSize = lockMapper.countAuthorizeLocks(lockSearchDto);
        PageBounds<Lock> pageBounds = new PageBounds<Lock>(currectPage, totalSize, pageSize);
        List<Lock> list = lockMapper.selectAuthorizeLocks(lockSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

    @Override
    public List<Lock> selectByExample(LockExample example) throws Exception {
        return lockMapper.selectByExample(example);
    }

    @Override
    public Integer selectCount() throws Exception {
        LockSearchDto lockSearchDto = new LockSearchDto();
        return lockMapper.countByExample(lockSearchDto);
    }

	@Override
	public List<Lock> selectByLockDto(LockSearchDto lockSearchDto) throws Exception {
		return lockMapper.selectByLockDto(lockSearchDto);
	}

	@Override
	public List<Lock> selectByLockKeyDto(LockSearchDto lockSearchDto) throws Exception {
		return lockMapper.selectByLockKeyDto(lockSearchDto);
	}

	@Override
	public void updateDepartmentType(Integer lockId, Integer departmentType) {
		lockMapper.updateDepartmentType(lockId,departmentType);
	}

	@Override
	public void updateLocks(Lock lock) {
		lockMapper.updateLocks(lock);
	}

	@Override
	public void updateClickLock(Integer lockId, Integer clickLock) {
		lockMapper.updateClickLock(lockId,clickLock);
	}

	@Override
	public String getLockWarnTime(Long lockId) throws Exception {
		return lockMapper.getLockWarnTime(lockId);
	}

	@Override
	public Date getKeyAdminUptime(Long lockId) throws Exception {
		return lockMapper.getKeyAdminUptime(lockId);
	}

	@Override
	public void updateLockes(LockUpdateDto lockDto) throws Exception {
		lockMapper.updateLockes(lockDto);		
	}

	@Override
	public String getPwdByUidAndLockId(UserLongPasswordDto userLongPassword) throws Exception {
		return lockMapper.getPwdByUidAndLockId(userLongPassword);
	}

	@Override
	public void insertPwdByUidAndLockId(UserLongPasswordDto userLongPassword) throws Exception {
		lockMapper.insertPwdByUidAndLockId(userLongPassword);
	}

	@Override
	public void deletePwdByUidAndLockId(UserLongPasswordDto userLongPassword) throws Exception {
		lockMapper.deletePwdByUidAndLockId(userLongPassword);
	}

	@Override
	public void insertClickByUidAndLockId(UserLongPasswordDto userLongPassword) throws Exception {
		lockMapper.insertClickByUidAndLockId(userLongPassword);
	}

	@Override
	public Integer getClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto) throws Exception {
		return lockMapper.getClickByUidAndLockId(userLongPasswordDto);
	}

	@Override
	public void updateClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto) throws Exception {
		lockMapper.updateClickByUidAndLockId(userLongPasswordDto);
	}

	@Override
	public void deleteClickByUidAndLockId(UserLongPasswordDto userLongPasswordDto) throws Exception {
		lockMapper.deleteClickByUidAndLockId(userLongPasswordDto);
	}

    @Override
    public void updateById(Lock lock) throws Exception {
        lockMapper.updateByPrimaryKey(lock);
    }

}
