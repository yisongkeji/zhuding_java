package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andZoneIsNull() {
            addCriterion("zone is null");
            return (Criteria) this;
        }

        public Criteria andZoneIsNotNull() {
            addCriterion("zone is not null");
            return (Criteria) this;
        }

        public Criteria andZoneEqualTo(Integer value) {
            addCriterion("zone =", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotEqualTo(Integer value) {
            addCriterion("zone <>", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThan(Integer value) {
            addCriterion("zone >", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("zone >=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThan(Integer value) {
            addCriterion("zone <", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThanOrEqualTo(Integer value) {
            addCriterion("zone <=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneIn(List<Integer> values) {
            addCriterion("zone in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotIn(List<Integer> values) {
            addCriterion("zone not in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneBetween(Integer value1, Integer value2) {
            addCriterion("zone between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotBetween(Integer value1, Integer value2) {
            addCriterion("zone not between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andFacebookIsNull() {
            addCriterion("facebook is null");
            return (Criteria) this;
        }

        public Criteria andFacebookIsNotNull() {
            addCriterion("facebook is not null");
            return (Criteria) this;
        }

        public Criteria andFacebookEqualTo(String value) {
            addCriterion("facebook =", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookNotEqualTo(String value) {
            addCriterion("facebook <>", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookGreaterThan(String value) {
            addCriterion("facebook >", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookGreaterThanOrEqualTo(String value) {
            addCriterion("facebook >=", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookLessThan(String value) {
            addCriterion("facebook <", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookLessThanOrEqualTo(String value) {
            addCriterion("facebook <=", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookLike(String value) {
            addCriterion("facebook like", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookNotLike(String value) {
            addCriterion("facebook not like", value, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookIn(List<String> values) {
            addCriterion("facebook in", values, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookNotIn(List<String> values) {
            addCriterion("facebook not in", values, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookBetween(String value1, String value2) {
            addCriterion("facebook between", value1, value2, "facebook");
            return (Criteria) this;
        }

        public Criteria andFacebookNotBetween(String value1, String value2) {
            addCriterion("facebook not between", value1, value2, "facebook");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andHeadIsNull() {
            addCriterion("head is null");
            return (Criteria) this;
        }

        public Criteria andHeadIsNotNull() {
            addCriterion("head is not null");
            return (Criteria) this;
        }

        public Criteria andHeadEqualTo(String value) {
            addCriterion("head =", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotEqualTo(String value) {
            addCriterion("head <>", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThan(String value) {
            addCriterion("head >", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThanOrEqualTo(String value) {
            addCriterion("head >=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThan(String value) {
            addCriterion("head <", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThanOrEqualTo(String value) {
            addCriterion("head <=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLike(String value) {
            addCriterion("head like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotLike(String value) {
            addCriterion("head not like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadIn(List<String> values) {
            addCriterion("head in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotIn(List<String> values) {
            addCriterion("head not in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadBetween(String value1, String value2) {
            addCriterion("head between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotBetween(String value1, String value2) {
            addCriterion("head not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andVipIsNull() {
            addCriterion("vip is null");
            return (Criteria) this;
        }

        public Criteria andVipIsNotNull() {
            addCriterion("vip is not null");
            return (Criteria) this;
        }

        public Criteria andVipEqualTo(Integer value) {
            addCriterion("vip =", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotEqualTo(Integer value) {
            addCriterion("vip <>", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipGreaterThan(Integer value) {
            addCriterion("vip >", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip >=", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipLessThan(Integer value) {
            addCriterion("vip <", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipLessThanOrEqualTo(Integer value) {
            addCriterion("vip <=", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipIn(List<Integer> values) {
            addCriterion("vip in", values, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotIn(List<Integer> values) {
            addCriterion("vip not in", values, "vip");
            return (Criteria) this;
        }

        public Criteria andVipBetween(Integer value1, Integer value2) {
            addCriterion("vip between", value1, value2, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotBetween(Integer value1, Integer value2) {
            addCriterion("vip not between", value1, value2, "vip");
            return (Criteria) this;
        }

        public Criteria andViptimeIsNull() {
            addCriterion("viptime is null");
            return (Criteria) this;
        }

        public Criteria andViptimeIsNotNull() {
            addCriterion("viptime is not null");
            return (Criteria) this;
        }

        public Criteria andViptimeEqualTo(String value) {
            addCriterion("viptime =", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeNotEqualTo(String value) {
            addCriterion("viptime <>", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeGreaterThan(String value) {
            addCriterion("viptime >", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeGreaterThanOrEqualTo(String value) {
            addCriterion("viptime >=", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeLessThan(String value) {
            addCriterion("viptime <", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeLessThanOrEqualTo(String value) {
            addCriterion("viptime <=", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeLike(String value) {
            addCriterion("viptime like", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeNotLike(String value) {
            addCriterion("viptime not like", value, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeIn(List<String> values) {
            addCriterion("viptime in", values, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeNotIn(List<String> values) {
            addCriterion("viptime not in", values, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeBetween(String value1, String value2) {
            addCriterion("viptime between", value1, value2, "viptime");
            return (Criteria) this;
        }

        public Criteria andViptimeNotBetween(String value1, String value2) {
            addCriterion("viptime not between", value1, value2, "viptime");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andXingzuoIsNull() {
            addCriterion("xingzuo is null");
            return (Criteria) this;
        }

        public Criteria andXingzuoIsNotNull() {
            addCriterion("xingzuo is not null");
            return (Criteria) this;
        }

        public Criteria andXingzuoEqualTo(String value) {
            addCriterion("xingzuo =", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotEqualTo(String value) {
            addCriterion("xingzuo <>", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoGreaterThan(String value) {
            addCriterion("xingzuo >", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoGreaterThanOrEqualTo(String value) {
            addCriterion("xingzuo >=", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoLessThan(String value) {
            addCriterion("xingzuo <", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoLessThanOrEqualTo(String value) {
            addCriterion("xingzuo <=", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoLike(String value) {
            addCriterion("xingzuo like", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotLike(String value) {
            addCriterion("xingzuo not like", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoIn(List<String> values) {
            addCriterion("xingzuo in", values, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotIn(List<String> values) {
            addCriterion("xingzuo not in", values, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoBetween(String value1, String value2) {
            addCriterion("xingzuo between", value1, value2, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotBetween(String value1, String value2) {
            addCriterion("xingzuo not between", value1, value2, "xingzuo");
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

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("lng not between", value1, value2, "lng");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andObligateIsNull() {
            addCriterion("obligate is null");
            return (Criteria) this;
        }

        public Criteria andObligateIsNotNull() {
            addCriterion("obligate is not null");
            return (Criteria) this;
        }

        public Criteria andObligateEqualTo(String value) {
            addCriterion("obligate =", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateNotEqualTo(String value) {
            addCriterion("obligate <>", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateGreaterThan(String value) {
            addCriterion("obligate >", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateGreaterThanOrEqualTo(String value) {
            addCriterion("obligate >=", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateLessThan(String value) {
            addCriterion("obligate <", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateLessThanOrEqualTo(String value) {
            addCriterion("obligate <=", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateLike(String value) {
            addCriterion("obligate like", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateNotLike(String value) {
            addCriterion("obligate not like", value, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateIn(List<String> values) {
            addCriterion("obligate in", values, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateNotIn(List<String> values) {
            addCriterion("obligate not in", values, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateBetween(String value1, String value2) {
            addCriterion("obligate between", value1, value2, "obligate");
            return (Criteria) this;
        }

        public Criteria andObligateNotBetween(String value1, String value2) {
            addCriterion("obligate not between", value1, value2, "obligate");
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