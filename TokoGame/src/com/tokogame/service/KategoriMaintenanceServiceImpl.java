/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.KategoriDAO;
import com.tokogame.dao.KoleksiDAO;
import com.tokogame.dao.KoleksiRelationDAO;
import com.tokogame.domain.Kategori;
import com.tokogame.domain.KategoriExample;
import com.tokogame.domain.Koleksi;
import com.tokogame.domain.KoleksiExample;
import com.tokogame.domain.KoleksiRelation;
import com.tokogame.domain.KoleksiRelationExample;

/**
 * @author mardy jonathan
 *
 */
@Service("kategoriMaintenanceService")
public class KategoriMaintenanceServiceImpl implements KategoriMaintenanceService{

	@Autowired
	private KategoriDAO kategoriDAO;
	
	@Autowired
	private KoleksiDAO koleksiDAO;
	
	@Autowired
	private KoleksiRelationDAO koleksiRelationDAO;
	
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

	@Override
	public List<Koleksi> getKoleksiList(Koleksi koleksi) {
		// TODO Auto-generated method stub
		KoleksiExample koleksiExample = new KoleksiExample();
		KoleksiExample.Criteria criteria = koleksiExample.createCriteria();
		if(koleksi.getPkKoleksi()!=null){
			criteria.andPkKoleksiEqualTo(koleksi.getPkKoleksi());
		}
		if(koleksi.getKoleksiName()!=null){
			criteria.andKoleksiNameEqualTo(koleksi.getKoleksiName());
		}
		koleksiExample.setOrderByClause("koleksi_name asc");
		return koleksiDAO.selectByExample(koleksiExample);
	}

	@Override
	public void insertKoleksiRelation(KoleksiRelation koleksiRelation) {
		// TODO Auto-generated method stub
		koleksiRelationDAO.insert(koleksiRelation);
	}

	@Override
	public void deleteKoleksiRelation(Integer fkKategori) {
		// TODO Auto-generated method stub
		KoleksiRelationExample koleksiRelationExample = new KoleksiRelationExample();
		KoleksiRelationExample.Criteria criteria = koleksiRelationExample.createCriteria();
		criteria.andFkKategoriEqualTo(fkKategori);
		koleksiRelationDAO.deleteByExample(koleksiRelationExample);
	}

	public KoleksiRelationDAO getKoleksiRelationDAO() {
		return koleksiRelationDAO;
	}

	public void setKoleksiRelationDAO(KoleksiRelationDAO koleksiRelationDAO) {
		this.koleksiRelationDAO = koleksiRelationDAO;
	}

	@Override
	public int countKategoriName(String kategoriName) {
		// TODO Auto-generated method stub
		KategoriExample kategoriExample = new KategoriExample();
		KategoriExample.Criteria criteria = kategoriExample.createCriteria();
		if (kategoriName!=null){
			criteria.andKategoriNameEqualTo(kategoriName);
		}
		return kategoriDAO.countByExample(kategoriExample);
	}

	@Override
	public List<KoleksiRelation> selectSelectiveKoleksiRelation(
			Integer fkKategori) {
		// TODO Auto-generated method stub
		KoleksiRelationExample koleksiRelationExample = new KoleksiRelationExample();
		KoleksiRelationExample.Criteria criteria = koleksiRelationExample.createCriteria();
		criteria.andFkKategoriEqualTo(fkKategori);
		//koleksiRelationExample.setOrderByClause("kategori_name asc");
		return koleksiRelationDAO.selectByExample(koleksiRelationExample);
	}	
}
