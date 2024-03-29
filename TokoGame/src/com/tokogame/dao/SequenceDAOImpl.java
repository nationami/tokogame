package com.tokogame.dao;

import com.tokogame.domain.Sequence;
import com.tokogame.domain.SequenceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SequenceDAOImpl extends SqlMapClientDaoSupport implements SequenceDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public SequenceDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int countByExample(SequenceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("sequence.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int deleteByExample(SequenceExample example) {
        int rows = getSqlMapClientTemplate().delete("sequence.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int deleteByPrimaryKey(Integer sequenceNo) {
        Sequence key = new Sequence();
        key.setSequenceNo(sequenceNo);
        int rows = getSqlMapClientTemplate().delete("sequence.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void insert(Sequence record) {
        getSqlMapClientTemplate().insert("sequence.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void insertSelective(Sequence record) {
        getSqlMapClientTemplate().insert("sequence.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    @SuppressWarnings("unchecked")
    public List<Sequence> selectByExample(SequenceExample example) {
        List<Sequence> list = getSqlMapClientTemplate().queryForList("sequence.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public Sequence selectByPrimaryKey(Integer sequenceNo) {
        Sequence key = new Sequence();
        key.setSequenceNo(sequenceNo);
        Sequence record = (Sequence) getSqlMapClientTemplate().queryForObject("sequence.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int updateByExampleSelective(Sequence record, SequenceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("sequence.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int updateByExample(Sequence record, SequenceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("sequence.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int updateByPrimaryKeySelective(Sequence record) {
        int rows = getSqlMapClientTemplate().update("sequence.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public int updateByPrimaryKey(Sequence record) {
        int rows = getSqlMapClientTemplate().update("sequence.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table sequence
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    private static class UpdateByExampleParms extends SequenceExample {
        private Object record;

        public UpdateByExampleParms(Object record, SequenceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}