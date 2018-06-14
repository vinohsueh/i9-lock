package org.i9.lock.platform.dao.vo;

import java.math.BigDecimal;

public class PriceDto {
	 /**
     * 电表数
     */
    private Double eleNumber;
    
    /**
     * 燃气数
     */
    private Double gasNumber;
    
    /**
     * 水表数
     */
    private Double waterNumber;
    
    /**
     * 电费单价
     */
    private BigDecimal elePrice;
    
    /**
     * 燃气价格单价
     */
    private BigDecimal gasPrice;
    
    /**
     * 水费单价
     */
    private BigDecimal waterPrice;
    
    /**
     * 物业费
     */
    private BigDecimal propertyPrice;
	
    private Integer userId;

    private Integer lockId;

	public Double getEleNumber() {
		return eleNumber;
	}

	public void setEleNumber(Double eleNumber) {
		this.eleNumber = eleNumber;
	}

	public Double getGasNumber() {
		return gasNumber;
	}

	public void setGasNumber(Double gasNumber) {
		this.gasNumber = gasNumber;
	}

	public Double getWaterNumber() {
		return waterNumber;
	}

	public void setWaterNumber(Double waterNumber) {
		this.waterNumber = waterNumber;
	}

	public BigDecimal getElePrice() {
		return elePrice;
	}

	public void setElePrice(BigDecimal elePrice) {
		this.elePrice = elePrice;
	}

	public BigDecimal getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(BigDecimal gasPrice) {
		this.gasPrice = gasPrice;
	}

	public BigDecimal getWaterPrice() {
		return waterPrice;
	}

	public void setWaterPrice(BigDecimal waterPrice) {
		this.waterPrice = waterPrice;
	}

	public BigDecimal getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(BigDecimal propertyPrice) {
		this.propertyPrice = propertyPrice;
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
    
	/**
	 * 总电费
	 */
	public BigDecimal getElePrices(){
		BigDecimal d1ToStrToBigDe = new BigDecimal(String.valueOf(eleNumber)); 
		return elePrice.multiply(d1ToStrToBigDe);
	}
	
	/**
	 * 总燃气费
	 */
	public BigDecimal getGasPrices(){
		BigDecimal d1ToStrToBigDe = new BigDecimal(String.valueOf(gasNumber)); 
		return gasPrice.multiply(d1ToStrToBigDe);
	}
	
	/**
	 * 总水费
	 */
	public BigDecimal getWaterPrices(){
		BigDecimal d1ToStrToBigDe = new BigDecimal(String.valueOf(waterNumber)); 
		return waterPrice.multiply(d1ToStrToBigDe);
	}
}
