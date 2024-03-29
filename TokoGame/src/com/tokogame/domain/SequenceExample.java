package com.tokogame.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SequenceExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public SequenceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    protected SequenceExample(SequenceExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
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
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSequenceNoIsNull() {
            addCriterion("sequence_no is null");
            return this;
        }

        public Criteria andSequenceNoIsNotNull() {
            addCriterion("sequence_no is not null");
            return this;
        }

        public Criteria andSequenceNoEqualTo(Integer value) {
            addCriterion("sequence_no =", value, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoNotEqualTo(Integer value) {
            addCriterion("sequence_no <>", value, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoGreaterThan(Integer value) {
            addCriterion("sequence_no >", value, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence_no >=", value, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoLessThan(Integer value) {
            addCriterion("sequence_no <", value, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("sequence_no <=", value, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoIn(List<Integer> values) {
            addCriterion("sequence_no in", values, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoNotIn(List<Integer> values) {
            addCriterion("sequence_no not in", values, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no between", value1, value2, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no not between", value1, value2, "sequenceNo");
            return this;
        }

        public Criteria andSequenceNameIsNull() {
            addCriterion("sequence_name is null");
            return this;
        }

        public Criteria andSequenceNameIsNotNull() {
            addCriterion("sequence_name is not null");
            return this;
        }

        public Criteria andSequenceNameEqualTo(String value) {
            addCriterion("sequence_name =", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameNotEqualTo(String value) {
            addCriterion("sequence_name <>", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameGreaterThan(String value) {
            addCriterion("sequence_name >", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameGreaterThanOrEqualTo(String value) {
            addCriterion("sequence_name >=", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameLessThan(String value) {
            addCriterion("sequence_name <", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameLessThanOrEqualTo(String value) {
            addCriterion("sequence_name <=", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameLike(String value) {
            addCriterion("sequence_name like", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameNotLike(String value) {
            addCriterion("sequence_name not like", value, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameIn(List<String> values) {
            addCriterion("sequence_name in", values, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameNotIn(List<String> values) {
            addCriterion("sequence_name not in", values, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameBetween(String value1, String value2) {
            addCriterion("sequence_name between", value1, value2, "sequenceName");
            return this;
        }

        public Criteria andSequenceNameNotBetween(String value1, String value2) {
            addCriterion("sequence_name not between", value1, value2, "sequenceName");
            return this;
        }

        public Criteria andSequenceDateIsNull() {
            addCriterion("sequence_date is null");
            return this;
        }

        public Criteria andSequenceDateIsNotNull() {
            addCriterion("sequence_date is not null");
            return this;
        }

        public Criteria andSequenceDateEqualTo(Date value) {
            addCriterionForJDBCDate("sequence_date =", value, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sequence_date <>", value, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sequence_date >", value, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sequence_date >=", value, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateLessThan(Date value) {
            addCriterionForJDBCDate("sequence_date <", value, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sequence_date <=", value, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateIn(List<Date> values) {
            addCriterionForJDBCDate("sequence_date in", values, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sequence_date not in", values, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sequence_date between", value1, value2, "sequenceDate");
            return this;
        }

        public Criteria andSequenceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sequence_date not between", value1, value2, "sequenceDate");
            return this;
        }
    }
}