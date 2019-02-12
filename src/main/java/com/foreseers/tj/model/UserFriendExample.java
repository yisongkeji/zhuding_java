package com.foreseers.tj.model;

import java.util.ArrayList;
import java.util.List;

public class UserFriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserFriendExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNull() {
            addCriterion("friend_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("friend_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(String value) {
            addCriterion("friend_id =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(String value) {
            addCriterion("friend_id <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(String value) {
            addCriterion("friend_id >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(String value) {
            addCriterion("friend_id >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(String value) {
            addCriterion("friend_id <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(String value) {
            addCriterion("friend_id <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLike(String value) {
            addCriterion("friend_id like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotLike(String value) {
            addCriterion("friend_id not like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<String> values) {
            addCriterion("friend_id in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<String> values) {
            addCriterion("friend_id not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(String value1, String value2) {
            addCriterion("friend_id between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(String value1, String value2) {
            addCriterion("friend_id not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andUserReationIsNull() {
            addCriterion("user_reation is null");
            return (Criteria) this;
        }

        public Criteria andUserReationIsNotNull() {
            addCriterion("user_reation is not null");
            return (Criteria) this;
        }

        public Criteria andUserReationEqualTo(Integer value) {
            addCriterion("user_reation =", value, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationNotEqualTo(Integer value) {
            addCriterion("user_reation <>", value, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationGreaterThan(Integer value) {
            addCriterion("user_reation >", value, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_reation >=", value, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationLessThan(Integer value) {
            addCriterion("user_reation <", value, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationLessThanOrEqualTo(Integer value) {
            addCriterion("user_reation <=", value, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationIn(List<Integer> values) {
            addCriterion("user_reation in", values, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationNotIn(List<Integer> values) {
            addCriterion("user_reation not in", values, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationBetween(Integer value1, Integer value2) {
            addCriterion("user_reation between", value1, value2, "userReation");
            return (Criteria) this;
        }

        public Criteria andUserReationNotBetween(Integer value1, Integer value2) {
            addCriterion("user_reation not between", value1, value2, "userReation");
            return (Criteria) this;
        }

        public Criteria andFirendtimeIsNull() {
            addCriterion("firendtime is null");
            return (Criteria) this;
        }

        public Criteria andFirendtimeIsNotNull() {
            addCriterion("firendtime is not null");
            return (Criteria) this;
        }

        public Criteria andFirendtimeEqualTo(String value) {
            addCriterion("firendtime =", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeNotEqualTo(String value) {
            addCriterion("firendtime <>", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeGreaterThan(String value) {
            addCriterion("firendtime >", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("firendtime >=", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeLessThan(String value) {
            addCriterion("firendtime <", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeLessThanOrEqualTo(String value) {
            addCriterion("firendtime <=", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeLike(String value) {
            addCriterion("firendtime like", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeNotLike(String value) {
            addCriterion("firendtime not like", value, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeIn(List<String> values) {
            addCriterion("firendtime in", values, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeNotIn(List<String> values) {
            addCriterion("firendtime not in", values, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeBetween(String value1, String value2) {
            addCriterion("firendtime between", value1, value2, "firendtime");
            return (Criteria) this;
        }

        public Criteria andFirendtimeNotBetween(String value1, String value2) {
            addCriterion("firendtime not between", value1, value2, "firendtime");
            return (Criteria) this;
        }

        public Criteria andLookheadIsNull() {
            addCriterion("lookhead is null");
            return (Criteria) this;
        }

        public Criteria andLookheadIsNotNull() {
            addCriterion("lookhead is not null");
            return (Criteria) this;
        }

        public Criteria andLookheadEqualTo(Integer value) {
            addCriterion("lookhead =", value, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadNotEqualTo(Integer value) {
            addCriterion("lookhead <>", value, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadGreaterThan(Integer value) {
            addCriterion("lookhead >", value, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadGreaterThanOrEqualTo(Integer value) {
            addCriterion("lookhead >=", value, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadLessThan(Integer value) {
            addCriterion("lookhead <", value, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadLessThanOrEqualTo(Integer value) {
            addCriterion("lookhead <=", value, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadIn(List<Integer> values) {
            addCriterion("lookhead in", values, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadNotIn(List<Integer> values) {
            addCriterion("lookhead not in", values, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadBetween(Integer value1, Integer value2) {
            addCriterion("lookhead between", value1, value2, "lookhead");
            return (Criteria) this;
        }

        public Criteria andLookheadNotBetween(Integer value1, Integer value2) {
            addCriterion("lookhead not between", value1, value2, "lookhead");
            return (Criteria) this;
        }

        public Criteria andSendpixIsNull() {
            addCriterion("sendpix is null");
            return (Criteria) this;
        }

        public Criteria andSendpixIsNotNull() {
            addCriterion("sendpix is not null");
            return (Criteria) this;
        }

        public Criteria andSendpixEqualTo(Integer value) {
            addCriterion("sendpix =", value, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixNotEqualTo(Integer value) {
            addCriterion("sendpix <>", value, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixGreaterThan(Integer value) {
            addCriterion("sendpix >", value, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendpix >=", value, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixLessThan(Integer value) {
            addCriterion("sendpix <", value, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixLessThanOrEqualTo(Integer value) {
            addCriterion("sendpix <=", value, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixIn(List<Integer> values) {
            addCriterion("sendpix in", values, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixNotIn(List<Integer> values) {
            addCriterion("sendpix not in", values, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixBetween(Integer value1, Integer value2) {
            addCriterion("sendpix between", value1, value2, "sendpix");
            return (Criteria) this;
        }

        public Criteria andSendpixNotBetween(Integer value1, Integer value2) {
            addCriterion("sendpix not between", value1, value2, "sendpix");
            return (Criteria) this;
        }

        public Criteria andLookimagesIsNull() {
            addCriterion("lookimages is null");
            return (Criteria) this;
        }

        public Criteria andLookimagesIsNotNull() {
            addCriterion("lookimages is not null");
            return (Criteria) this;
        }

        public Criteria andLookimagesEqualTo(Integer value) {
            addCriterion("lookimages =", value, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesNotEqualTo(Integer value) {
            addCriterion("lookimages <>", value, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesGreaterThan(Integer value) {
            addCriterion("lookimages >", value, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("lookimages >=", value, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesLessThan(Integer value) {
            addCriterion("lookimages <", value, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesLessThanOrEqualTo(Integer value) {
            addCriterion("lookimages <=", value, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesIn(List<Integer> values) {
            addCriterion("lookimages in", values, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesNotIn(List<Integer> values) {
            addCriterion("lookimages not in", values, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesBetween(Integer value1, Integer value2) {
            addCriterion("lookimages between", value1, value2, "lookimages");
            return (Criteria) this;
        }

        public Criteria andLookimagesNotBetween(Integer value1, Integer value2) {
            addCriterion("lookimages not between", value1, value2, "lookimages");
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