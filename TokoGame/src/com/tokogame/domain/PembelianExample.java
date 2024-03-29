package com.tokogame.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PembelianExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public PembelianExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    protected PembelianExample(PembelianExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
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
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
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

        public Criteria andPkPembelianIsNull() {
            addCriterion("pk_pembelian is null");
            return this;
        }

        public Criteria andPkPembelianIsNotNull() {
            addCriterion("pk_pembelian is not null");
            return this;
        }

        public Criteria andPkPembelianEqualTo(Integer value) {
            addCriterion("pk_pembelian =", value, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianNotEqualTo(Integer value) {
            addCriterion("pk_pembelian <>", value, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianGreaterThan(Integer value) {
            addCriterion("pk_pembelian >", value, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_pembelian >=", value, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianLessThan(Integer value) {
            addCriterion("pk_pembelian <", value, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianLessThanOrEqualTo(Integer value) {
            addCriterion("pk_pembelian <=", value, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianIn(List<Integer> values) {
            addCriterion("pk_pembelian in", values, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianNotIn(List<Integer> values) {
            addCriterion("pk_pembelian not in", values, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianBetween(Integer value1, Integer value2) {
            addCriterion("pk_pembelian between", value1, value2, "pkPembelian");
            return this;
        }

        public Criteria andPkPembelianNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_pembelian not between", value1, value2, "pkPembelian");
            return this;
        }

        public Criteria andNotaIsNull() {
            addCriterion("nota is null");
            return this;
        }

        public Criteria andNotaIsNotNull() {
            addCriterion("nota is not null");
            return this;
        }

        public Criteria andNotaEqualTo(String value) {
            addCriterion("nota =", value, "nota");
            return this;
        }

        public Criteria andNotaNotEqualTo(String value) {
            addCriterion("nota <>", value, "nota");
            return this;
        }

        public Criteria andNotaGreaterThan(String value) {
            addCriterion("nota >", value, "nota");
            return this;
        }

        public Criteria andNotaGreaterThanOrEqualTo(String value) {
            addCriterion("nota >=", value, "nota");
            return this;
        }

        public Criteria andNotaLessThan(String value) {
            addCriterion("nota <", value, "nota");
            return this;
        }

        public Criteria andNotaLessThanOrEqualTo(String value) {
            addCriterion("nota <=", value, "nota");
            return this;
        }

        public Criteria andNotaLike(String value) {
            addCriterion("nota like", value, "nota");
            return this;
        }

        public Criteria andNotaNotLike(String value) {
            addCriterion("nota not like", value, "nota");
            return this;
        }

        public Criteria andNotaIn(List<String> values) {
            addCriterion("nota in", values, "nota");
            return this;
        }

        public Criteria andNotaNotIn(List<String> values) {
            addCriterion("nota not in", values, "nota");
            return this;
        }

        public Criteria andNotaBetween(String value1, String value2) {
            addCriterion("nota between", value1, value2, "nota");
            return this;
        }

        public Criteria andNotaNotBetween(String value1, String value2) {
            addCriterion("nota not between", value1, value2, "nota");
            return this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return this;
        }

        public Criteria andTanggalBeliIsNull() {
            addCriterion("tanggal_beli is null");
            return this;
        }

        public Criteria andTanggalBeliIsNotNull() {
            addCriterion("tanggal_beli is not null");
            return this;
        }

        public Criteria andTanggalBeliEqualTo(Date value) {
            addCriterion("tanggal_beli =", value, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliNotEqualTo(Date value) {
            addCriterion("tanggal_beli <>", value, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliGreaterThan(Date value) {
            addCriterion("tanggal_beli >", value, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliGreaterThanOrEqualTo(Date value) {
            addCriterion("tanggal_beli >=", value, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliLessThan(Date value) {
            addCriterion("tanggal_beli <", value, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliLessThanOrEqualTo(Date value) {
            addCriterion("tanggal_beli <=", value, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliIn(List<Date> values) {
            addCriterion("tanggal_beli in", values, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliNotIn(List<Date> values) {
            addCriterion("tanggal_beli not in", values, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliBetween(Date value1, Date value2) {
            addCriterion("tanggal_beli between", value1, value2, "tanggalBeli");
            return this;
        }

        public Criteria andTanggalBeliNotBetween(Date value1, Date value2) {
            addCriterion("tanggal_beli not between", value1, value2, "tanggalBeli");
            return this;
        }
    }
}