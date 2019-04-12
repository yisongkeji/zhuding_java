package com.foreseers.tj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LifebookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LifebookExample() {
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

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andIsleapIsNull() {
            addCriterion("isLeap is null");
            return (Criteria) this;
        }

        public Criteria andIsleapIsNotNull() {
            addCriterion("isLeap is not null");
            return (Criteria) this;
        }

        public Criteria andIsleapEqualTo(String value) {
            addCriterion("isLeap =", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapNotEqualTo(String value) {
            addCriterion("isLeap <>", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapGreaterThan(String value) {
            addCriterion("isLeap >", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapGreaterThanOrEqualTo(String value) {
            addCriterion("isLeap >=", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapLessThan(String value) {
            addCriterion("isLeap <", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapLessThanOrEqualTo(String value) {
            addCriterion("isLeap <=", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapLike(String value) {
            addCriterion("isLeap like", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapNotLike(String value) {
            addCriterion("isLeap not like", value, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapIn(List<String> values) {
            addCriterion("isLeap in", values, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapNotIn(List<String> values) {
            addCriterion("isLeap not in", values, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapBetween(String value1, String value2) {
            addCriterion("isLeap between", value1, value2, "isleap");
            return (Criteria) this;
        }

        public Criteria andIsleapNotBetween(String value1, String value2) {
            addCriterion("isLeap not between", value1, value2, "isleap");
            return (Criteria) this;
        }

        public Criteria andLunaryearIsNull() {
            addCriterion("lunaryear is null");
            return (Criteria) this;
        }

        public Criteria andLunaryearIsNotNull() {
            addCriterion("lunaryear is not null");
            return (Criteria) this;
        }

        public Criteria andLunaryearEqualTo(String value) {
            addCriterion("lunaryear =", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearNotEqualTo(String value) {
            addCriterion("lunaryear <>", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearGreaterThan(String value) {
            addCriterion("lunaryear >", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearGreaterThanOrEqualTo(String value) {
            addCriterion("lunaryear >=", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearLessThan(String value) {
            addCriterion("lunaryear <", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearLessThanOrEqualTo(String value) {
            addCriterion("lunaryear <=", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearLike(String value) {
            addCriterion("lunaryear like", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearNotLike(String value) {
            addCriterion("lunaryear not like", value, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearIn(List<String> values) {
            addCriterion("lunaryear in", values, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearNotIn(List<String> values) {
            addCriterion("lunaryear not in", values, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearBetween(String value1, String value2) {
            addCriterion("lunaryear between", value1, value2, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunaryearNotBetween(String value1, String value2) {
            addCriterion("lunaryear not between", value1, value2, "lunaryear");
            return (Criteria) this;
        }

        public Criteria andLunarmonthIsNull() {
            addCriterion("lunarmonth is null");
            return (Criteria) this;
        }

        public Criteria andLunarmonthIsNotNull() {
            addCriterion("lunarmonth is not null");
            return (Criteria) this;
        }

        public Criteria andLunarmonthEqualTo(String value) {
            addCriterion("lunarmonth =", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthNotEqualTo(String value) {
            addCriterion("lunarmonth <>", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthGreaterThan(String value) {
            addCriterion("lunarmonth >", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthGreaterThanOrEqualTo(String value) {
            addCriterion("lunarmonth >=", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthLessThan(String value) {
            addCriterion("lunarmonth <", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthLessThanOrEqualTo(String value) {
            addCriterion("lunarmonth <=", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthLike(String value) {
            addCriterion("lunarmonth like", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthNotLike(String value) {
            addCriterion("lunarmonth not like", value, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthIn(List<String> values) {
            addCriterion("lunarmonth in", values, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthNotIn(List<String> values) {
            addCriterion("lunarmonth not in", values, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthBetween(String value1, String value2) {
            addCriterion("lunarmonth between", value1, value2, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunarmonthNotBetween(String value1, String value2) {
            addCriterion("lunarmonth not between", value1, value2, "lunarmonth");
            return (Criteria) this;
        }

        public Criteria andLunardayIsNull() {
            addCriterion("lunarday is null");
            return (Criteria) this;
        }

        public Criteria andLunardayIsNotNull() {
            addCriterion("lunarday is not null");
            return (Criteria) this;
        }

        public Criteria andLunardayEqualTo(String value) {
            addCriterion("lunarday =", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayNotEqualTo(String value) {
            addCriterion("lunarday <>", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayGreaterThan(String value) {
            addCriterion("lunarday >", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayGreaterThanOrEqualTo(String value) {
            addCriterion("lunarday >=", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayLessThan(String value) {
            addCriterion("lunarday <", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayLessThanOrEqualTo(String value) {
            addCriterion("lunarday <=", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayLike(String value) {
            addCriterion("lunarday like", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayNotLike(String value) {
            addCriterion("lunarday not like", value, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayIn(List<String> values) {
            addCriterion("lunarday in", values, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayNotIn(List<String> values) {
            addCriterion("lunarday not in", values, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayBetween(String value1, String value2) {
            addCriterion("lunarday between", value1, value2, "lunarday");
            return (Criteria) this;
        }

        public Criteria andLunardayNotBetween(String value1, String value2) {
            addCriterion("lunarday not between", value1, value2, "lunarday");
            return (Criteria) this;
        }

        public Criteria andNumerologyIsNull() {
            addCriterion("numerology is null");
            return (Criteria) this;
        }

        public Criteria andNumerologyIsNotNull() {
            addCriterion("numerology is not null");
            return (Criteria) this;
        }

        public Criteria andNumerologyEqualTo(String value) {
            addCriterion("numerology =", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyNotEqualTo(String value) {
            addCriterion("numerology <>", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyGreaterThan(String value) {
            addCriterion("numerology >", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyGreaterThanOrEqualTo(String value) {
            addCriterion("numerology >=", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyLessThan(String value) {
            addCriterion("numerology <", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyLessThanOrEqualTo(String value) {
            addCriterion("numerology <=", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyLike(String value) {
            addCriterion("numerology like", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyNotLike(String value) {
            addCriterion("numerology not like", value, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyIn(List<String> values) {
            addCriterion("numerology in", values, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyNotIn(List<String> values) {
            addCriterion("numerology not in", values, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyBetween(String value1, String value2) {
            addCriterion("numerology between", value1, value2, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologyNotBetween(String value1, String value2) {
            addCriterion("numerology not between", value1, value2, "numerology");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchIsNull() {
            addCriterion("numerologymatch is null");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchIsNotNull() {
            addCriterion("numerologymatch is not null");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchEqualTo(String value) {
            addCriterion("numerologymatch =", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchNotEqualTo(String value) {
            addCriterion("numerologymatch <>", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchGreaterThan(String value) {
            addCriterion("numerologymatch >", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchGreaterThanOrEqualTo(String value) {
            addCriterion("numerologymatch >=", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchLessThan(String value) {
            addCriterion("numerologymatch <", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchLessThanOrEqualTo(String value) {
            addCriterion("numerologymatch <=", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchLike(String value) {
            addCriterion("numerologymatch like", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchNotLike(String value) {
            addCriterion("numerologymatch not like", value, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchIn(List<String> values) {
            addCriterion("numerologymatch in", values, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchNotIn(List<String> values) {
            addCriterion("numerologymatch not in", values, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchBetween(String value1, String value2) {
            addCriterion("numerologymatch between", value1, value2, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andNumerologymatchNotBetween(String value1, String value2) {
            addCriterion("numerologymatch not between", value1, value2, "numerologymatch");
            return (Criteria) this;
        }

        public Criteria andFiveelementsIsNull() {
            addCriterion("fiveElements is null");
            return (Criteria) this;
        }

        public Criteria andFiveelementsIsNotNull() {
            addCriterion("fiveElements is not null");
            return (Criteria) this;
        }

        public Criteria andFiveelementsEqualTo(String value) {
            addCriterion("fiveElements =", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsNotEqualTo(String value) {
            addCriterion("fiveElements <>", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsGreaterThan(String value) {
            addCriterion("fiveElements >", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsGreaterThanOrEqualTo(String value) {
            addCriterion("fiveElements >=", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsLessThan(String value) {
            addCriterion("fiveElements <", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsLessThanOrEqualTo(String value) {
            addCriterion("fiveElements <=", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsLike(String value) {
            addCriterion("fiveElements like", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsNotLike(String value) {
            addCriterion("fiveElements not like", value, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsIn(List<String> values) {
            addCriterion("fiveElements in", values, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsNotIn(List<String> values) {
            addCriterion("fiveElements not in", values, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsBetween(String value1, String value2) {
            addCriterion("fiveElements between", value1, value2, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andFiveelementsNotBetween(String value1, String value2) {
            addCriterion("fiveElements not between", value1, value2, "fiveelements");
            return (Criteria) this;
        }

        public Criteria andHoroscopeIsNull() {
            addCriterion("horoscope is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeIsNotNull() {
            addCriterion("horoscope is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeEqualTo(String value) {
            addCriterion("horoscope =", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeNotEqualTo(String value) {
            addCriterion("horoscope <>", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeGreaterThan(String value) {
            addCriterion("horoscope >", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeGreaterThanOrEqualTo(String value) {
            addCriterion("horoscope >=", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeLessThan(String value) {
            addCriterion("horoscope <", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeLessThanOrEqualTo(String value) {
            addCriterion("horoscope <=", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeLike(String value) {
            addCriterion("horoscope like", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeNotLike(String value) {
            addCriterion("horoscope not like", value, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeIn(List<String> values) {
            addCriterion("horoscope in", values, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeNotIn(List<String> values) {
            addCriterion("horoscope not in", values, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeBetween(String value1, String value2) {
            addCriterion("horoscope between", value1, value2, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeNotBetween(String value1, String value2) {
            addCriterion("horoscope not between", value1, value2, "horoscope");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidIsNull() {
            addCriterion("horoscopeid is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidIsNotNull() {
            addCriterion("horoscopeid is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidEqualTo(String value) {
            addCriterion("horoscopeid =", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidNotEqualTo(String value) {
            addCriterion("horoscopeid <>", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidGreaterThan(String value) {
            addCriterion("horoscopeid >", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopeid >=", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidLessThan(String value) {
            addCriterion("horoscopeid <", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidLessThanOrEqualTo(String value) {
            addCriterion("horoscopeid <=", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidLike(String value) {
            addCriterion("horoscopeid like", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidNotLike(String value) {
            addCriterion("horoscopeid not like", value, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidIn(List<String> values) {
            addCriterion("horoscopeid in", values, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidNotIn(List<String> values) {
            addCriterion("horoscopeid not in", values, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidBetween(String value1, String value2) {
            addCriterion("horoscopeid between", value1, value2, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopeidNotBetween(String value1, String value2) {
            addCriterion("horoscopeid not between", value1, value2, "horoscopeid");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameIsNull() {
            addCriterion("horoscopename is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameIsNotNull() {
            addCriterion("horoscopename is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameEqualTo(String value) {
            addCriterion("horoscopename =", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameNotEqualTo(String value) {
            addCriterion("horoscopename <>", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameGreaterThan(String value) {
            addCriterion("horoscopename >", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopename >=", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameLessThan(String value) {
            addCriterion("horoscopename <", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameLessThanOrEqualTo(String value) {
            addCriterion("horoscopename <=", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameLike(String value) {
            addCriterion("horoscopename like", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameNotLike(String value) {
            addCriterion("horoscopename not like", value, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameIn(List<String> values) {
            addCriterion("horoscopename in", values, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameNotIn(List<String> values) {
            addCriterion("horoscopename not in", values, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameBetween(String value1, String value2) {
            addCriterion("horoscopename between", value1, value2, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopenameNotBetween(String value1, String value2) {
            addCriterion("horoscopename not between", value1, value2, "horoscopename");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsIsNull() {
            addCriterion("horoscopeguardPlanets is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsIsNotNull() {
            addCriterion("horoscopeguardPlanets is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsEqualTo(String value) {
            addCriterion("horoscopeguardPlanets =", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsNotEqualTo(String value) {
            addCriterion("horoscopeguardPlanets <>", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsGreaterThan(String value) {
            addCriterion("horoscopeguardPlanets >", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopeguardPlanets >=", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsLessThan(String value) {
            addCriterion("horoscopeguardPlanets <", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsLessThanOrEqualTo(String value) {
            addCriterion("horoscopeguardPlanets <=", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsLike(String value) {
            addCriterion("horoscopeguardPlanets like", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsNotLike(String value) {
            addCriterion("horoscopeguardPlanets not like", value, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsIn(List<String> values) {
            addCriterion("horoscopeguardPlanets in", values, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsNotIn(List<String> values) {
            addCriterion("horoscopeguardPlanets not in", values, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsBetween(String value1, String value2) {
            addCriterion("horoscopeguardPlanets between", value1, value2, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsNotBetween(String value1, String value2) {
            addCriterion("horoscopeguardPlanets not between", value1, value2, "horoscopeguardplanets");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescIsNull() {
            addCriterion("horoscopeguardPlanetsDesc is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescIsNotNull() {
            addCriterion("horoscopeguardPlanetsDesc is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescEqualTo(String value) {
            addCriterion("horoscopeguardPlanetsDesc =", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescNotEqualTo(String value) {
            addCriterion("horoscopeguardPlanetsDesc <>", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescGreaterThan(String value) {
            addCriterion("horoscopeguardPlanetsDesc >", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopeguardPlanetsDesc >=", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescLessThan(String value) {
            addCriterion("horoscopeguardPlanetsDesc <", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescLessThanOrEqualTo(String value) {
            addCriterion("horoscopeguardPlanetsDesc <=", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescLike(String value) {
            addCriterion("horoscopeguardPlanetsDesc like", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescNotLike(String value) {
            addCriterion("horoscopeguardPlanetsDesc not like", value, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescIn(List<String> values) {
            addCriterion("horoscopeguardPlanetsDesc in", values, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescNotIn(List<String> values) {
            addCriterion("horoscopeguardPlanetsDesc not in", values, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescBetween(String value1, String value2) {
            addCriterion("horoscopeguardPlanetsDesc between", value1, value2, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardplanetsdescNotBetween(String value1, String value2) {
            addCriterion("horoscopeguardPlanetsDesc not between", value1, value2, "horoscopeguardplanetsdesc");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodIsNull() {
            addCriterion("horoscopeguardGod is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodIsNotNull() {
            addCriterion("horoscopeguardGod is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodEqualTo(String value) {
            addCriterion("horoscopeguardGod =", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodNotEqualTo(String value) {
            addCriterion("horoscopeguardGod <>", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodGreaterThan(String value) {
            addCriterion("horoscopeguardGod >", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopeguardGod >=", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodLessThan(String value) {
            addCriterion("horoscopeguardGod <", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodLessThanOrEqualTo(String value) {
            addCriterion("horoscopeguardGod <=", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodLike(String value) {
            addCriterion("horoscopeguardGod like", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodNotLike(String value) {
            addCriterion("horoscopeguardGod not like", value, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodIn(List<String> values) {
            addCriterion("horoscopeguardGod in", values, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodNotIn(List<String> values) {
            addCriterion("horoscopeguardGod not in", values, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodBetween(String value1, String value2) {
            addCriterion("horoscopeguardGod between", value1, value2, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardgodNotBetween(String value1, String value2) {
            addCriterion("horoscopeguardGod not between", value1, value2, "horoscopeguardgod");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelIsNull() {
            addCriterion("horoscopeguardAngel is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelIsNotNull() {
            addCriterion("horoscopeguardAngel is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelEqualTo(String value) {
            addCriterion("horoscopeguardAngel =", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelNotEqualTo(String value) {
            addCriterion("horoscopeguardAngel <>", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelGreaterThan(String value) {
            addCriterion("horoscopeguardAngel >", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopeguardAngel >=", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelLessThan(String value) {
            addCriterion("horoscopeguardAngel <", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelLessThanOrEqualTo(String value) {
            addCriterion("horoscopeguardAngel <=", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelLike(String value) {
            addCriterion("horoscopeguardAngel like", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelNotLike(String value) {
            addCriterion("horoscopeguardAngel not like", value, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelIn(List<String> values) {
            addCriterion("horoscopeguardAngel in", values, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelNotIn(List<String> values) {
            addCriterion("horoscopeguardAngel not in", values, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelBetween(String value1, String value2) {
            addCriterion("horoscopeguardAngel between", value1, value2, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardangelNotBetween(String value1, String value2) {
            addCriterion("horoscopeguardAngel not between", value1, value2, "horoscopeguardangel");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalIsNull() {
            addCriterion("horoscopeguardCrystal is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalIsNotNull() {
            addCriterion("horoscopeguardCrystal is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalEqualTo(String value) {
            addCriterion("horoscopeguardCrystal =", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalNotEqualTo(String value) {
            addCriterion("horoscopeguardCrystal <>", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalGreaterThan(String value) {
            addCriterion("horoscopeguardCrystal >", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopeguardCrystal >=", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalLessThan(String value) {
            addCriterion("horoscopeguardCrystal <", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalLessThanOrEqualTo(String value) {
            addCriterion("horoscopeguardCrystal <=", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalLike(String value) {
            addCriterion("horoscopeguardCrystal like", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalNotLike(String value) {
            addCriterion("horoscopeguardCrystal not like", value, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalIn(List<String> values) {
            addCriterion("horoscopeguardCrystal in", values, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalNotIn(List<String> values) {
            addCriterion("horoscopeguardCrystal not in", values, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalBetween(String value1, String value2) {
            addCriterion("horoscopeguardCrystal between", value1, value2, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopeguardcrystalNotBetween(String value1, String value2) {
            addCriterion("horoscopeguardCrystal not between", value1, value2, "horoscopeguardcrystal");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchIsNull() {
            addCriterion("horoscopematch is null");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchIsNotNull() {
            addCriterion("horoscopematch is not null");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchEqualTo(String value) {
            addCriterion("horoscopematch =", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchNotEqualTo(String value) {
            addCriterion("horoscopematch <>", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchGreaterThan(String value) {
            addCriterion("horoscopematch >", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchGreaterThanOrEqualTo(String value) {
            addCriterion("horoscopematch >=", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchLessThan(String value) {
            addCriterion("horoscopematch <", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchLessThanOrEqualTo(String value) {
            addCriterion("horoscopematch <=", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchLike(String value) {
            addCriterion("horoscopematch like", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchNotLike(String value) {
            addCriterion("horoscopematch not like", value, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchIn(List<String> values) {
            addCriterion("horoscopematch in", values, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchNotIn(List<String> values) {
            addCriterion("horoscopematch not in", values, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchBetween(String value1, String value2) {
            addCriterion("horoscopematch between", value1, value2, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andHoroscopematchNotBetween(String value1, String value2) {
            addCriterion("horoscopematch not between", value1, value2, "horoscopematch");
            return (Criteria) this;
        }

        public Criteria andZodiacIsNull() {
            addCriterion("zodiac is null");
            return (Criteria) this;
        }

        public Criteria andZodiacIsNotNull() {
            addCriterion("zodiac is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacEqualTo(String value) {
            addCriterion("zodiac =", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotEqualTo(String value) {
            addCriterion("zodiac <>", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacGreaterThan(String value) {
            addCriterion("zodiac >", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacGreaterThanOrEqualTo(String value) {
            addCriterion("zodiac >=", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacLessThan(String value) {
            addCriterion("zodiac <", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacLessThanOrEqualTo(String value) {
            addCriterion("zodiac <=", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacLike(String value) {
            addCriterion("zodiac like", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotLike(String value) {
            addCriterion("zodiac not like", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacIn(List<String> values) {
            addCriterion("zodiac in", values, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotIn(List<String> values) {
            addCriterion("zodiac not in", values, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacBetween(String value1, String value2) {
            addCriterion("zodiac between", value1, value2, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotBetween(String value1, String value2) {
            addCriterion("zodiac not between", value1, value2, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacidIsNull() {
            addCriterion("zodiacid is null");
            return (Criteria) this;
        }

        public Criteria andZodiacidIsNotNull() {
            addCriterion("zodiacid is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacidEqualTo(String value) {
            addCriterion("zodiacid =", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidNotEqualTo(String value) {
            addCriterion("zodiacid <>", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidGreaterThan(String value) {
            addCriterion("zodiacid >", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidGreaterThanOrEqualTo(String value) {
            addCriterion("zodiacid >=", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidLessThan(String value) {
            addCriterion("zodiacid <", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidLessThanOrEqualTo(String value) {
            addCriterion("zodiacid <=", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidLike(String value) {
            addCriterion("zodiacid like", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidNotLike(String value) {
            addCriterion("zodiacid not like", value, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidIn(List<String> values) {
            addCriterion("zodiacid in", values, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidNotIn(List<String> values) {
            addCriterion("zodiacid not in", values, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidBetween(String value1, String value2) {
            addCriterion("zodiacid between", value1, value2, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacidNotBetween(String value1, String value2) {
            addCriterion("zodiacid not between", value1, value2, "zodiacid");
            return (Criteria) this;
        }

        public Criteria andZodiacnameIsNull() {
            addCriterion("zodiacname is null");
            return (Criteria) this;
        }

        public Criteria andZodiacnameIsNotNull() {
            addCriterion("zodiacname is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacnameEqualTo(String value) {
            addCriterion("zodiacname =", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameNotEqualTo(String value) {
            addCriterion("zodiacname <>", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameGreaterThan(String value) {
            addCriterion("zodiacname >", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameGreaterThanOrEqualTo(String value) {
            addCriterion("zodiacname >=", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameLessThan(String value) {
            addCriterion("zodiacname <", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameLessThanOrEqualTo(String value) {
            addCriterion("zodiacname <=", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameLike(String value) {
            addCriterion("zodiacname like", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameNotLike(String value) {
            addCriterion("zodiacname not like", value, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameIn(List<String> values) {
            addCriterion("zodiacname in", values, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameNotIn(List<String> values) {
            addCriterion("zodiacname not in", values, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameBetween(String value1, String value2) {
            addCriterion("zodiacname between", value1, value2, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacnameNotBetween(String value1, String value2) {
            addCriterion("zodiacname not between", value1, value2, "zodiacname");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaIsNull() {
            addCriterion("zodiacguardBuddha is null");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaIsNotNull() {
            addCriterion("zodiacguardBuddha is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaEqualTo(String value) {
            addCriterion("zodiacguardBuddha =", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaNotEqualTo(String value) {
            addCriterion("zodiacguardBuddha <>", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaGreaterThan(String value) {
            addCriterion("zodiacguardBuddha >", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaGreaterThanOrEqualTo(String value) {
            addCriterion("zodiacguardBuddha >=", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaLessThan(String value) {
            addCriterion("zodiacguardBuddha <", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaLessThanOrEqualTo(String value) {
            addCriterion("zodiacguardBuddha <=", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaLike(String value) {
            addCriterion("zodiacguardBuddha like", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaNotLike(String value) {
            addCriterion("zodiacguardBuddha not like", value, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaIn(List<String> values) {
            addCriterion("zodiacguardBuddha in", values, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaNotIn(List<String> values) {
            addCriterion("zodiacguardBuddha not in", values, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaBetween(String value1, String value2) {
            addCriterion("zodiacguardBuddha between", value1, value2, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacguardbuddhaNotBetween(String value1, String value2) {
            addCriterion("zodiacguardBuddha not between", value1, value2, "zodiacguardbuddha");
            return (Criteria) this;
        }

        public Criteria andZodiacdescIsNull() {
            addCriterion("zodiacdesc is null");
            return (Criteria) this;
        }

        public Criteria andZodiacdescIsNotNull() {
            addCriterion("zodiacdesc is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacdescEqualTo(String value) {
            addCriterion("zodiacdesc =", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescNotEqualTo(String value) {
            addCriterion("zodiacdesc <>", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescGreaterThan(String value) {
            addCriterion("zodiacdesc >", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescGreaterThanOrEqualTo(String value) {
            addCriterion("zodiacdesc >=", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescLessThan(String value) {
            addCriterion("zodiacdesc <", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescLessThanOrEqualTo(String value) {
            addCriterion("zodiacdesc <=", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescLike(String value) {
            addCriterion("zodiacdesc like", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescNotLike(String value) {
            addCriterion("zodiacdesc not like", value, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescIn(List<String> values) {
            addCriterion("zodiacdesc in", values, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescNotIn(List<String> values) {
            addCriterion("zodiacdesc not in", values, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescBetween(String value1, String value2) {
            addCriterion("zodiacdesc between", value1, value2, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacdescNotBetween(String value1, String value2) {
            addCriterion("zodiacdesc not between", value1, value2, "zodiacdesc");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchIsNull() {
            addCriterion("zodiacmatch is null");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchIsNotNull() {
            addCriterion("zodiacmatch is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchEqualTo(String value) {
            addCriterion("zodiacmatch =", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchNotEqualTo(String value) {
            addCriterion("zodiacmatch <>", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchGreaterThan(String value) {
            addCriterion("zodiacmatch >", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchGreaterThanOrEqualTo(String value) {
            addCriterion("zodiacmatch >=", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchLessThan(String value) {
            addCriterion("zodiacmatch <", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchLessThanOrEqualTo(String value) {
            addCriterion("zodiacmatch <=", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchLike(String value) {
            addCriterion("zodiacmatch like", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchNotLike(String value) {
            addCriterion("zodiacmatch not like", value, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchIn(List<String> values) {
            addCriterion("zodiacmatch in", values, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchNotIn(List<String> values) {
            addCriterion("zodiacmatch not in", values, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchBetween(String value1, String value2) {
            addCriterion("zodiacmatch between", value1, value2, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andZodiacmatchNotBetween(String value1, String value2) {
            addCriterion("zodiacmatch not between", value1, value2, "zodiacmatch");
            return (Criteria) this;
        }

        public Criteria andBaziIsNull() {
            addCriterion("bazi is null");
            return (Criteria) this;
        }

        public Criteria andBaziIsNotNull() {
            addCriterion("bazi is not null");
            return (Criteria) this;
        }

        public Criteria andBaziEqualTo(String value) {
            addCriterion("bazi =", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziNotEqualTo(String value) {
            addCriterion("bazi <>", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziGreaterThan(String value) {
            addCriterion("bazi >", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziGreaterThanOrEqualTo(String value) {
            addCriterion("bazi >=", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziLessThan(String value) {
            addCriterion("bazi <", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziLessThanOrEqualTo(String value) {
            addCriterion("bazi <=", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziLike(String value) {
            addCriterion("bazi like", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziNotLike(String value) {
            addCriterion("bazi not like", value, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziIn(List<String> values) {
            addCriterion("bazi in", values, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziNotIn(List<String> values) {
            addCriterion("bazi not in", values, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziBetween(String value1, String value2) {
            addCriterion("bazi between", value1, value2, "bazi");
            return (Criteria) this;
        }

        public Criteria andBaziNotBetween(String value1, String value2) {
            addCriterion("bazi not between", value1, value2, "bazi");
            return (Criteria) this;
        }

        public Criteria andBazimatchIsNull() {
            addCriterion("bazimatch is null");
            return (Criteria) this;
        }

        public Criteria andBazimatchIsNotNull() {
            addCriterion("bazimatch is not null");
            return (Criteria) this;
        }

        public Criteria andBazimatchEqualTo(String value) {
            addCriterion("bazimatch =", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchNotEqualTo(String value) {
            addCriterion("bazimatch <>", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchGreaterThan(String value) {
            addCriterion("bazimatch >", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchGreaterThanOrEqualTo(String value) {
            addCriterion("bazimatch >=", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchLessThan(String value) {
            addCriterion("bazimatch <", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchLessThanOrEqualTo(String value) {
            addCriterion("bazimatch <=", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchLike(String value) {
            addCriterion("bazimatch like", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchNotLike(String value) {
            addCriterion("bazimatch not like", value, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchIn(List<String> values) {
            addCriterion("bazimatch in", values, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchNotIn(List<String> values) {
            addCriterion("bazimatch not in", values, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchBetween(String value1, String value2) {
            addCriterion("bazimatch between", value1, value2, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andBazimatchNotBetween(String value1, String value2) {
            addCriterion("bazimatch not between", value1, value2, "bazimatch");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(String value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(String value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(String value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(String value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(String value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(String value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLike(String value) {
            addCriterion("star like", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotLike(String value) {
            addCriterion("star not like", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<String> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<String> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(String value1, String value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(String value1, String value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarmatchIsNull() {
            addCriterion("starmatch is null");
            return (Criteria) this;
        }

        public Criteria andStarmatchIsNotNull() {
            addCriterion("starmatch is not null");
            return (Criteria) this;
        }

        public Criteria andStarmatchEqualTo(String value) {
            addCriterion("starmatch =", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchNotEqualTo(String value) {
            addCriterion("starmatch <>", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchGreaterThan(String value) {
            addCriterion("starmatch >", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchGreaterThanOrEqualTo(String value) {
            addCriterion("starmatch >=", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchLessThan(String value) {
            addCriterion("starmatch <", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchLessThanOrEqualTo(String value) {
            addCriterion("starmatch <=", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchLike(String value) {
            addCriterion("starmatch like", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchNotLike(String value) {
            addCriterion("starmatch not like", value, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchIn(List<String> values) {
            addCriterion("starmatch in", values, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchNotIn(List<String> values) {
            addCriterion("starmatch not in", values, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchBetween(String value1, String value2) {
            addCriterion("starmatch between", value1, value2, "starmatch");
            return (Criteria) this;
        }

        public Criteria andStarmatchNotBetween(String value1, String value2) {
            addCriterion("starmatch not between", value1, value2, "starmatch");
            return (Criteria) this;
        }

        public Criteria andZiweiIsNull() {
            addCriterion("ziwei is null");
            return (Criteria) this;
        }

        public Criteria andZiweiIsNotNull() {
            addCriterion("ziwei is not null");
            return (Criteria) this;
        }

        public Criteria andZiweiEqualTo(String value) {
            addCriterion("ziwei =", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiNotEqualTo(String value) {
            addCriterion("ziwei <>", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiGreaterThan(String value) {
            addCriterion("ziwei >", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiGreaterThanOrEqualTo(String value) {
            addCriterion("ziwei >=", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiLessThan(String value) {
            addCriterion("ziwei <", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiLessThanOrEqualTo(String value) {
            addCriterion("ziwei <=", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiLike(String value) {
            addCriterion("ziwei like", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiNotLike(String value) {
            addCriterion("ziwei not like", value, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiIn(List<String> values) {
            addCriterion("ziwei in", values, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiNotIn(List<String> values) {
            addCriterion("ziwei not in", values, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiBetween(String value1, String value2) {
            addCriterion("ziwei between", value1, value2, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweiNotBetween(String value1, String value2) {
            addCriterion("ziwei not between", value1, value2, "ziwei");
            return (Criteria) this;
        }

        public Criteria andZiweimatchIsNull() {
            addCriterion("ziweimatch is null");
            return (Criteria) this;
        }

        public Criteria andZiweimatchIsNotNull() {
            addCriterion("ziweimatch is not null");
            return (Criteria) this;
        }

        public Criteria andZiweimatchEqualTo(String value) {
            addCriterion("ziweimatch =", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchNotEqualTo(String value) {
            addCriterion("ziweimatch <>", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchGreaterThan(String value) {
            addCriterion("ziweimatch >", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchGreaterThanOrEqualTo(String value) {
            addCriterion("ziweimatch >=", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchLessThan(String value) {
            addCriterion("ziweimatch <", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchLessThanOrEqualTo(String value) {
            addCriterion("ziweimatch <=", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchLike(String value) {
            addCriterion("ziweimatch like", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchNotLike(String value) {
            addCriterion("ziweimatch not like", value, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchIn(List<String> values) {
            addCriterion("ziweimatch in", values, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchNotIn(List<String> values) {
            addCriterion("ziweimatch not in", values, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchBetween(String value1, String value2) {
            addCriterion("ziweimatch between", value1, value2, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andZiweimatchNotBetween(String value1, String value2) {
            addCriterion("ziweimatch not between", value1, value2, "ziweimatch");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(String value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(String value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(String value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(String value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(String value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(String value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLike(String value) {
            addCriterion("created like", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotLike(String value) {
            addCriterion("created not like", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<String> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<String> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(String value1, String value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(String value1, String value2) {
            addCriterion("created not between", value1, value2, "created");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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