/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.BelanjaDAO;
import com.tokogame.dao.BelanjaDetailDAO;
import com.tokogame.dao.BelanjaHelperDAO;
import com.tokogame.dao.PenjualanDAO;
import com.tokogame.dao.ReturDAO;
import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.BelanjaExample;
import com.tokogame.domain.Penjualan;
import com.tokogame.domain.Retur;
import com.tokogame.domain.ReturExample;

/**
 * @author mardy jonathan
 *
 */
@Service("pembayaranService")
public class PembayaranServiceImpl implements PembayaranService{

	@Autowired
	private BelanjaDAO belanjaDAO;
	
	@Autowired
	private BelanjaDetailDAO belanjaDetailDAO;
	
	@Autowired
	private BelanjaHelperDAO belanjaHelperDAO;
	
	@Autowired
	private ReturDAO returDAO;
	
	@Autowired
	private PenjualanDAO penjualanDAO;
	
	@Override
	public List<Belanja> getAllDaftarBelanja() {
		// TODO Auto-generated method stub
		BelanjaExample example = new BelanjaExample();
		BelanjaExample.Criteria criteria = example.createCriteria();
		return belanjaDAO.selectByExample(example);
	}

	@Override
	public List<HashMap> getAllDaftarBelanjaMap(HashMap<String, Object> criteria) {
		// TODO Auto-generated method stub
		return belanjaHelperDAO.selectBelanja(criteria);
	}

	@Override
	public void insertRetur(Retur retur) {
		// TODO Auto-generated method stub
		returDAO.insert(retur);
	}

	@Override
	public void updateBelanja(Belanja belanja) {
		// TODO Auto-generated method stub
		belanjaDAO.updateByPrimaryKeySelective(belanja);
	}

	@Override
	public void updateDetailBelanja(BelanjaDetail detail) {
		// TODO Auto-generated method stub
		belanjaDetailDAO.updateByPrimaryKeySelective(detail);
	}

	@Override
	public void deleteRetur(Retur retur) {
		// TODO Auto-generated method stub
		ReturExample example = new ReturExample();
		ReturExample.Criteria criteria = example.createCriteria();
		if(retur!=null && retur.getFkBelanjaDetail()!=null){
			criteria.andFkBelanjaDetailEqualTo(retur.getFkBelanjaDetail());
			returDAO.deleteByExample(example);
		}
	}

	@Override
	public List<Retur> getReturByPkDetail(int pkDetail) {
		// TODO Auto-generated method stub
		ReturExample example = new ReturExample();
		ReturExample.Criteria criteria = example.createCriteria();
		criteria.andFkBelanjaDetailEqualTo(pkDetail);
		return returDAO.selectByExample(example);
	}

	@Override
	public void updateRetur(Retur retur) {
		// TODO Auto-generated method stub
		ReturExample example = new ReturExample();
		ReturExample.Criteria criteria = example.createCriteria();
		criteria.andFkBelanjaDetailEqualTo(retur.getFkBelanjaDetail());
		returDAO.updateByExampleSelective(retur, example);
	}

	@Override
	public void insertPenjualan(Penjualan penjualan) {
		// TODO Auto-generated method stub
		penjualanDAO.insert(penjualan);
	}

	

}
