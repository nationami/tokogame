/**
 * 
 */
package com.tokogame.service;

import com.tokogame.domain.Konfigurasi;

/**
 * @author mardy jonathan
 *
 */
public interface KonfigurasiService {

	public void insertKonfigurasi(Konfigurasi konfigurasi);
	
	public void updateKonfigurasi(Konfigurasi konfigurasi);
	
	public Konfigurasi getKonfigurasi();
}
