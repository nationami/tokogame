/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import com.tokogame.domain.Item;
import com.tokogame.domain.Kategori;
import com.tokogame.domain.Koleksi;
import com.tokogame.domain.Opname;

/**
 * @author mardy jonathan
 *
 */
public interface ProductListService {

	public List<Koleksi> getKoleksiList();
	
	public List<Kategori> getKategoriList();
	
	public List<Item> getItemList(Item item, String sorting);
	
}
