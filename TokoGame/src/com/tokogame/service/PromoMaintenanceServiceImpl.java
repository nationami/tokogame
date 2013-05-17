/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.PromoDetailDAO;
import com.tokogame.dao.PromoHelperDAO;
import com.tokogame.dao.PromoMainDAO;
import com.tokogame.domain.PromoDetail;
import com.tokogame.domain.PromoDetailExample;
import com.tokogame.domain.PromoMain;
import com.tokogame.domain.PromoMainExample;

/**
 * @author mardy jonathan
 *
 */
@Service("promoMaintenanceService")
public class PromoMaintenanceServiceImpl implements PromoMaintenanceService{

	@Autowired
	private PromoMainDAO promoMainDAO;

	@Autowired
	private PromoDetailDAO promoDetailDAO;
	
	@Autowired
	private PromoHelperDAO promoHelperDAO;
	
	@Override
	public List<PromoMain> getAllListPromoMain() {
		// TODO Auto-generated method stub
		PromoMainExample example = new PromoMainExample();
		PromoMainExample.Criteria criteria = example.createCriteria();
		return promoMainDAO.selectByExample(example);
	}

	@Override
	public List<PromoDetail> getPromoDetail(PromoDetail promoDetail) {
		// TODO Auto-generated method stub
		PromoDetailExample example = new PromoDetailExample();
		PromoDetailExample.Criteria criteria = example.createCriteria();
		if(promoDetail!=null){
			if(promoDetail.getFkPromoMain()!=null && promoDetail.getFkPromoMain()!=0){
				criteria.andFkPromoMainEqualTo(promoDetail.getFkPromoMain());
			}
		}
		return promoDetailDAO.selectByExample(example);
	}

	@Override
	public void insertPromoMain(PromoMain promoMain) {
		// TODO Auto-generated method stub
		promoMainDAO.insert(promoMain);
	}

	@Override
	public void insertPromoDetail(List<PromoDetail> detail) {
		// TODO Auto-generated method stub
		PromoDetailExample example = new PromoDetailExample();
		PromoDetailExample.Criteria criteria = example.createCriteria();
		criteria.andFkPromoMainEqualTo(detail.get(0).getFkPromoMain());
		promoDetailDAO.deleteByExample(example);
		
		promoHelperDAO.insertListPromoDetail(detail);
		
	}

	@Override
	public void deletePromoMain(int pkPromoMain) {
		// TODO Auto-generated method stub
		promoMainDAO.deleteByPrimaryKey(pkPromoMain);
	}

	@Override
	public void deletePromoDetail(int pkPromoMain) {
		// TODO Auto-generated method stub
		PromoDetailExample example = new PromoDetailExample();
		PromoDetailExample.Criteria criteria = example.createCriteria();
		criteria.andFkPromoMainEqualTo(pkPromoMain);
		promoDetailDAO.deleteByExample(example);
	}

	@Override
	public List<HashMap> getAllListPromoMainHelper(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		return promoHelperDAO.getListPromoMain(map);
	}

	@Override
	public List<PromoMain> getCriteriaListPromoMain(PromoMain promoMain) {
		// TODO Auto-generated method stub
		PromoMainExample example = new PromoMainExample();
		PromoMainExample.Criteria criteria = example.createCriteria();
		if(promoMain!=null){
			if(promoMain.getPkPromoMain()!=null && promoMain.getPkPromoMain()!=0){
				criteria.andPkPromoMainEqualTo(promoMain.getPkPromoMain());
			}
		}
		return promoMainDAO.selectByExample(example);
	}

	@Override
	public void updatePromoMain(PromoMain promoMain) {
		// TODO Auto-generated method stub
		promoMainDAO.updateByPrimaryKey(promoMain);
	}

}
