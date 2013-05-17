/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.Pembelian;
import com.tokogame.domain.PembelianDetail;

/**
 * @author mardy jonathan
 *
 */
public interface PembelianService {

	public List<HashMap> getListPembelian(HashMap<String, Object> map);
	
	public void insertPembelian(Pembelian pembelian);
	
	public void prosesPembelianDetail(List<PembelianDetail> listPembelianDetail,String process);
	
	public Pembelian getPembelianByPK(int pkPembelian);
	
	public List<PembelianDetail> getListPembelianDetail(HashMap<String,Object> map);
	
	public void updatePembelian(Pembelian pembelian);
}

