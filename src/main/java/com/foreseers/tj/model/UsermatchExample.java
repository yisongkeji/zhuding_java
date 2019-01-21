package com.foreseers.tj.model;

import java.util.ArrayList;
import java.util.List;

public class UsermatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UsermatchExample() {
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

        public Criteria andZhuidIsNull() {
            addCriterion("zhuid is null");
            return (Criteria) this;
        }

        public Criteria andZhuidIsNotNull() {
            addCriterion("zhuid is not null");
            return (Criteria) this;
        }

        public Criteria andZhuidEqualTo(Integer value) {
            addCriterion("zhuid =", value, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidNotEqualTo(Integer value) {
            addCriterion("zhuid <>", value, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidGreaterThan(Integer value) {
            addCriterion("zhuid >", value, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhuid >=", value, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidLessThan(Integer value) {
            addCriterion("zhuid <", value, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidLessThanOrEqualTo(Integer value) {
            addCriterion("zhuid <=", value, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidIn(List<Integer> values) {
            addCriterion("zhuid in", values, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidNotIn(List<Integer> values) {
            addCriterion("zhuid not in", values, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidBetween(Integer value1, Integer value2) {
            addCriterion("zhuid between", value1, value2, "zhuid");
            return (Criteria) this;
        }

        public Criteria andZhuidNotBetween(Integer value1, Integer value2) {
            addCriterion("zhuid not between", value1, value2, "zhuid");
            return (Criteria) this;
        }

        public Criteria andCongidIsNull() {
            addCriterion("congid is null");
            return (Criteria) this;
        }

        public Criteria andCongidIsNotNull() {
            addCriterion("congid is not null");
            return (Criteria) this;
        }

        public Criteria andCongidEqualTo(Integer value) {
            addCriterion("congid =", value, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidNotEqualTo(Integer value) {
            addCriterion("congid <>", value, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidGreaterThan(Integer value) {
            addCriterion("congid >", value, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidGreaterThanOrEqualTo(Integer value) {
            addCriterion("congid >=", value, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidLessThan(Integer value) {
            addCriterion("congid <", value, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidLessThanOrEqualTo(Integer value) {
            addCriterion("congid <=", value, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidIn(List<Integer> values) {
            addCriterion("congid in", values, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidNotIn(List<Integer> values) {
            addCriterion("congid not in", values, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidBetween(Integer value1, Integer value2) {
            addCriterion("congid between", value1, value2, "congid");
            return (Criteria) this;
        }

        public Criteria andCongidNotBetween(Integer value1, Integer value2) {
            addCriterion("congid not between", value1, value2, "congid");
            return (Criteria) this;
        }

        public Criteria andUserscoreIsNull() {
            addCriterion("userscore is null");
            return (Criteria) this;
        }

        public Criteria andUserscoreIsNotNull() {
            addCriterion("userscore is not null");
            return (Criteria) this;
        }

        public Criteria andUserscoreEqualTo(Integer value) {
            addCriterion("userscore =", value, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreNotEqualTo(Integer value) {
            addCriterion("userscore <>", value, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreGreaterThan(Integer value) {
            addCriterion("userscore >", value, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("userscore >=", value, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreLessThan(Integer value) {
            addCriterion("userscore <", value, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreLessThanOrEqualTo(Integer value) {
            addCriterion("userscore <=", value, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreIn(List<Integer> values) {
            addCriterion("userscore in", values, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreNotIn(List<Integer> values) {
            addCriterion("userscore not in", values, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreBetween(Integer value1, Integer value2) {
            addCriterion("userscore between", value1, value2, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("userscore not between", value1, value2, "userscore");
            return (Criteria) this;
        }

        public Criteria andUserdescIsNull() {
            addCriterion("userdesc is null");
            return (Criteria) this;
        }

        public Criteria andUserdescIsNotNull() {
            addCriterion("userdesc is not null");
            return (Criteria) this;
        }

        public Criteria andUserdescEqualTo(String value) {
            addCriterion("userdesc =", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotEqualTo(String value) {
            addCriterion("userdesc <>", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescGreaterThan(String value) {
            addCriterion("userdesc >", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescGreaterThanOrEqualTo(String value) {
            addCriterion("userdesc >=", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescLessThan(String value) {
            addCriterion("userdesc <", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescLessThanOrEqualTo(String value) {
            addCriterion("userdesc <=", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescLike(String value) {
            addCriterion("userdesc like", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotLike(String value) {
            addCriterion("userdesc not like", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescIn(List<String> values) {
            addCriterion("userdesc in", values, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotIn(List<String> values) {
            addCriterion("userdesc not in", values, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescBetween(String value1, String value2) {
            addCriterion("userdesc between", value1, value2, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotBetween(String value1, String value2) {
            addCriterion("userdesc not between", value1, value2, "userdesc");
            return (Criteria) this;
        }

        public Criteria andCommentgoodIsNull() {
            addCriterion("commentgood is null");
            return (Criteria) this;
        }

        public Criteria andCommentgoodIsNotNull() {
            addCriterion("commentgood is not null");
            return (Criteria) this;
        }

        public Criteria andCommentgoodEqualTo(String value) {
            addCriterion("commentgood =", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodNotEqualTo(String value) {
            addCriterion("commentgood <>", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodGreaterThan(String value) {
            addCriterion("commentgood >", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodGreaterThanOrEqualTo(String value) {
            addCriterion("commentgood >=", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodLessThan(String value) {
            addCriterion("commentgood <", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodLessThanOrEqualTo(String value) {
            addCriterion("commentgood <=", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodLike(String value) {
            addCriterion("commentgood like", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodNotLike(String value) {
            addCriterion("commentgood not like", value, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodIn(List<String> values) {
            addCriterion("commentgood in", values, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodNotIn(List<String> values) {
            addCriterion("commentgood not in", values, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodBetween(String value1, String value2) {
            addCriterion("commentgood between", value1, value2, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentgoodNotBetween(String value1, String value2) {
            addCriterion("commentgood not between", value1, value2, "commentgood");
            return (Criteria) this;
        }

        public Criteria andCommentbadIsNull() {
            addCriterion("commentbad is null");
            return (Criteria) this;
        }

        public Criteria andCommentbadIsNotNull() {
            addCriterion("commentbad is not null");
            return (Criteria) this;
        }

        public Criteria andCommentbadEqualTo(String value) {
            addCriterion("commentbad =", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadNotEqualTo(String value) {
            addCriterion("commentbad <>", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadGreaterThan(String value) {
            addCriterion("commentbad >", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadGreaterThanOrEqualTo(String value) {
            addCriterion("commentbad >=", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadLessThan(String value) {
            addCriterion("commentbad <", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadLessThanOrEqualTo(String value) {
            addCriterion("commentbad <=", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadLike(String value) {
            addCriterion("commentbad like", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadNotLike(String value) {
            addCriterion("commentbad not like", value, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadIn(List<String> values) {
            addCriterion("commentbad in", values, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadNotIn(List<String> values) {
            addCriterion("commentbad not in", values, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadBetween(String value1, String value2) {
            addCriterion("commentbad between", value1, value2, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCommentbadNotBetween(String value1, String value2) {
            addCriterion("commentbad not between", value1, value2, "commentbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodIsNull() {
            addCriterion("characteristicgood is null");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodIsNotNull() {
            addCriterion("characteristicgood is not null");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodEqualTo(String value) {
            addCriterion("characteristicgood =", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodNotEqualTo(String value) {
            addCriterion("characteristicgood <>", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodGreaterThan(String value) {
            addCriterion("characteristicgood >", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodGreaterThanOrEqualTo(String value) {
            addCriterion("characteristicgood >=", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodLessThan(String value) {
            addCriterion("characteristicgood <", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodLessThanOrEqualTo(String value) {
            addCriterion("characteristicgood <=", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodLike(String value) {
            addCriterion("characteristicgood like", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodNotLike(String value) {
            addCriterion("characteristicgood not like", value, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodIn(List<String> values) {
            addCriterion("characteristicgood in", values, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodNotIn(List<String> values) {
            addCriterion("characteristicgood not in", values, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodBetween(String value1, String value2) {
            addCriterion("characteristicgood between", value1, value2, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicgoodNotBetween(String value1, String value2) {
            addCriterion("characteristicgood not between", value1, value2, "characteristicgood");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadIsNull() {
            addCriterion("characteristicbad is null");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadIsNotNull() {
            addCriterion("characteristicbad is not null");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadEqualTo(String value) {
            addCriterion("characteristicbad =", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadNotEqualTo(String value) {
            addCriterion("characteristicbad <>", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadGreaterThan(String value) {
            addCriterion("characteristicbad >", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadGreaterThanOrEqualTo(String value) {
            addCriterion("characteristicbad >=", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadLessThan(String value) {
            addCriterion("characteristicbad <", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadLessThanOrEqualTo(String value) {
            addCriterion("characteristicbad <=", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadLike(String value) {
            addCriterion("characteristicbad like", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadNotLike(String value) {
            addCriterion("characteristicbad not like", value, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadIn(List<String> values) {
            addCriterion("characteristicbad in", values, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadNotIn(List<String> values) {
            addCriterion("characteristicbad not in", values, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadBetween(String value1, String value2) {
            addCriterion("characteristicbad between", value1, value2, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andCharacteristicbadNotBetween(String value1, String value2) {
            addCriterion("characteristicbad not between", value1, value2, "characteristicbad");
            return (Criteria) this;
        }

        public Criteria andMindscoreIsNull() {
            addCriterion("mindscore is null");
            return (Criteria) this;
        }

        public Criteria andMindscoreIsNotNull() {
            addCriterion("mindscore is not null");
            return (Criteria) this;
        }

        public Criteria andMindscoreEqualTo(Integer value) {
            addCriterion("mindscore =", value, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreNotEqualTo(Integer value) {
            addCriterion("mindscore <>", value, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreGreaterThan(Integer value) {
            addCriterion("mindscore >", value, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("mindscore >=", value, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreLessThan(Integer value) {
            addCriterion("mindscore <", value, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreLessThanOrEqualTo(Integer value) {
            addCriterion("mindscore <=", value, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreIn(List<Integer> values) {
            addCriterion("mindscore in", values, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreNotIn(List<Integer> values) {
            addCriterion("mindscore not in", values, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreBetween(Integer value1, Integer value2) {
            addCriterion("mindscore between", value1, value2, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMindscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("mindscore not between", value1, value2, "mindscore");
            return (Criteria) this;
        }

        public Criteria andMinddescIsNull() {
            addCriterion("minddesc is null");
            return (Criteria) this;
        }

        public Criteria andMinddescIsNotNull() {
            addCriterion("minddesc is not null");
            return (Criteria) this;
        }

        public Criteria andMinddescEqualTo(String value) {
            addCriterion("minddesc =", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescNotEqualTo(String value) {
            addCriterion("minddesc <>", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescGreaterThan(String value) {
            addCriterion("minddesc >", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescGreaterThanOrEqualTo(String value) {
            addCriterion("minddesc >=", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescLessThan(String value) {
            addCriterion("minddesc <", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescLessThanOrEqualTo(String value) {
            addCriterion("minddesc <=", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescLike(String value) {
            addCriterion("minddesc like", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescNotLike(String value) {
            addCriterion("minddesc not like", value, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescIn(List<String> values) {
            addCriterion("minddesc in", values, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescNotIn(List<String> values) {
            addCriterion("minddesc not in", values, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescBetween(String value1, String value2) {
            addCriterion("minddesc between", value1, value2, "minddesc");
            return (Criteria) this;
        }

        public Criteria andMinddescNotBetween(String value1, String value2) {
            addCriterion("minddesc not between", value1, value2, "minddesc");
            return (Criteria) this;
        }

        public Criteria andBodyscoreIsNull() {
            addCriterion("bodyscore is null");
            return (Criteria) this;
        }

        public Criteria andBodyscoreIsNotNull() {
            addCriterion("bodyscore is not null");
            return (Criteria) this;
        }

        public Criteria andBodyscoreEqualTo(Integer value) {
            addCriterion("bodyscore =", value, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreNotEqualTo(Integer value) {
            addCriterion("bodyscore <>", value, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreGreaterThan(Integer value) {
            addCriterion("bodyscore >", value, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("bodyscore >=", value, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreLessThan(Integer value) {
            addCriterion("bodyscore <", value, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreLessThanOrEqualTo(Integer value) {
            addCriterion("bodyscore <=", value, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreIn(List<Integer> values) {
            addCriterion("bodyscore in", values, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreNotIn(List<Integer> values) {
            addCriterion("bodyscore not in", values, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreBetween(Integer value1, Integer value2) {
            addCriterion("bodyscore between", value1, value2, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodyscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("bodyscore not between", value1, value2, "bodyscore");
            return (Criteria) this;
        }

        public Criteria andBodydescIsNull() {
            addCriterion("bodydesc is null");
            return (Criteria) this;
        }

        public Criteria andBodydescIsNotNull() {
            addCriterion("bodydesc is not null");
            return (Criteria) this;
        }

        public Criteria andBodydescEqualTo(String value) {
            addCriterion("bodydesc =", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescNotEqualTo(String value) {
            addCriterion("bodydesc <>", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescGreaterThan(String value) {
            addCriterion("bodydesc >", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescGreaterThanOrEqualTo(String value) {
            addCriterion("bodydesc >=", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescLessThan(String value) {
            addCriterion("bodydesc <", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescLessThanOrEqualTo(String value) {
            addCriterion("bodydesc <=", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescLike(String value) {
            addCriterion("bodydesc like", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescNotLike(String value) {
            addCriterion("bodydesc not like", value, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescIn(List<String> values) {
            addCriterion("bodydesc in", values, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescNotIn(List<String> values) {
            addCriterion("bodydesc not in", values, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescBetween(String value1, String value2) {
            addCriterion("bodydesc between", value1, value2, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andBodydescNotBetween(String value1, String value2) {
            addCriterion("bodydesc not between", value1, value2, "bodydesc");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreIsNull() {
            addCriterion("characterscore is null");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreIsNotNull() {
            addCriterion("characterscore is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreEqualTo(Integer value) {
            addCriterion("characterscore =", value, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreNotEqualTo(Integer value) {
            addCriterion("characterscore <>", value, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreGreaterThan(Integer value) {
            addCriterion("characterscore >", value, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("characterscore >=", value, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreLessThan(Integer value) {
            addCriterion("characterscore <", value, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreLessThanOrEqualTo(Integer value) {
            addCriterion("characterscore <=", value, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreIn(List<Integer> values) {
            addCriterion("characterscore in", values, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreNotIn(List<Integer> values) {
            addCriterion("characterscore not in", values, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreBetween(Integer value1, Integer value2) {
            addCriterion("characterscore between", value1, value2, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("characterscore not between", value1, value2, "characterscore");
            return (Criteria) this;
        }

        public Criteria andCharacterdescIsNull() {
            addCriterion("characterdesc is null");
            return (Criteria) this;
        }

        public Criteria andCharacterdescIsNotNull() {
            addCriterion("characterdesc is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterdescEqualTo(String value) {
            addCriterion("characterdesc =", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescNotEqualTo(String value) {
            addCriterion("characterdesc <>", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescGreaterThan(String value) {
            addCriterion("characterdesc >", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescGreaterThanOrEqualTo(String value) {
            addCriterion("characterdesc >=", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescLessThan(String value) {
            addCriterion("characterdesc <", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescLessThanOrEqualTo(String value) {
            addCriterion("characterdesc <=", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescLike(String value) {
            addCriterion("characterdesc like", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescNotLike(String value) {
            addCriterion("characterdesc not like", value, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescIn(List<String> values) {
            addCriterion("characterdesc in", values, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescNotIn(List<String> values) {
            addCriterion("characterdesc not in", values, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescBetween(String value1, String value2) {
            addCriterion("characterdesc between", value1, value2, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andCharacterdescNotBetween(String value1, String value2) {
            addCriterion("characterdesc not between", value1, value2, "characterdesc");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
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

        public Criteria andSpare2IsNull() {
            addCriterion("spare2 is null");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNotNull() {
            addCriterion("spare2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare2EqualTo(String value) {
            addCriterion("spare2 =", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotEqualTo(String value) {
            addCriterion("spare2 <>", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThan(String value) {
            addCriterion("spare2 >", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThanOrEqualTo(String value) {
            addCriterion("spare2 >=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThan(String value) {
            addCriterion("spare2 <", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThanOrEqualTo(String value) {
            addCriterion("spare2 <=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Like(String value) {
            addCriterion("spare2 like", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotLike(String value) {
            addCriterion("spare2 not like", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2In(List<String> values) {
            addCriterion("spare2 in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotIn(List<String> values) {
            addCriterion("spare2 not in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Between(String value1, String value2) {
            addCriterion("spare2 between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotBetween(String value1, String value2) {
            addCriterion("spare2 not between", value1, value2, "spare2");
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