/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.PromoDetail;
import com.tokogame.domain.PromoMain;

/**
 * @author mardy jonathan
 *
 */
public interface PromoMaintenanceService {

	public List<PromoMain> getAllListPromoMain();
	
	public List<PromoDetail> getPromoDetail(PromoDetail promoDetail);
	
	public void insertPromoMain(PromoMain promoMain);
	
	public void insertPromoDetail(List<PromoDetail> detail);
	
	public void deletePromoMain(int pkPromoMain);
	
	public void deletePromoDetail(int pkPromoMain);
	
	public List<HashMap> getAllListPromoMainHelper(HashMap<String,Object> map);
	
	public List<PromoMain> getCriteriaListPromoMain(PromoMain promoMain);
	
	public void updatePromoMain(PromoMain promoMain);
	
}
