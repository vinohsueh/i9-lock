package org.i9.lock.platform.model;

import java.math.BigDecimal;

public class Price {
    private Integer id;

    private BigDecimal elePrices;

    private BigDecimal gasPrices;

    private BigDecimal waterPrices;

    private BigDecimal propertyPrices;

    private Integer userId;

    private Integer lockId;

    private Integer lockeyId;
    
    private User user;
    
    private LockKey lockKey;
    
    private Lock lock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getElePrices() {
        return elePrices;
    }

    public void setElePrices(BigDecimal elePrices) {
        this.elePrices = elePrices;
    }

    public BigDecimal getGasPrices() {
        return gasPrices;
    }

    public void setGasPrices(BigDecimal gasPrices) {
        this.gasPrices = gasPrices;
    }

    public BigDecimal getWaterPrices() {
        return waterPrices;
    }

    public void setWaterPrices(BigDecimal waterPrices) {
        this.waterPrices = waterPrices;
    }

    public BigDecimal getPropertyPrices() {
        return propertyPrices;
    }

    public void setPropertyPrices(BigDecimal propertyPrices) {
        this.propertyPrices = propertyPrices;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public Integer getLockeyId() {
        return lockeyId;
    }

    public void setLockeyId(Integer lockeyId) {
        this.lockeyId = lockeyId;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LockKey getLockKey() {
		return lockKey;
	}

	public void setLockKey(LockKey lockKey) {
		this.lockKey = lockKey;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
}