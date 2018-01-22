package com.geek.cms.modules.sys.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.geek.cms.plugin.grid.splitPage.SplitPage;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    public SplitPage page;

    public SplitPage getPage() {
		return page;
	}

	public void setPage(SplitPage page) {
		this.page = page;
	}
    public RoleExample() {
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
        public List<Criterion> criteria;

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

        public Criteria andPermissionNameIsNull() {
            addCriterion("permission_name is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("permission_name =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("permission_name <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("permission_name >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_name >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("permission_name <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("permission_name <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("permission_name like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("permission_name not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("permission_name in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("permission_name not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("permission_name between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("permission_name not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIsNull() {
            addCriterion("permission_code is null");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIsNotNull() {
            addCriterion("permission_code is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeEqualTo(String value) {
            addCriterion("permission_code =", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotEqualTo(String value) {
            addCriterion("permission_code <>", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeGreaterThan(String value) {
            addCriterion("permission_code >", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("permission_code >=", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLessThan(String value) {
            addCriterion("permission_code <", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLessThanOrEqualTo(String value) {
            addCriterion("permission_code <=", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLike(String value) {
            addCriterion("permission_code like", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotLike(String value) {
            addCriterion("permission_code not like", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIn(List<String> values) {
            addCriterion("permission_code in", values, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotIn(List<String> values) {
            addCriterion("permission_code not in", values, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeBetween(String value1, String value2) {
            addCriterion("permission_code between", value1, value2, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotBetween(String value1, String value2) {
            addCriterion("permission_code not between", value1, value2, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkIsNull() {
            addCriterion("permission_mark is null");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkIsNotNull() {
            addCriterion("permission_mark is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkEqualTo(String value) {
            addCriterion("permission_mark =", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotEqualTo(String value) {
            addCriterion("permission_mark <>", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkGreaterThan(String value) {
            addCriterion("permission_mark >", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkGreaterThanOrEqualTo(String value) {
            addCriterion("permission_mark >=", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkLessThan(String value) {
            addCriterion("permission_mark <", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkLessThanOrEqualTo(String value) {
            addCriterion("permission_mark <=", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkLike(String value) {
            addCriterion("permission_mark like", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotLike(String value) {
            addCriterion("permission_mark not like", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkIn(List<String> values) {
            addCriterion("permission_mark in", values, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotIn(List<String> values) {
            addCriterion("permission_mark not in", values, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkBetween(String value1, String value2) {
            addCriterion("permission_mark between", value1, value2, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotBetween(String value1, String value2) {
            addCriterion("permission_mark not between", value1, value2, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLastUserIsNull() {
            addCriterion("last_user is null");
            return (Criteria) this;
        }

        public Criteria andLastUserIsNotNull() {
            addCriterion("last_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastUserEqualTo(String value) {
            addCriterion("last_user =", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserNotEqualTo(String value) {
            addCriterion("last_user <>", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserGreaterThan(String value) {
            addCriterion("last_user >", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserGreaterThanOrEqualTo(String value) {
            addCriterion("last_user >=", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserLessThan(String value) {
            addCriterion("last_user <", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserLessThanOrEqualTo(String value) {
            addCriterion("last_user <=", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserLike(String value) {
            addCriterion("last_user like", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserNotLike(String value) {
            addCriterion("last_user not like", value, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserIn(List<String> values) {
            addCriterion("last_user in", values, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserNotIn(List<String> values) {
            addCriterion("last_user not in", values, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserBetween(String value1, String value2) {
            addCriterion("last_user between", value1, value2, "lastUser");
            return (Criteria) this;
        }

        public Criteria andLastUserNotBetween(String value1, String value2) {
            addCriterion("last_user not between", value1, value2, "lastUser");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(String value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(String value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(String value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(String value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(String value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(String value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLike(String value) {
            addCriterion("is_enable like", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotLike(String value) {
            addCriterion("is_enable not like", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<String> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<String> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(String value1, String value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(String value1, String value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
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

        public Criterion(String condition, Object value) {
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