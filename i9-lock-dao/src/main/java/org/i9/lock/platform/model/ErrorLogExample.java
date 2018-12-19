package org.i9.lock.platform.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ErrorLogExample() {
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

        public Criteria andLockIdIsNull() {
            addCriterion("lockId is null");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNotNull() {
            addCriterion("lockId is not null");
            return (Criteria) this;
        }

        public Criteria andLockIdEqualTo(Integer value) {
            addCriterion("lockId =", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotEqualTo(Integer value) {
            addCriterion("lockId <>", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThan(Integer value) {
            addCriterion("lockId >", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lockId >=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThan(Integer value) {
            addCriterion("lockId <", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThanOrEqualTo(Integer value) {
            addCriterion("lockId <=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdIn(List<Integer> values) {
            addCriterion("lockId in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotIn(List<Integer> values) {
            addCriterion("lockId not in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdBetween(Integer value1, Integer value2) {
            addCriterion("lockId between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lockId not between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("orderNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("orderNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("orderNumber =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("orderNumber <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("orderNumber >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNumber >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("orderNumber <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("orderNumber <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("orderNumber in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("orderNumber not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("orderNumber between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNumber not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andIferrorIsNull() {
            addCriterion("iferror is null");
            return (Criteria) this;
        }

        public Criteria andIferrorIsNotNull() {
            addCriterion("iferror is not null");
            return (Criteria) this;
        }

        public Criteria andIferrorEqualTo(Integer value) {
            addCriterion("iferror =", value, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorNotEqualTo(Integer value) {
            addCriterion("iferror <>", value, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorGreaterThan(Integer value) {
            addCriterion("iferror >", value, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorGreaterThanOrEqualTo(Integer value) {
            addCriterion("iferror >=", value, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorLessThan(Integer value) {
            addCriterion("iferror <", value, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorLessThanOrEqualTo(Integer value) {
            addCriterion("iferror <=", value, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorIn(List<Integer> values) {
            addCriterion("iferror in", values, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorNotIn(List<Integer> values) {
            addCriterion("iferror not in", values, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorBetween(Integer value1, Integer value2) {
            addCriterion("iferror between", value1, value2, "iferror");
            return (Criteria) this;
        }

        public Criteria andIferrorNotBetween(Integer value1, Integer value2) {
            addCriterion("iferror not between", value1, value2, "iferror");
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