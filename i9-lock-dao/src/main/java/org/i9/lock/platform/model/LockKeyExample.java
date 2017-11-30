package org.i9.lock.platform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LockKeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LockKeyExample() {
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNull() {
            addCriterion("lockId is null");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNotNull() {
            addCriterion("lockId is not null");
            return (Criteria) this;
        }

        public Criteria andLockIdEqualTo(Long value) {
            addCriterion("lockId =", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotEqualTo(Long value) {
            addCriterion("lockId <>", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThan(Long value) {
            addCriterion("lockId >", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lockId >=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThan(Long value) {
            addCriterion("lockId <", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThanOrEqualTo(Long value) {
            addCriterion("lockId <=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdIn(List<Long> values) {
            addCriterion("lockId in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotIn(List<Long> values) {
            addCriterion("lockId not in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdBetween(Long value1, Long value2) {
            addCriterion("lockId between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotBetween(Long value1, Long value2) {
            addCriterion("lockId not between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneIsNull() {
            addCriterion("hirerPhone is null");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneIsNotNull() {
            addCriterion("hirerPhone is not null");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneEqualTo(String value) {
            addCriterion("hirerPhone =", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneNotEqualTo(String value) {
            addCriterion("hirerPhone <>", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneGreaterThan(String value) {
            addCriterion("hirerPhone >", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("hirerPhone >=", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneLessThan(String value) {
            addCriterion("hirerPhone <", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneLessThanOrEqualTo(String value) {
            addCriterion("hirerPhone <=", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneLike(String value) {
            addCriterion("hirerPhone like", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneNotLike(String value) {
            addCriterion("hirerPhone not like", value, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneIn(List<String> values) {
            addCriterion("hirerPhone in", values, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneNotIn(List<String> values) {
            addCriterion("hirerPhone not in", values, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneBetween(String value1, String value2) {
            addCriterion("hirerPhone between", value1, value2, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andHirerPhoneNotBetween(String value1, String value2) {
            addCriterion("hirerPhone not between", value1, value2, "hirerPhone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andHireTypeIsNull() {
            addCriterion("hireType is null");
            return (Criteria) this;
        }

        public Criteria andHireTypeIsNotNull() {
            addCriterion("hireType is not null");
            return (Criteria) this;
        }

        public Criteria andHireTypeEqualTo(Byte value) {
            addCriterion("hireType =", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotEqualTo(Byte value) {
            addCriterion("hireType <>", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeGreaterThan(Byte value) {
            addCriterion("hireType >", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("hireType >=", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeLessThan(Byte value) {
            addCriterion("hireType <", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeLessThanOrEqualTo(Byte value) {
            addCriterion("hireType <=", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeIn(List<Byte> values) {
            addCriterion("hireType in", values, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotIn(List<Byte> values) {
            addCriterion("hireType not in", values, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeBetween(Byte value1, Byte value2) {
            addCriterion("hireType between", value1, value2, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("hireType not between", value1, value2, "hireType");
            return (Criteria) this;
        }

        public Criteria andHirePriceIsNull() {
            addCriterion("hirePrice is null");
            return (Criteria) this;
        }

        public Criteria andHirePriceIsNotNull() {
            addCriterion("hirePrice is not null");
            return (Criteria) this;
        }

        public Criteria andHirePriceEqualTo(BigDecimal value) {
            addCriterion("hirePrice =", value, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceNotEqualTo(BigDecimal value) {
            addCriterion("hirePrice <>", value, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceGreaterThan(BigDecimal value) {
            addCriterion("hirePrice >", value, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hirePrice >=", value, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceLessThan(BigDecimal value) {
            addCriterion("hirePrice <", value, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hirePrice <=", value, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceIn(List<BigDecimal> values) {
            addCriterion("hirePrice in", values, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceNotIn(List<BigDecimal> values) {
            addCriterion("hirePrice not in", values, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hirePrice between", value1, value2, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andHirePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hirePrice not between", value1, value2, "hirePrice");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("startTime =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("startTime <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("startTime in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("endTime <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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