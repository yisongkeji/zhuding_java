package com.foreseers.tj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLookHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserLookHistoryExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andLookidIsNull() {
            addCriterion("lookid is null");
            return (Criteria) this;
        }

        public Criteria andLookidIsNotNull() {
            addCriterion("lookid is not null");
            return (Criteria) this;
        }

        public Criteria andLookidEqualTo(Integer value) {
            addCriterion("lookid =", value, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidNotEqualTo(Integer value) {
            addCriterion("lookid <>", value, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidGreaterThan(Integer value) {
            addCriterion("lookid >", value, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lookid >=", value, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidLessThan(Integer value) {
            addCriterion("lookid <", value, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidLessThanOrEqualTo(Integer value) {
            addCriterion("lookid <=", value, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidIn(List<Integer> values) {
            addCriterion("lookid in", values, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidNotIn(List<Integer> values) {
            addCriterion("lookid not in", values, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidBetween(Integer value1, Integer value2) {
            addCriterion("lookid between", value1, value2, "lookid");
            return (Criteria) this;
        }

        public Criteria andLookidNotBetween(Integer value1, Integer value2) {
            addCriterion("lookid not between", value1, value2, "lookid");
            return (Criteria) this;
        }

        public Criteria andLooktimeIsNull() {
            addCriterion("looktime is null");
            return (Criteria) this;
        }

        public Criteria andLooktimeIsNotNull() {
            addCriterion("looktime is not null");
            return (Criteria) this;
        }

        public Criteria andLooktimeEqualTo(String value) {
            addCriterion("looktime =", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeNotEqualTo(String value) {
            addCriterion("looktime <>", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeGreaterThan(String value) {
            addCriterion("looktime >", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeGreaterThanOrEqualTo(String value) {
            addCriterion("looktime >=", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeLessThan(String value) {
            addCriterion("looktime <", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeLessThanOrEqualTo(String value) {
            addCriterion("looktime <=", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeLike(String value) {
            addCriterion("looktime like", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeNotLike(String value) {
            addCriterion("looktime not like", value, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeIn(List<String> values) {
            addCriterion("looktime in", values, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeNotIn(List<String> values) {
            addCriterion("looktime not in", values, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeBetween(String value1, String value2) {
            addCriterion("looktime between", value1, value2, "looktime");
            return (Criteria) this;
        }

        public Criteria andLooktimeNotBetween(String value1, String value2) {
            addCriterion("looktime not between", value1, value2, "looktime");
            return (Criteria) this;
        }

        public Criteria andLookupdatedIsNull() {
            addCriterion("lookupdated is null");
            return (Criteria) this;
        }

        public Criteria andLookupdatedIsNotNull() {
            addCriterion("lookupdated is not null");
            return (Criteria) this;
        }

        public Criteria andLookupdatedEqualTo(Date value) {
            addCriterion("lookupdated =", value, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedNotEqualTo(Date value) {
            addCriterion("lookupdated <>", value, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedGreaterThan(Date value) {
            addCriterion("lookupdated >", value, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("lookupdated >=", value, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedLessThan(Date value) {
            addCriterion("lookupdated <", value, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedLessThanOrEqualTo(Date value) {
            addCriterion("lookupdated <=", value, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedIn(List<Date> values) {
            addCriterion("lookupdated in", values, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedNotIn(List<Date> values) {
            addCriterion("lookupdated not in", values, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedBetween(Date value1, Date value2) {
            addCriterion("lookupdated between", value1, value2, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andLookupdatedNotBetween(Date value1, Date value2) {
            addCriterion("lookupdated not between", value1, value2, "lookupdated");
            return (Criteria) this;
        }

        public Criteria andSpareIsNull() {
            addCriterion("spare is null");
            return (Criteria) this;
        }

        public Criteria andSpareIsNotNull() {
            addCriterion("spare is not null");
            return (Criteria) this;
        }

        public Criteria andSpareEqualTo(String value) {
            addCriterion("spare =", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotEqualTo(String value) {
            addCriterion("spare <>", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareGreaterThan(String value) {
            addCriterion("spare >", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareGreaterThanOrEqualTo(String value) {
            addCriterion("spare >=", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLessThan(String value) {
            addCriterion("spare <", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLessThanOrEqualTo(String value) {
            addCriterion("spare <=", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLike(String value) {
            addCriterion("spare like", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotLike(String value) {
            addCriterion("spare not like", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareIn(List<String> values) {
            addCriterion("spare in", values, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotIn(List<String> values) {
            addCriterion("spare not in", values, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareBetween(String value1, String value2) {
            addCriterion("spare between", value1, value2, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotBetween(String value1, String value2) {
            addCriterion("spare not between", value1, value2, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareintIsNull() {
            addCriterion("spareint is null");
            return (Criteria) this;
        }

        public Criteria andSpareintIsNotNull() {
            addCriterion("spareint is not null");
            return (Criteria) this;
        }

        public Criteria andSpareintEqualTo(Integer value) {
            addCriterion("spareint =", value, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintNotEqualTo(Integer value) {
            addCriterion("spareint <>", value, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintGreaterThan(Integer value) {
            addCriterion("spareint >", value, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintGreaterThanOrEqualTo(Integer value) {
            addCriterion("spareint >=", value, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintLessThan(Integer value) {
            addCriterion("spareint <", value, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintLessThanOrEqualTo(Integer value) {
            addCriterion("spareint <=", value, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintIn(List<Integer> values) {
            addCriterion("spareint in", values, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintNotIn(List<Integer> values) {
            addCriterion("spareint not in", values, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintBetween(Integer value1, Integer value2) {
            addCriterion("spareint between", value1, value2, "spareint");
            return (Criteria) this;
        }

        public Criteria andSpareintNotBetween(Integer value1, Integer value2) {
            addCriterion("spareint not between", value1, value2, "spareint");
            return (Criteria) this;
        }
    }

    /**
     */
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