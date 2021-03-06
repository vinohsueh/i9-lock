package org.i9.lock.platform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class LockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKeyAdminIsNull() {
            addCriterion("keyAdmin is null");
            return (Criteria) this;
        }

        public Criteria andKeyAdminIsNotNull() {
            addCriterion("keyAdmin is not null");
            return (Criteria) this;
        }

        public Criteria andKeyAdminEqualTo(String value) {
            addCriterion("keyAdmin =", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminNotEqualTo(String value) {
            addCriterion("keyAdmin <>", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminGreaterThan(String value) {
            addCriterion("keyAdmin >", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminGreaterThanOrEqualTo(String value) {
            addCriterion("keyAdmin >=", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminLessThan(String value) {
            addCriterion("keyAdmin <", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminLessThanOrEqualTo(String value) {
            addCriterion("keyAdmin <=", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminLike(String value) {
            addCriterion("keyAdmin like", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminNotLike(String value) {
            addCriterion("keyAdmin not like", value, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminIn(List<String> values) {
            addCriterion("keyAdmin in", values, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminNotIn(List<String> values) {
            addCriterion("keyAdmin not in", values, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminBetween(String value1, String value2) {
            addCriterion("keyAdmin between", value1, value2, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andKeyAdminNotBetween(String value1, String value2) {
            addCriterion("keyAdmin not between", value1, value2, "keyAdmin");
            return (Criteria) this;
        }

        public Criteria andEffectiveIsNull() {
            addCriterion("effective is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveIsNotNull() {
            addCriterion("effective is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEqualTo(Byte value) {
            addCriterion("effective =", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveNotEqualTo(Byte value) {
            addCriterion("effective <>", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveGreaterThan(Byte value) {
            addCriterion("effective >", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("effective >=", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveLessThan(Byte value) {
            addCriterion("effective <", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveLessThanOrEqualTo(Byte value) {
            addCriterion("effective <=", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveIn(List<Byte> values) {
            addCriterion("effective in", values, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveNotIn(List<Byte> values) {
            addCriterion("effective not in", values, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveBetween(Byte value1, Byte value2) {
            addCriterion("effective between", value1, value2, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveNotBetween(Byte value1, Byte value2) {
            addCriterion("effective not between", value1, value2, "effective");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBatteryIsNull() {
            addCriterion("battery is null");
            return (Criteria) this;
        }

        public Criteria andBatteryIsNotNull() {
            addCriterion("battery is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryEqualTo(Byte value) {
            addCriterion("battery =", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryNotEqualTo(Byte value) {
            addCriterion("battery <>", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryGreaterThan(Byte value) {
            addCriterion("battery >", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryGreaterThanOrEqualTo(Byte value) {
            addCriterion("battery >=", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryLessThan(Byte value) {
            addCriterion("battery <", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryLessThanOrEqualTo(Byte value) {
            addCriterion("battery <=", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryIn(List<Byte> values) {
            addCriterion("battery in", values, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryNotIn(List<Byte> values) {
            addCriterion("battery not in", values, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryBetween(Byte value1, Byte value2) {
            addCriterion("battery between", value1, value2, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryNotBetween(Byte value1, Byte value2) {
            addCriterion("battery not between", value1, value2, "battery");
            return (Criteria) this;
        }

        public Criteria andElePriceIsNull() {
            addCriterion("elePrice is null");
            return (Criteria) this;
        }

        public Criteria andElePriceIsNotNull() {
            addCriterion("elePrice is not null");
            return (Criteria) this;
        }

        public Criteria andElePriceEqualTo(BigDecimal value) {
            addCriterion("elePrice =", value, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceNotEqualTo(BigDecimal value) {
            addCriterion("elePrice <>", value, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceGreaterThan(BigDecimal value) {
            addCriterion("elePrice >", value, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("elePrice >=", value, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceLessThan(BigDecimal value) {
            addCriterion("elePrice <", value, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("elePrice <=", value, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceIn(List<BigDecimal> values) {
            addCriterion("elePrice in", values, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceNotIn(List<BigDecimal> values) {
            addCriterion("elePrice not in", values, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("elePrice between", value1, value2, "elePrice");
            return (Criteria) this;
        }

        public Criteria andElePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("elePrice not between", value1, value2, "elePrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceIsNull() {
            addCriterion("gasPrice is null");
            return (Criteria) this;
        }

        public Criteria andGasPriceIsNotNull() {
            addCriterion("gasPrice is not null");
            return (Criteria) this;
        }

        public Criteria andGasPriceEqualTo(BigDecimal value) {
            addCriterion("gasPrice =", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceNotEqualTo(BigDecimal value) {
            addCriterion("gasPrice <>", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceGreaterThan(BigDecimal value) {
            addCriterion("gasPrice >", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gasPrice >=", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceLessThan(BigDecimal value) {
            addCriterion("gasPrice <", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gasPrice <=", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceIn(List<BigDecimal> values) {
            addCriterion("gasPrice in", values, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceNotIn(List<BigDecimal> values) {
            addCriterion("gasPrice not in", values, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gasPrice between", value1, value2, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gasPrice not between", value1, value2, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceIsNull() {
            addCriterion("waterPrice is null");
            return (Criteria) this;
        }

        public Criteria andWaterPriceIsNotNull() {
            addCriterion("waterPrice is not null");
            return (Criteria) this;
        }

        public Criteria andWaterPriceEqualTo(BigDecimal value) {
            addCriterion("waterPrice =", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceNotEqualTo(BigDecimal value) {
            addCriterion("waterPrice <>", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceGreaterThan(BigDecimal value) {
            addCriterion("waterPrice >", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("waterPrice >=", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceLessThan(BigDecimal value) {
            addCriterion("waterPrice <", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("waterPrice <=", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceIn(List<BigDecimal> values) {
            addCriterion("waterPrice in", values, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceNotIn(List<BigDecimal> values) {
            addCriterion("waterPrice not in", values, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("waterPrice between", value1, value2, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("waterPrice not between", value1, value2, "waterPrice");
            return (Criteria) this;
        }
        
        public Criteria andPropertyPriceIsNull() {
            addCriterion("propertyPrice is null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIsNotNull() {
            addCriterion("propertyPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceEqualTo(BigDecimal value) {
            addCriterion("propertyPrice =", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotEqualTo(BigDecimal value) {
            addCriterion("propertyPrice <>", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThan(BigDecimal value) {
            addCriterion("propertyPrice >", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("propertyPrice >=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThan(BigDecimal value) {
            addCriterion("propertyPrice <", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("propertyPrice <=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIn(List<BigDecimal> values) {
            addCriterion("propertyPrice in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotIn(List<BigDecimal> values) {
            addCriterion("propertyPrice not in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("propertyPrice between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("propertyPrice not between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }


        public Criteria andSafeModeIsNull() {
            addCriterion("safeMode is null");
            return (Criteria) this;
        }

        public Criteria andSafeModeIsNotNull() {
            addCriterion("safeMode is not null");
            return (Criteria) this;
        }

        public Criteria andSafeModeEqualTo(Byte value) {
            addCriterion("safeMode =", value, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeNotEqualTo(Byte value) {
            addCriterion("safeMode <>", value, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeGreaterThan(Byte value) {
            addCriterion("safeMode >", value, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("safeMode >=", value, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeLessThan(Byte value) {
            addCriterion("safeMode <", value, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeLessThanOrEqualTo(Byte value) {
            addCriterion("safeMode <=", value, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeIn(List<Byte> values) {
            addCriterion("safeMode in", values, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeNotIn(List<Byte> values) {
            addCriterion("safeMode not in", values, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeBetween(Byte value1, Byte value2) {
            addCriterion("safeMode between", value1, value2, "safeMode");
            return (Criteria) this;
        }

        public Criteria andSafeModeNotBetween(Byte value1, Byte value2) {
            addCriterion("safeMode not between", value1, value2, "safeMode");
            return (Criteria) this;
        }

        public Criteria andIfSharedIsNull() {
            addCriterion("ifShared is null");
            return (Criteria) this;
        }

        public Criteria andIfSharedIsNotNull() {
            addCriterion("ifShared is not null");
            return (Criteria) this;
        }

        public Criteria andIfSharedEqualTo(Byte value) {
            addCriterion("ifShared =", value, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedNotEqualTo(Byte value) {
            addCriterion("ifShared <>", value, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedGreaterThan(Byte value) {
            addCriterion("ifShared >", value, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedGreaterThanOrEqualTo(Byte value) {
            addCriterion("ifShared >=", value, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedLessThan(Byte value) {
            addCriterion("ifShared <", value, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedLessThanOrEqualTo(Byte value) {
            addCriterion("ifShared <=", value, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedIn(List<Byte> values) {
            addCriterion("ifShared in", values, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedNotIn(List<Byte> values) {
            addCriterion("ifShared not in", values, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedBetween(Byte value1, Byte value2) {
            addCriterion("ifShared between", value1, value2, "ifShared");
            return (Criteria) this;
        }

        public Criteria andIfSharedNotBetween(Byte value1, Byte value2) {
            addCriterion("ifShared not between", value1, value2, "ifShared");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteIsNull() {
            addCriterion("alertMinute is null");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteIsNotNull() {
            addCriterion("alertMinute is not null");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteEqualTo(Integer value) {
            addCriterion("alertMinute =", value, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteNotEqualTo(Integer value) {
            addCriterion("alertMinute <>", value, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteGreaterThan(Integer value) {
            addCriterion("alertMinute >", value, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("alertMinute >=", value, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteLessThan(Integer value) {
            addCriterion("alertMinute <", value, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("alertMinute <=", value, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteIn(List<Integer> values) {
            addCriterion("alertMinute in", values, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteNotIn(List<Integer> values) {
            addCriterion("alertMinute not in", values, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteBetween(Integer value1, Integer value2) {
            addCriterion("alertMinute between", value1, value2, "alertMinute");
            return (Criteria) this;
        }

        public Criteria andAlertMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("alertMinute not between", value1, value2,
                    "alertMinute");
            return (Criteria) this;
        }
        
        public Criteria andDepartmentTypeIsNull() {
            addCriterion("departmentType is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIsNotNull() {
            addCriterion("departmentType is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeEqualTo(Integer value) {
            addCriterion("departmentType =", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotEqualTo(Integer value) {
            addCriterion("departmentType <>", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeGreaterThan(Integer value) {
            addCriterion("departmentType >", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentType >=", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLessThan(Integer value) {
            addCriterion("departmentType <", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("departmentType <=", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIn(List<Integer> values) {
            addCriterion("departmentType in", values, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotIn(List<Integer> values) {
            addCriterion("departmentType not in", values, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeBetween(Integer value1, Integer value2) {
            addCriterion("departmentType between", value1, value2, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentType not between", value1, value2,
                    "departmentType");
            return (Criteria) this;
        }
        
        public Criteria andShowTypeIsNull() {
            addCriterion("showType is null");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNotNull() {
            addCriterion("showType is not null");
            return (Criteria) this;
        }

        public Criteria andShowTypeEqualTo(Integer value) {
            addCriterion("showType =", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotEqualTo(Integer value) {
            addCriterion("showType <>", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThan(Integer value) {
            addCriterion("showType >", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("showType >=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThan(Integer value) {
            addCriterion("showType <", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThanOrEqualTo(Integer value) {
            addCriterion("showType <=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeIn(List<Integer> values) {
            addCriterion("showType in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotIn(List<Integer> values) {
            addCriterion("showType not in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeBetween(Integer value1, Integer value2) {
            addCriterion("showType between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("showType not between", value1, value2,
                    "showType");
            return (Criteria) this;
        }
  
        public Criteria andKeyUserIsNull() {
            addCriterion("keyUser is null");
            return (Criteria) this;
        }

        public Criteria andKeyUserIsNotNull() {
            addCriterion("keyUser is not null");
            return (Criteria) this;
        }

        public Criteria andKeyUserEqualTo(String value) {
            addCriterion("keyUser =", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserNotEqualTo(String value) {
            addCriterion("keyUser <>", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserGreaterThan(String value) {
            addCriterion("keyUser >", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserGreaterThanOrEqualTo(String value) {
            addCriterion("keyUser >=", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserLessThan(String value) {
            addCriterion("keyUser <", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserLessThanOrEqualTo(String value) {
            addCriterion("keyUser <=", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserLike(String value) {
            addCriterion("keyUser like", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserNotLike(String value) {
            addCriterion("keyUser not like", value, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserIn(List<String> values) {
            addCriterion("keyUser in", values, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserNotIn(List<String> values) {
            addCriterion("keyUser not in", values, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserBetween(String value1, String value2) {
            addCriterion("keyUser between", value1, value2, "keyUser");
            return (Criteria) this;
        }

        public Criteria andKeyUserNotBetween(String value1, String value2) {
            addCriterion("keyUser not between", value1, value2, "keyUser");
            return (Criteria) this;
        }
  
        public Criteria andDepartmentAddressIsNull() {
            addCriterion("departmentAddress is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressIsNotNull() {
            addCriterion("departmentAddress is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressEqualTo(String value) {
            addCriterion("departmentAddress =", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotEqualTo(String value) {
            addCriterion("departmentAddress <>", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressGreaterThan(String value) {
            addCriterion("departmentAddress >", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("departmentAddress >=", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressLessThan(String value) {
            addCriterion("departmentAddress <", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressLessThanOrEqualTo(String value) {
            addCriterion("departmentAddress <=", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressLike(String value) {
            addCriterion("departmentAddress like", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotLike(String value) {
            addCriterion("departmentAddress not like", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressIn(List<String> values) {
            addCriterion("departmentAddress in", values, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotIn(List<String> values) {
            addCriterion("departmentAddress not in", values, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressBetween(String value1, String value2) {
            addCriterion("departmentAddress between", value1, value2, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotBetween(String value1, String value2) {
            addCriterion("departmentAddress not between", value1, value2, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberIsNull() {
            addCriterion("departmentNumber is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberIsNotNull() {
            addCriterion("departmentNumber is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberEqualTo(String value) {
            addCriterion("departmentNumber =", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotEqualTo(String value) {
            addCriterion("departmentNumber <>", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberGreaterThan(String value) {
            addCriterion("departmentNumber >", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("departmentNumber >=", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberLessThan(String value) {
            addCriterion("departmentNumber <", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberLessThanOrEqualTo(String value) {
            addCriterion("departmentNumber <=", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberLike(String value) {
            addCriterion("departmentNumber like", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotLike(String value) {
            addCriterion("departmentNumber not like", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberIn(List<String> values) {
            addCriterion("departmentNumber in", values, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotIn(List<String> values) {
            addCriterion("departmentNumber not in", values, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberBetween(String value1, String value2) {
            addCriterion("departmentNumber between", value1, value2, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotBetween(String value1, String value2) {
            addCriterion("departmentNumber not between", value1, value2, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureIsNull() {
            addCriterion("departmentPicture is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureIsNotNull() {
            addCriterion("departmentPicture is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureEqualTo(String value) {
            addCriterion("departmentPicture =", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureNotEqualTo(String value) {
            addCriterion("departmentPicture <>", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureGreaterThan(String value) {
            addCriterion("departmentPicture >", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureGreaterThanOrEqualTo(String value) {
            addCriterion("departmentPicture >=", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureLessThan(String value) {
            addCriterion("departmentPicture <", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureLessThanOrEqualTo(String value) {
            addCriterion("departmentPicture <=", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureLike(String value) {
            addCriterion("departmentPicture like", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureNotLike(String value) {
            addCriterion("departmentPicture not like", value, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureIn(List<String> values) {
            addCriterion("departmentPicture in", values, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureNotIn(List<String> values) {
            addCriterion("departmentPicture not in", values, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureBetween(String value1, String value2) {
            addCriterion("departmentPicture between", value1, value2, "departmentPicture");
            return (Criteria) this;
        }

        public Criteria andDepartmentPictureNotBetween(String value1, String value2) {
            addCriterion("departmentPicture not between", value1, value2, "departmentPicture");
            return (Criteria) this;
        }
        
        
        
        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andKeyNumberIsNull() {
            addCriterion("keyNumber is null");
            return (Criteria) this;
        }

        public Criteria andKeyNumberIsNotNull() {
            addCriterion("keyNumber is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNumberEqualTo(String value) {
            addCriterion("keyNumber =", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberNotEqualTo(String value) {
            addCriterion("keyNumber <>", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberGreaterThan(String value) {
            addCriterion("keyNumber >", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberGreaterThanOrEqualTo(String value) {
            addCriterion("keyNumber >=", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberLessThan(String value) {
            addCriterion("keyNumber <", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberLessThanOrEqualTo(String value) {
            addCriterion("keyNumber <=", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberLike(String value) {
            addCriterion("keyNumber like", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberNotLike(String value) {
            addCriterion("keyNumber not like", value, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberIn(List<String> values) {
            addCriterion("keyNumber in", values, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberNotIn(List<String> values) {
            addCriterion("keyNumber not in", values, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberBetween(String value1, String value2) {
            addCriterion("keyNumber between", value1, value2, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyNumberNotBetween(String value1, String value2) {
            addCriterion("keyNumber not between", value1, value2, "keyNumber");
            return (Criteria) this;
        }

        public Criteria andKeyDevIsNull() {
            addCriterion("keyDev is null");
            return (Criteria) this;
        }

        public Criteria andKeyDevIsNotNull() {
            addCriterion("keyDev is not null");
            return (Criteria) this;
        }

        public Criteria andKeyDevEqualTo(String value) {
            addCriterion("keyDev =", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevNotEqualTo(String value) {
            addCriterion("keyDev <>", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevGreaterThan(String value) {
            addCriterion("keyDev >", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevGreaterThanOrEqualTo(String value) {
            addCriterion("keyDev >=", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevLessThan(String value) {
            addCriterion("keyDev <", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevLessThanOrEqualTo(String value) {
            addCriterion("keyDev <=", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevLike(String value) {
            addCriterion("keyDev like", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevNotLike(String value) {
            addCriterion("keyDev not like", value, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevIn(List<String> values) {
            addCriterion("keyDev in", values, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevNotIn(List<String> values) {
            addCriterion("keyDev not in", values, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevBetween(String value1, String value2) {
            addCriterion("keyDev between", value1, value2, "keyDev");
            return (Criteria) this;
        }

        public Criteria andKeyDevNotBetween(String value1, String value2) {
            addCriterion("keyDev not between", value1, value2, "keyDev");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("deviceName is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("deviceName is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("deviceName =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("deviceName <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("deviceName >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("deviceName >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("deviceName <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("deviceName <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("deviceName like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("deviceName not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("deviceName in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("deviceName not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("deviceName between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("deviceName not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue,
                String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
