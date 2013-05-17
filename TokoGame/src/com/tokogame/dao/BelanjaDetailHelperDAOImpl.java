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
public class BelanjaDetailHelperDAOImpl extends SqlMapClientDaoSupport implements BelanjaDetailHelperDAO{

	@Override
	public List<HashMap> selectDetailBelanja(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap> list = getSqlMapClientTemplate().queryForList("belanja_detail_helper.selectDetailBelanja", param);
        return list;
	}

	@Override
	public List<HashMap> selectDetailBelanjaRetur(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap> list = getSqlMapClientTemplate().queryForList("belanja_detail_helper.selectDetailBelanjaRetur", param);
        return list;
	}

}
