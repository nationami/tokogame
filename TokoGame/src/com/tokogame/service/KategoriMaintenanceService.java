/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tokogame.domain.Kategori;
import com.tokogame.domain.Koleksi;
import com.tokogame.domain.KoleksiRelation;

/**
 * @author mardy jonathan
 *
 */
public interface KategoriMaintenanceService {
	
	public List<Kategori> getKategoriList(Kategori kategori);
	
	public List<Koleksi> getKoleksiList(Koleksi koleksi);
	
	public void insertKategori(Kategori kategori);
	
	public void updateKategori(Kategori kategori);

	public void deleteKategori(Kategori kategori);
	
	public void insertKoleksiRelation(KoleksiRelation koleksiRelation);
	
	public void deleteKoleksiRelation(Integer fkKategori);
	
	public int countKategoriName(String kategoriName);
	
	public List<KoleksiRelation> selectSelectiveKoleksiRelation(Integer fkKategori);
}
