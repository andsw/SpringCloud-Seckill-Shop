package cn.heshw.entity;

import java.util.ArrayList;
import java.util.List;

public class SpuDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpuDetailExample() {
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

        public Criteria andSpuIdIsNull() {
            addCriterion("spu_id is null");
            return (Criteria) this;
        }

        public Criteria andSpuIdIsNotNull() {
            addCriterion("spu_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpuIdEqualTo(Long value) {
            addCriterion("spu_id =", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdNotEqualTo(Long value) {
            addCriterion("spu_id <>", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdGreaterThan(Long value) {
            addCriterion("spu_id >", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("spu_id >=", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdLessThan(Long value) {
            addCriterion("spu_id <", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdLessThanOrEqualTo(Long value) {
            addCriterion("spu_id <=", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdIn(List<Long> values) {
            addCriterion("spu_id in", values, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdNotIn(List<Long> values) {
            addCriterion("spu_id not in", values, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdBetween(Long value1, Long value2) {
            addCriterion("spu_id between", value1, value2, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdNotBetween(Long value1, Long value2) {
            addCriterion("spu_id not between", value1, value2, "spuId");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIsNull() {
            addCriterion("config_info is null");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIsNotNull() {
            addCriterion("config_info is not null");
            return (Criteria) this;
        }

        public Criteria andConfigInfoEqualTo(String value) {
            addCriterion("config_info =", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotEqualTo(String value) {
            addCriterion("config_info <>", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoGreaterThan(String value) {
            addCriterion("config_info >", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoGreaterThanOrEqualTo(String value) {
            addCriterion("config_info >=", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLessThan(String value) {
            addCriterion("config_info <", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLessThanOrEqualTo(String value) {
            addCriterion("config_info <=", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLike(String value) {
            addCriterion("config_info like", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotLike(String value) {
            addCriterion("config_info not like", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIn(List<String> values) {
            addCriterion("config_info in", values, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotIn(List<String> values) {
            addCriterion("config_info not in", values, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoBetween(String value1, String value2) {
            addCriterion("config_info between", value1, value2, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotBetween(String value1, String value2) {
            addCriterion("config_info not between", value1, value2, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigOptionIsNull() {
            addCriterion("config_option is null");
            return (Criteria) this;
        }

        public Criteria andConfigOptionIsNotNull() {
            addCriterion("config_option is not null");
            return (Criteria) this;
        }

        public Criteria andConfigOptionEqualTo(String value) {
            addCriterion("config_option =", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionNotEqualTo(String value) {
            addCriterion("config_option <>", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionGreaterThan(String value) {
            addCriterion("config_option >", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionGreaterThanOrEqualTo(String value) {
            addCriterion("config_option >=", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionLessThan(String value) {
            addCriterion("config_option <", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionLessThanOrEqualTo(String value) {
            addCriterion("config_option <=", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionLike(String value) {
            addCriterion("config_option like", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionNotLike(String value) {
            addCriterion("config_option not like", value, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionIn(List<String> values) {
            addCriterion("config_option in", values, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionNotIn(List<String> values) {
            addCriterion("config_option not in", values, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionBetween(String value1, String value2) {
            addCriterion("config_option between", value1, value2, "configOption");
            return (Criteria) this;
        }

        public Criteria andConfigOptionNotBetween(String value1, String value2) {
            addCriterion("config_option not between", value1, value2, "configOption");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListIsNull() {
            addCriterion("accessories_list is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListIsNotNull() {
            addCriterion("accessories_list is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListEqualTo(String value) {
            addCriterion("accessories_list =", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListNotEqualTo(String value) {
            addCriterion("accessories_list <>", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListGreaterThan(String value) {
            addCriterion("accessories_list >", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_list >=", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListLessThan(String value) {
            addCriterion("accessories_list <", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListLessThanOrEqualTo(String value) {
            addCriterion("accessories_list <=", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListLike(String value) {
            addCriterion("accessories_list like", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListNotLike(String value) {
            addCriterion("accessories_list not like", value, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListIn(List<String> values) {
            addCriterion("accessories_list in", values, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListNotIn(List<String> values) {
            addCriterion("accessories_list not in", values, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListBetween(String value1, String value2) {
            addCriterion("accessories_list between", value1, value2, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAccessoriesListNotBetween(String value1, String value2) {
            addCriterion("accessories_list not between", value1, value2, "accessoriesList");
            return (Criteria) this;
        }

        public Criteria andAfterSaleIsNull() {
            addCriterion("after_sale is null");
            return (Criteria) this;
        }

        public Criteria andAfterSaleIsNotNull() {
            addCriterion("after_sale is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSaleEqualTo(String value) {
            addCriterion("after_sale =", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleNotEqualTo(String value) {
            addCriterion("after_sale <>", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleGreaterThan(String value) {
            addCriterion("after_sale >", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleGreaterThanOrEqualTo(String value) {
            addCriterion("after_sale >=", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleLessThan(String value) {
            addCriterion("after_sale <", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleLessThanOrEqualTo(String value) {
            addCriterion("after_sale <=", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleLike(String value) {
            addCriterion("after_sale like", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleNotLike(String value) {
            addCriterion("after_sale not like", value, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleIn(List<String> values) {
            addCriterion("after_sale in", values, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleNotIn(List<String> values) {
            addCriterion("after_sale not in", values, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleBetween(String value1, String value2) {
            addCriterion("after_sale between", value1, value2, "afterSale");
            return (Criteria) this;
        }

        public Criteria andAfterSaleNotBetween(String value1, String value2) {
            addCriterion("after_sale not between", value1, value2, "afterSale");
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