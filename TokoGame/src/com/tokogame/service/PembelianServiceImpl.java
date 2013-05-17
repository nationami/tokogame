/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.PembelianDAO;
import com.tokogame.dao.PembelianDetailDAO;
import com.tokogame.dao.PembelianHelperDAO;
import com.tokogame.domain.Pembelian;
import com.tokogame.domain.PembelianDetail;
import com.tokogame.domain.PembelianDetailExample;

/**
 * @author mardy jonathan
 *
 */
@Service("pembelianService")
public class PembelianServiceImpl implements PembelianService{

	@Autowired
	private PembelianDAO pembelianDAO;
		
	@Autowired
	private PembelianDetailDAO pembelianDetailDAO;
	
	@Autowired
	private PembelianHelperDAO pembelianHelperDAO;
	
	@Override
	public List<HashMap> getListPembelian(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return pembelianHelperDAO.getListPembelian(map);
	}

	@Override
	public void insertPembelian(Pembelian pembelian) {
		// TODO Auto-generated method stub
		pembelianDAO.insert(pembelian);
	}

	@Override
	public void prosesPembelianDetail(
			List<PembelianDetail> listPembelianDetail, String process) {
		// TODO Auto-generated method stub
		pembelianHelperDAO.batchBelanjaDetail(listPembelianDetail, process);
		
	}

	@Override
	public Pembelian getPembelianByPK(int pkPembelian) {
		// TODO Auto-generated method stub
		return pembelianDAO.selectByPrimaryKey(pkPembelian);
	}

	@Override
	public List<PembelianDetail> getListPembelianDetail(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		PembelianDetailExample example = new PembelianDetailExample();
		PembelianDetailExample.Criteria criteria = example.createCriteria();
		if(map.get("fkPembelian")!=null){
			criteria.andFkPembelianEqualTo((Integer) map.get("fkPembelian"));
		}
		return pembelianDetailDAO.selectByExample(example);
	}

	@Override
	public void updatePembelian(Pembelian pembelian) {
		// TODO Auto-generated method stub
		pembelianDAO.updateByPrimaryKeySelective(pembelian);
	}

}
