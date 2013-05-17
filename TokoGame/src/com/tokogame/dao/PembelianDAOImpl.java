package com.tokogame.dao;

import com.tokogame.domain.Pembelian;
import com.tokogame.domain.PembelianExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PembelianDAOImpl extends SqlMapClientDaoSupport implements PembelianDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public PembelianDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int countByExample(PembelianExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("pembelian.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int deleteByExample(PembelianExample example) {
        int rows = getSqlMapClientTemplate().delete("pembelian.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int deleteByPrimaryKey(Integer pkPembelian) {
        Pembelian key = new Pembelian();
        key.setPkPembelian(pkPembelian);
        int rows = getSqlMapClientTemplate().delete("pembelian.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void insert(Pembelian record) {
        getSqlMapClientTemplate().insert("pembelian.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void insertSelective(Pembelian record) {
        getSqlMapClientTemplate().insert("pembelian.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    @SuppressWarnings("unchecked")
    public List<Pembelian> selectByExample(PembelianExample example) {
        List<Pembelian> list = getSqlMapClientTemplate().queryForList("pembelian.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public Pembelian selectByPrimaryKey(Integer pkPembelian) {
        Pembelian key = new Pembelian();
        key.setPkPembelian(pkPembelian);
        Pembelian record = (Pembelian) getSqlMapClientTemplate().queryForObject("pembelian.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int updateByExampleSelective(Pembelian record, PembelianExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("pembelian.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int updateByExample(Pembelian record, PembelianExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("pembelian.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int updateByPrimaryKeySelective(Pembelian record) {
        int rows = getSqlMapClientTemplate().update("pembelian.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public int updateByPrimaryKey(Pembelian record) {
        int rows = getSqlMapClientTemplate().update("pembelian.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    private static class UpdateByExampleParms extends PembelianExample {
        private Object record;

        public UpdateByExampleParms(Object record, PembelianExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}