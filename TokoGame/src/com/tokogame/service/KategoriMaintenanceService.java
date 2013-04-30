/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tokogame.domain.Kategori;

/**
 * @author mardy jonathan
 *
 */
public interface KategoriMaintenanceService {
	
	public List<Kategori> getKategoriList(Kategori kategori);
	
	public void insertKategori(Kategori kategori);
	
	public void updateKategori(Kategori kategori);

	public void deleteKategori(Kategori kategori);
}
