/**
 * 
 */
package com.tokogame.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tokogame.domain.PromoDetail;
import com.tokogame.domain.PromoMain;

/**
 * @author mardy jonathan
 *
 */
public class PromoHelperDAOImpl extends SqlMapClientDaoSupport implements PromoHelperDAO{

	@Override
	public void insertListPromoDetail(List<PromoDetail> listPromoDetail) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("promo_helper.insertListPromo", listPromoDetail);
	}

	@Override
	public List<HashMap> getListPromoMain(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		List<HashMap> list = getSqlMapClientTemplate().queryForList("promo_helper.selectPromo", map);
        return list;
	}

	
	
}
