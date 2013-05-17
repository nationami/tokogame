/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.Penjualan;
import com.tokogame.domain.Retur;

/**
 * @author mardy jonathan
 *
 */
public interface PembayaranService {

	
	public List<Belanja> getAllDaftarBelanja();
	
	public List<HashMap> getAllDaftarBelanjaMap(HashMap<String,Object> criteria);
	
	public void insertRetur(Retur retur);
	
	public void updateBelanja(Belanja belanja);
	
	public void updateDetailBelanja(BelanjaDetail detail);
	
	public void deleteRetur(Retur retur);
	
	public List<Retur> getReturByPkDetail(int pkDetail);
	
	public void updateRetur(Retur retur);
	
	public void insertPenjualan(Penjualan penjualan);
}
