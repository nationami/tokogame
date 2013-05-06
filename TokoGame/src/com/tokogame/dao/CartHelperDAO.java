/**
 * 
 */
package com.tokogame.dao;

import java.util.List;

import com.tokogame.domain.Item;

/**
 * @author mardy jonathan
 *
 */
public interface CartHelperDAO {

	public void batchBelanjaDetail(int pkBelanja, List<Item>listItem);
	
}
