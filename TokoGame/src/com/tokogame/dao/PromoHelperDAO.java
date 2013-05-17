/**
 * 
 */
package com.tokogame.dao;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.PromoDetail;


/**
 * @author mardy jonathan
 *
 */
public interface PromoHelperDAO {
	
	public void insertListPromoDetail(List<PromoDetail> listPromoDetail);
	
	public List<HashMap> getListPromoMain(HashMap<String,Object> map);
}
