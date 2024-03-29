package com.tokogame.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromoDetailExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public PromoDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    protected PromoDetailExample(PromoDetailExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table promo_detail
     *
     * @ibatorgenerated Sun May 12 15:46:16 ICT 2013
     */
    public static class Criteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andPkPromoDetailIsNull() {
            addCriterion("pk_promo_detail is null");
            return this;
        }

        public Criteria andPkPromoDetailIsNotNull() {
            addCriterion("pk_promo_detail is not null");
            return this;
        }

        public Criteria andPkPromoDetailEqualTo(Integer value) {
            addCriterion("pk_promo_detail =", value, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailNotEqualTo(Integer value) {
            addCriterion("pk_promo_detail <>", value, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailGreaterThan(Integer value) {
            addCriterion("pk_promo_detail >", value, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_promo_detail >=", value, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailLessThan(Integer value) {
            addCriterion("pk_promo_detail <", value, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailLessThanOrEqualTo(Integer value) {
            addCriterion("pk_promo_detail <=", value, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailIn(List<Integer> values) {
            addCriterion("pk_promo_detail in", values, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailNotIn(List<Integer> values) {
            addCriterion("pk_promo_detail not in", values, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailBetween(Integer value1, Integer value2) {
            addCriterion("pk_promo_detail between", value1, value2, "pkPromoDetail");
            return this;
        }

        public Criteria andPkPromoDetailNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_promo_detail not between", value1, value2, "pkPromoDetail");
            return this;
        }

        public Criteria andFkPromoMainIsNull() {
            addCriterion("fk_promo_main is null");
            return this;
        }

        public Criteria andFkPromoMainIsNotNull() {
            addCriterion("fk_promo_main is not null");
            return this;
        }

        public Criteria andFkPromoMainEqualTo(Integer value) {
            addCriterion("fk_promo_main =", value, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainNotEqualTo(Integer value) {
            addCriterion("fk_promo_main <>", value, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainGreaterThan(Integer value) {
            addCriterion("fk_promo_main >", value, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_promo_main >=", value, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainLessThan(Integer value) {
            addCriterion("fk_promo_main <", value, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainLessThanOrEqualTo(Integer value) {
            addCriterion("fk_promo_main <=", value, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainIn(List<Integer> values) {
            addCriterion("fk_promo_main in", values, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainNotIn(List<Integer> values) {
            addCriterion("fk_promo_main not in", values, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainBetween(Integer value1, Integer value2) {
            addCriterion("fk_promo_main between", value1, value2, "fkPromoMain");
            return this;
        }

        public Criteria andFkPromoMainNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_promo_main not between", value1, value2, "fkPromoMain");
            return this;
        }

        public Criteria andFkItemIsNull() {
            addCriterion("fk_item is null");
            return this;
        }

        public Criteria andFkItemIsNotNull() {
            addCriterion("fk_item is not null");
            return this;
        }

        public Criteria andFkItemEqualTo(Integer value) {
            addCriterion("fk_item =", value, "fkItem");
            return this;
        }

        public Criteria andFkItemNotEqualTo(Integer value) {
            addCriterion("fk_item <>", value, "fkItem");
            return this;
        }

        public Criteria andFkItemGreaterThan(Integer value) {
            addCriterion("fk_item >", value, "fkItem");
            return this;
        }

        public Criteria andFkItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_item >=", value, "fkItem");
            return this;
        }

        public Criteria andFkItemLessThan(Integer value) {
            addCriterion("fk_item <", value, "fkItem");
            return this;
        }

        public Criteria andFkItemLessThanOrEqualTo(Integer value) {
            addCriterion("fk_item <=", value, "fkItem");
            return this;
        }

        public Criteria andFkItemIn(List<Integer> values) {
            addCriterion("fk_item in", values, "fkItem");
            return this;
        }

        public Criteria andFkItemNotIn(List<Integer> values) {
            addCriterion("fk_item not in", values, "fkItem");
            return this;
        }

        public Criteria andFkItemBetween(Integer value1, Integer value2) {
            addCriterion("fk_item between", value1, value2, "fkItem");
            return this;
        }

        public Criteria andFkItemNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_item not between", value1, value2, "fkItem");
            return this;
        }

        public Criteria andNilaiDiskonIsNull() {
            addCriterion("nilai_diskon is null");
            return this;
        }

        public Criteria andNilaiDiskonIsNotNull() {
            addCriterion("nilai_diskon is not null");
            return this;
        }

        public Criteria andNilaiDiskonEqualTo(Integer value) {
            addCriterion("nilai_diskon =", value, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonNotEqualTo(Integer value) {
            addCriterion("nilai_diskon <>", value, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonGreaterThan(Integer value) {
            addCriterion("nilai_diskon >", value, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonGreaterThanOrEqualTo(Integer value) {
            addCriterion("nilai_diskon >=", value, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonLessThan(Integer value) {
            addCriterion("nilai_diskon <", value, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonLessThanOrEqualTo(Integer value) {
            addCriterion("nilai_diskon <=", value, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonIn(List<Integer> values) {
            addCriterion("nilai_diskon in", values, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonNotIn(List<Integer> values) {
            addCriterion("nilai_diskon not in", values, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonBetween(Integer value1, Integer value2) {
            addCriterion("nilai_diskon between", value1, value2, "nilaiDiskon");
            return this;
        }

        public Criteria andNilaiDiskonNotBetween(Integer value1, Integer value2) {
            addCriterion("nilai_diskon not between", value1, value2, "nilaiDiskon");
            return this;
        }

        public Criteria andJenisDiskonIsNull() {
            addCriterion("jenis_diskon is null");
            return this;
        }

        public Criteria andJenisDiskonIsNotNull() {
            addCriterion("jenis_diskon is not null");
            return this;
        }

        public Criteria andJenisDiskonEqualTo(String value) {
            addCriterion("jenis_diskon =", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonNotEqualTo(String value) {
            addCriterion("jenis_diskon <>", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonGreaterThan(String value) {
            addCriterion("jenis_diskon >", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonGreaterThanOrEqualTo(String value) {
            addCriterion("jenis_diskon >=", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonLessThan(String value) {
            addCriterion("jenis_diskon <", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonLessThanOrEqualTo(String value) {
            addCriterion("jenis_diskon <=", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonLike(String value) {
            addCriterion("jenis_diskon like", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonNotLike(String value) {
            addCriterion("jenis_diskon not like", value, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonIn(List<String> values) {
            addCriterion("jenis_diskon in", values, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonNotIn(List<String> values) {
            addCriterion("jenis_diskon not in", values, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonBetween(String value1, String value2) {
            addCriterion("jenis_diskon between", value1, value2, "jenisDiskon");
            return this;
        }

        public Criteria andJenisDiskonNotBetween(String value1, String value2) {
            addCriterion("jenis_diskon not between", value1, value2, "jenisDiskon");
            return this;
        }
    }
}