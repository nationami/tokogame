/**
 * 
 */
package com.tokogame.dao;

import java.util.List;

import com.tokogame.domain.Item;
import com.tokogame.domain.ItemExample;

/**
 * @author mardy jonathan
 *
 */
public interface ItemHelperDAO {

	List<Item> selectByExample(ItemExample example, int page);
}
