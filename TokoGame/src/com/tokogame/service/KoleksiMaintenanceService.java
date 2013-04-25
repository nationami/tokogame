/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tokogame.domain.Koleksi;

/**
 * @author mardy jonathan
 *
 */
public interface KoleksiMaintenanceService {
	
	public List<Koleksi> getKoleksiList(Koleksi koleksi);
	
	public void insertKoleksi(Koleksi koleksi);
	
	public void updateKoleksi(Koleksi koleksi);

	public void deleteKoleksi(Koleksi koleksi);
}
