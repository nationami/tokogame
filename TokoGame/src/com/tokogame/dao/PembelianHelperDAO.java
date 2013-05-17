/**
 * 
 */
package com.tokogame.dao;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.Item;
import com.tokogame.domain.PembelianDetail;

/**
 * @author mardy jonathan
 *
 */
public interface PembelianHelperDAO {
	
	public void batchBelanjaDetail(List<PembelianDetail>listPembelianDetail, String process);

	public void insertListPembelianDetail(List<PembelianDetail> listPembelianDetail);
	
	public List<HashMap> getListPembelian(HashMap<String,Object> map);
	
	public void updateMinusQtyItem(HashMap<String,Object> map);
	
	public void updatePlusQtyItem(HashMap<String,Object> map);
	
	public void deleteDetailPembelian(HashMap<String,Object> map);
}
