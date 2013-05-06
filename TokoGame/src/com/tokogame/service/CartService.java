/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.Item;
import com.tokogame.domain.User;

/**
 * @author mardy jonathan
 *
 */
public interface CartService {

	public void userInsert(User user);
	
	public void belanjaInsert(Belanja belanja);
	
	public void detailBelanjaInsert(BelanjaDetail detail);
	
	public void batchBelanjaDetail(int pkBelanja, List<Item> listItem);
	
	public String generateKodeBelanja(String format);
}
