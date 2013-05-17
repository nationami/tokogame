package com.tokogame.dao;

import com.tokogame.domain.Retur;
import com.tokogame.domain.ReturExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ReturDAOImpl extends SqlMapClientDaoSupport implements ReturDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public ReturDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int countByExample(ReturExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("retur.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int deleteByExample(ReturExample example) {
        int rows = getSqlMapClientTemplate().delete("retur.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int deleteByPrimaryKey(Integer pkRetur) {
        Retur key = new Retur();
        key.setPkRetur(pkRetur);
        int rows = getSqlMapClientTemplate().delete("retur.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void insert(Retur record) {
        getSqlMapClientTemplate().insert("retur.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void insertSelective(Retur record) {
        getSqlMapClientTemplate().insert("retur.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    @SuppressWarnings("unchecked")
    public List<Retur> selectByExample(ReturExample example) {
        List<Retur> list = getSqlMapClientTemplate().queryForList("retur.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Retur selectByPrimaryKey(Integer pkRetur) {
        Retur key = new Retur();
        key.setPkRetur(pkRetur);
        Retur record = (Retur) getSqlMapClientTemplate().queryForObject("retur.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int updateByExampleSelective(Retur record, ReturExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("retur.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int updateByExample(Retur record, ReturExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("retur.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int updateByPrimaryKeySelective(Retur record) {
        int rows = getSqlMapClientTemplate().update("retur.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public int updateByPrimaryKey(Retur record) {
        int rows = getSqlMapClientTemplate().update("retur.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table retur
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private static class UpdateByExampleParms extends ReturExample {
        private Object record;

        public UpdateByExampleParms(Object record, ReturExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}