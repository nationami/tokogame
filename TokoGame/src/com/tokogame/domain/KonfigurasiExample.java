package com.tokogame.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KonfigurasiExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    public KonfigurasiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    protected KonfigurasiExample(KonfigurasiExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
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
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
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

        public Criteria andPkKonfigurasiIsNull() {
            addCriterion("pk_konfigurasi is null");
            return this;
        }

        public Criteria andPkKonfigurasiIsNotNull() {
            addCriterion("pk_konfigurasi is not null");
            return this;
        }

        public Criteria andPkKonfigurasiEqualTo(Integer value) {
            addCriterion("pk_konfigurasi =", value, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiNotEqualTo(Integer value) {
            addCriterion("pk_konfigurasi <>", value, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiGreaterThan(Integer value) {
            addCriterion("pk_konfigurasi >", value, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_konfigurasi >=", value, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiLessThan(Integer value) {
            addCriterion("pk_konfigurasi <", value, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiLessThanOrEqualTo(Integer value) {
            addCriterion("pk_konfigurasi <=", value, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiIn(List<Integer> values) {
            addCriterion("pk_konfigurasi in", values, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiNotIn(List<Integer> values) {
            addCriterion("pk_konfigurasi not in", values, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiBetween(Integer value1, Integer value2) {
            addCriterion("pk_konfigurasi between", value1, value2, "pkKonfigurasi");
            return this;
        }

        public Criteria andPkKonfigurasiNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_konfigurasi not between", value1, value2, "pkKonfigurasi");
            return this;
        }

        public Criteria andNamaIsNull() {
            addCriterion("nama is null");
            return this;
        }

        public Criteria andNamaIsNotNull() {
            addCriterion("nama is not null");
            return this;
        }

        public Criteria andNamaEqualTo(String value) {
            addCriterion("nama =", value, "nama");
            return this;
        }

        public Criteria andNamaNotEqualTo(String value) {
            addCriterion("nama <>", value, "nama");
            return this;
        }

        public Criteria andNamaGreaterThan(String value) {
            addCriterion("nama >", value, "nama");
            return this;
        }

        public Criteria andNamaGreaterThanOrEqualTo(String value) {
            addCriterion("nama >=", value, "nama");
            return this;
        }

        public Criteria andNamaLessThan(String value) {
            addCriterion("nama <", value, "nama");
            return this;
        }

        public Criteria andNamaLessThanOrEqualTo(String value) {
            addCriterion("nama <=", value, "nama");
            return this;
        }

        public Criteria andNamaLike(String value) {
            addCriterion("nama like", value, "nama");
            return this;
        }

        public Criteria andNamaNotLike(String value) {
            addCriterion("nama not like", value, "nama");
            return this;
        }

        public Criteria andNamaIn(List<String> values) {
            addCriterion("nama in", values, "nama");
            return this;
        }

        public Criteria andNamaNotIn(List<String> values) {
            addCriterion("nama not in", values, "nama");
            return this;
        }

        public Criteria andNamaBetween(String value1, String value2) {
            addCriterion("nama between", value1, value2, "nama");
            return this;
        }

        public Criteria andNamaNotBetween(String value1, String value2) {
            addCriterion("nama not between", value1, value2, "nama");
            return this;
        }

        public Criteria andAlamatIsNull() {
            addCriterion("alamat is null");
            return this;
        }

        public Criteria andAlamatIsNotNull() {
            addCriterion("alamat is not null");
            return this;
        }

        public Criteria andAlamatEqualTo(String value) {
            addCriterion("alamat =", value, "alamat");
            return this;
        }

        public Criteria andAlamatNotEqualTo(String value) {
            addCriterion("alamat <>", value, "alamat");
            return this;
        }

        public Criteria andAlamatGreaterThan(String value) {
            addCriterion("alamat >", value, "alamat");
            return this;
        }

        public Criteria andAlamatGreaterThanOrEqualTo(String value) {
            addCriterion("alamat >=", value, "alamat");
            return this;
        }

        public Criteria andAlamatLessThan(String value) {
            addCriterion("alamat <", value, "alamat");
            return this;
        }

        public Criteria andAlamatLessThanOrEqualTo(String value) {
            addCriterion("alamat <=", value, "alamat");
            return this;
        }

        public Criteria andAlamatLike(String value) {
            addCriterion("alamat like", value, "alamat");
            return this;
        }

        public Criteria andAlamatNotLike(String value) {
            addCriterion("alamat not like", value, "alamat");
            return this;
        }

        public Criteria andAlamatIn(List<String> values) {
            addCriterion("alamat in", values, "alamat");
            return this;
        }

        public Criteria andAlamatNotIn(List<String> values) {
            addCriterion("alamat not in", values, "alamat");
            return this;
        }

        public Criteria andAlamatBetween(String value1, String value2) {
            addCriterion("alamat between", value1, value2, "alamat");
            return this;
        }

        public Criteria andAlamatNotBetween(String value1, String value2) {
            addCriterion("alamat not between", value1, value2, "alamat");
            return this;
        }

        public Criteria andTeleponIsNull() {
            addCriterion("telepon is null");
            return this;
        }

        public Criteria andTeleponIsNotNull() {
            addCriterion("telepon is not null");
            return this;
        }

        public Criteria andTeleponEqualTo(String value) {
            addCriterion("telepon =", value, "telepon");
            return this;
        }

        public Criteria andTeleponNotEqualTo(String value) {
            addCriterion("telepon <>", value, "telepon");
            return this;
        }

        public Criteria andTeleponGreaterThan(String value) {
            addCriterion("telepon >", value, "telepon");
            return this;
        }

        public Criteria andTeleponGreaterThanOrEqualTo(String value) {
            addCriterion("telepon >=", value, "telepon");
            return this;
        }

        public Criteria andTeleponLessThan(String value) {
            addCriterion("telepon <", value, "telepon");
            return this;
        }

        public Criteria andTeleponLessThanOrEqualTo(String value) {
            addCriterion("telepon <=", value, "telepon");
            return this;
        }

        public Criteria andTeleponLike(String value) {
            addCriterion("telepon like", value, "telepon");
            return this;
        }

        public Criteria andTeleponNotLike(String value) {
            addCriterion("telepon not like", value, "telepon");
            return this;
        }

        public Criteria andTeleponIn(List<String> values) {
            addCriterion("telepon in", values, "telepon");
            return this;
        }

        public Criteria andTeleponNotIn(List<String> values) {
            addCriterion("telepon not in", values, "telepon");
            return this;
        }

        public Criteria andTeleponBetween(String value1, String value2) {
            addCriterion("telepon between", value1, value2, "telepon");
            return this;
        }

        public Criteria andTeleponNotBetween(String value1, String value2) {
            addCriterion("telepon not between", value1, value2, "telepon");
            return this;
        }

        public Criteria andHeaderIsNull() {
            addCriterion("header is null");
            return this;
        }

        public Criteria andHeaderIsNotNull() {
            addCriterion("header is not null");
            return this;
        }

        public Criteria andHeaderEqualTo(String value) {
            addCriterion("header =", value, "header");
            return this;
        }

        public Criteria andHeaderNotEqualTo(String value) {
            addCriterion("header <>", value, "header");
            return this;
        }

        public Criteria andHeaderGreaterThan(String value) {
            addCriterion("header >", value, "header");
            return this;
        }

        public Criteria andHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("header >=", value, "header");
            return this;
        }

        public Criteria andHeaderLessThan(String value) {
            addCriterion("header <", value, "header");
            return this;
        }

        public Criteria andHeaderLessThanOrEqualTo(String value) {
            addCriterion("header <=", value, "header");
            return this;
        }

        public Criteria andHeaderLike(String value) {
            addCriterion("header like", value, "header");
            return this;
        }

        public Criteria andHeaderNotLike(String value) {
            addCriterion("header not like", value, "header");
            return this;
        }

        public Criteria andHeaderIn(List<String> values) {
            addCriterion("header in", values, "header");
            return this;
        }

        public Criteria andHeaderNotIn(List<String> values) {
            addCriterion("header not in", values, "header");
            return this;
        }

        public Criteria andHeaderBetween(String value1, String value2) {
            addCriterion("header between", value1, value2, "header");
            return this;
        }

        public Criteria andHeaderNotBetween(String value1, String value2) {
            addCriterion("header not between", value1, value2, "header");
            return this;
        }

        public Criteria andBannerNameIsNull() {
            addCriterion("banner_name is null");
            return this;
        }

        public Criteria andBannerNameIsNotNull() {
            addCriterion("banner_name is not null");
            return this;
        }

        public Criteria andBannerNameEqualTo(String value) {
            addCriterion("banner_name =", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameNotEqualTo(String value) {
            addCriterion("banner_name <>", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameGreaterThan(String value) {
            addCriterion("banner_name >", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameGreaterThanOrEqualTo(String value) {
            addCriterion("banner_name >=", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameLessThan(String value) {
            addCriterion("banner_name <", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameLessThanOrEqualTo(String value) {
            addCriterion("banner_name <=", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameLike(String value) {
            addCriterion("banner_name like", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameNotLike(String value) {
            addCriterion("banner_name not like", value, "bannerName");
            return this;
        }

        public Criteria andBannerNameIn(List<String> values) {
            addCriterion("banner_name in", values, "bannerName");
            return this;
        }

        public Criteria andBannerNameNotIn(List<String> values) {
            addCriterion("banner_name not in", values, "bannerName");
            return this;
        }

        public Criteria andBannerNameBetween(String value1, String value2) {
            addCriterion("banner_name between", value1, value2, "bannerName");
            return this;
        }

        public Criteria andBannerNameNotBetween(String value1, String value2) {
            addCriterion("banner_name not between", value1, value2, "bannerName");
            return this;
        }

        public Criteria andBannerPathIsNull() {
            addCriterion("banner_path is null");
            return this;
        }

        public Criteria andBannerPathIsNotNull() {
            addCriterion("banner_path is not null");
            return this;
        }

        public Criteria andBannerPathEqualTo(String value) {
            addCriterion("banner_path =", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathNotEqualTo(String value) {
            addCriterion("banner_path <>", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathGreaterThan(String value) {
            addCriterion("banner_path >", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathGreaterThanOrEqualTo(String value) {
            addCriterion("banner_path >=", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathLessThan(String value) {
            addCriterion("banner_path <", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathLessThanOrEqualTo(String value) {
            addCriterion("banner_path <=", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathLike(String value) {
            addCriterion("banner_path like", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathNotLike(String value) {
            addCriterion("banner_path not like", value, "bannerPath");
            return this;
        }

        public Criteria andBannerPathIn(List<String> values) {
            addCriterion("banner_path in", values, "bannerPath");
            return this;
        }

        public Criteria andBannerPathNotIn(List<String> values) {
            addCriterion("banner_path not in", values, "bannerPath");
            return this;
        }

        public Criteria andBannerPathBetween(String value1, String value2) {
            addCriterion("banner_path between", value1, value2, "bannerPath");
            return this;
        }

        public Criteria andBannerPathNotBetween(String value1, String value2) {
            addCriterion("banner_path not between", value1, value2, "bannerPath");
            return this;
        }

        public Criteria andKataHiasanIsNull() {
            addCriterion("kata_hiasan is null");
            return this;
        }

        public Criteria andKataHiasanIsNotNull() {
            addCriterion("kata_hiasan is not null");
            return this;
        }

        public Criteria andKataHiasanEqualTo(String value) {
            addCriterion("kata_hiasan =", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanNotEqualTo(String value) {
            addCriterion("kata_hiasan <>", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanGreaterThan(String value) {
            addCriterion("kata_hiasan >", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanGreaterThanOrEqualTo(String value) {
            addCriterion("kata_hiasan >=", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanLessThan(String value) {
            addCriterion("kata_hiasan <", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanLessThanOrEqualTo(String value) {
            addCriterion("kata_hiasan <=", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanLike(String value) {
            addCriterion("kata_hiasan like", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanNotLike(String value) {
            addCriterion("kata_hiasan not like", value, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanIn(List<String> values) {
            addCriterion("kata_hiasan in", values, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanNotIn(List<String> values) {
            addCriterion("kata_hiasan not in", values, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanBetween(String value1, String value2) {
            addCriterion("kata_hiasan between", value1, value2, "kataHiasan");
            return this;
        }

        public Criteria andKataHiasanNotBetween(String value1, String value2) {
            addCriterion("kata_hiasan not between", value1, value2, "kataHiasan");
            return this;
        }
    }
}