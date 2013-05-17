/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.KonfigurasiDAO;
import com.tokogame.domain.Konfigurasi;
import com.tokogame.domain.KonfigurasiExample;

/**
 * @author mardy jonathan
 *
 */
@Service("konfigurasiService")
public class KonfigurasiServiceImpl implements KonfigurasiService{

	@Autowired
	private KonfigurasiDAO konfigurasisDAO;
	
	@Override
	public void insertKonfigurasi(Konfigurasi konfigurasi) {
		// TODO Auto-generated method stub
		konfigurasisDAO.insert(konfigurasi);
	}

	@Override
	public Konfigurasi getKonfigurasi() {
		// TODO Auto-generated method stub
		KonfigurasiExample example = new KonfigurasiExample();
		KonfigurasiExample.Criteria criteria = example.createCriteria();
		List<Konfigurasi> list = konfigurasisDAO.selectByExample(example);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
		
	}

	@Override
	public void updateKonfigurasi(Konfigurasi konfigurasi) {
		// TODO Auto-generated method stub
		konfigurasisDAO.updateByPrimaryKeySelective(konfigurasi);
	}

}
