/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.KategoriDAO;
import com.tokogame.domain.Kategori;
import com.tokogame.domain.KategoriExample;

/**
 * @author mardy jonathan
 *
 */
@Service("kategoriMaintenanceService")
public class KategoriMaintenanceServiceImpl implements KategoriMaintenanceService{

	@Autowired
	private KategoriDAO kategoriDAO;
	
	@Override
	public List<Kategori> getKategoriList(Kategori kategori) {
		// TODO Auto-generated method stub
		KategoriExample kategoriExample = new KategoriExample();
		KategoriExample.Criteria criteria = kategoriExample.createCriteria();
		if(kategori.getPkKategori()!=null){
			criteria.andPkKategoriEqualTo(kategori.getPkKategori());
		}
		if(kategori.getKategoriName()!=null){
			criteria.andKategoriNameEqualTo(kategori.getKategoriName());
		}
		kategoriExample.setOrderByClause("kategori_name asc");
		return kategoriDAO.selectByExample(kategoriExample);
	}

	@Override
	public void insertKategori(Kategori kategori) {
		// TODO Auto-generated method stub
		kategoriDAO.insert(kategori);
	}

	@Override
	public void updateKategori(Kategori kategori) {
		// TODO Auto-generated method stub
		kategoriDAO.updateByPrimaryKey(kategori);
	}

	@Override
	public void deleteKategori(Kategori kategori) {
		// TODO Auto-generated method stub
		int pkKategori = kategori.getPkKategori();
		kategoriDAO.deleteByPrimaryKey(pkKategori);
	}
	
	

	
}
