/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.BelanjaDAO;
import com.tokogame.dao.BelanjaHelperDAO;
import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaExample;

/**
 * @author mardy jonathan
 *
 */
@Service("pembayaranService")
public class PembayaranServiceImpl implements PembayaranService{

	@Autowired
	private BelanjaDAO belanjaDAO;
	
	@Autowired
	private BelanjaHelperDAO belanjaHelperDAO;
	
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

	

}
