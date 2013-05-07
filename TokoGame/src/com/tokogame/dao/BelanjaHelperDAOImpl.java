/**
 * 
 */
package com.tokogame.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * @author mardy jonathan
 *
 */
public class BelanjaHelperDAOImpl extends SqlMapClientDaoSupport implements BelanjaHelperDAO{

	@Override
	public List<HashMap> selectBelanja(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap> list = getSqlMapClientTemplate().queryForList("belanja_helper.selectBelanja", param);
		return list;
	}
	

}
