package com.foreseers.tj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCanumsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserCanumsExample() {
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

        public Criteria andEverydayIsNull() {
            addCriterion("everyday is null");
            return (Criteria) this;
        }

        public Criteria andEverydayIsNotNull() {
            addCriterion("everyday is not null");
            return (Criteria) this;
        }

        public Criteria andEverydayEqualTo(Integer value) {
            addCriterion("everyday =", value, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayNotEqualTo(Integer value) {
            addCriterion("everyday <>", value, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayGreaterThan(Integer value) {
            addCriterion("everyday >", value, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayGreaterThanOrEqualTo(Integer value) {
            addCriterion("everyday >=", value, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayLessThan(Integer value) {
            addCriterion("everyday <", value, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayLessThanOrEqualTo(Integer value) {
            addCriterion("everyday <=", value, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayIn(List<Integer> values) {
            addCriterion("everyday in", values, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayNotIn(List<Integer> values) {
            addCriterion("everyday not in", values, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayBetween(Integer value1, Integer value2) {
            addCriterion("everyday between", value1, value2, "everyday");
            return (Criteria) this;
        }

        public Criteria andEverydayNotBetween(Integer value1, Integer value2) {
            addCriterion("everyday not between", value1, value2, "everyday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayIsNull() {
            addCriterion("vipeveryday is null");
            return (Criteria) this;
        }

        public Criteria andVipeverydayIsNotNull() {
            addCriterion("vipeveryday is not null");
            return (Criteria) this;
        }

        public Criteria andVipeverydayEqualTo(Integer value) {
            addCriterion("vipeveryday =", value, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayNotEqualTo(Integer value) {
            addCriterion("vipeveryday <>", value, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayGreaterThan(Integer value) {
            addCriterion("vipeveryday >", value, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayGreaterThanOrEqualTo(Integer value) {
            addCriterion("vipeveryday >=", value, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayLessThan(Integer value) {
            addCriterion("vipeveryday <", value, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayLessThanOrEqualTo(Integer value) {
            addCriterion("vipeveryday <=", value, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayIn(List<Integer> values) {
            addCriterion("vipeveryday in", values, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayNotIn(List<Integer> values) {
            addCriterion("vipeveryday not in", values, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayBetween(Integer value1, Integer value2) {
            addCriterion("vipeveryday between", value1, value2, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andVipeverydayNotBetween(Integer value1, Integer value2) {
            addCriterion("vipeveryday not between", value1, value2, "vipeveryday");
            return (Criteria) this;
        }

        public Criteria andNumsIsNull() {
            addCriterion("nums is null");
            return (Criteria) this;
        }

        public Criteria andNumsIsNotNull() {
            addCriterion("nums is not null");
            return (Criteria) this;
        }

        public Criteria andNumsEqualTo(Integer value) {
            addCriterion("nums =", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotEqualTo(Integer value) {
            addCriterion("nums <>", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThan(Integer value) {
            addCriterion("nums >", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("nums >=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThan(Integer value) {
            addCriterion("nums <", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThanOrEqualTo(Integer value) {
            addCriterion("nums <=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsIn(List<Integer> values) {
            addCriterion("nums in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotIn(List<Integer> values) {
            addCriterion("nums not in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsBetween(Integer value1, Integer value2) {
            addCriterion("nums between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("nums not between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andBuynumsIsNull() {
            addCriterion("buynums is null");
            return (Criteria) this;
        }

        public Criteria andBuynumsIsNotNull() {
            addCriterion("buynums is not null");
            return (Criteria) this;
        }

        public Criteria andBuynumsEqualTo(Integer value) {
            addCriterion("buynums =", value, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsNotEqualTo(Integer value) {
            addCriterion("buynums <>", value, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsGreaterThan(Integer value) {
            addCriterion("buynums >", value, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("buynums >=", value, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsLessThan(Integer value) {
            addCriterion("buynums <", value, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsLessThanOrEqualTo(Integer value) {
            addCriterion("buynums <=", value, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsIn(List<Integer> values) {
            addCriterion("buynums in", values, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsNotIn(List<Integer> values) {
            addCriterion("buynums not in", values, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsBetween(Integer value1, Integer value2) {
            addCriterion("buynums between", value1, value2, "buynums");
            return (Criteria) this;
        }

        public Criteria andBuynumsNotBetween(Integer value1, Integer value2) {
            addCriterion("buynums not between", value1, value2, "buynums");
            return (Criteria) this;
        }

        public Criteria andCountnumsIsNull() {
            addCriterion("countnums is null");
            return (Criteria) this;
        }

        public Criteria andCountnumsIsNotNull() {
            addCriterion("countnums is not null");
            return (Criteria) this;
        }

        public Criteria andCountnumsEqualTo(Integer value) {
            addCriterion("countnums =", value, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsNotEqualTo(Integer value) {
            addCriterion("countnums <>", value, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsGreaterThan(Integer value) {
            addCriterion("countnums >", value, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("countnums >=", value, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsLessThan(Integer value) {
            addCriterion("countnums <", value, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsLessThanOrEqualTo(Integer value) {
            addCriterion("countnums <=", value, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsIn(List<Integer> values) {
            addCriterion("countnums in", values, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsNotIn(List<Integer> values) {
            addCriterion("countnums not in", values, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsBetween(Integer value1, Integer value2) {
            addCriterion("countnums between", value1, value2, "countnums");
            return (Criteria) this;
        }

        public Criteria andCountnumsNotBetween(Integer value1, Integer value2) {
            addCriterion("countnums not between", value1, value2, "countnums");
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

        public Criteria andSpare1IsNull() {
            addCriterion("spare1 is null");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNotNull() {
            addCriterion("spare1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare1EqualTo(String value) {
            addCriterion("spare1 =", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotEqualTo(String value) {
            addCriterion("spare1 <>", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThan(String value) {
            addCriterion("spare1 >", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThanOrEqualTo(String value) {
            addCriterion("spare1 >=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThan(String value) {
            addCriterion("spare1 <", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThanOrEqualTo(String value) {
            addCriterion("spare1 <=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Like(String value) {
            addCriterion("spare1 like", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotLike(String value) {
            addCriterion("spare1 not like", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1In(List<String> values) {
            addCriterion("spare1 in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotIn(List<String> values) {
            addCriterion("spare1 not in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Between(String value1, String value2) {
            addCriterion("spare1 between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotBetween(String value1, String value2) {
            addCriterion("spare1 not between", value1, value2, "spare1");
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