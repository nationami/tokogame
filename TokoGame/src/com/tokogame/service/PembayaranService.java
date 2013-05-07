/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.Belanja;

/**
 * @author mardy jonathan
 *
 */
public interface PembayaranService {

	
	public List<Belanja> getAllDaftarBelanja();
	
	public List<HashMap> getAllDaftarBelanjaMap(HashMap<String,Object> criteria);
}
