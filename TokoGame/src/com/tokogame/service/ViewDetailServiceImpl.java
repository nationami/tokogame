/**
 * 
 */
package com.tokogame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.ItemDAO;
import com.tokogame.domain.Item;

/**
 * @author mardy jonathan
 *
 */
@Service("viewDetailService")
public class ViewDetailServiceImpl implements ViewDetailService{

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public Item getItemByPK(int pkItem) {
		// TODO Auto-generated method stub
		return itemDAO.selectByPrimaryKey(pkItem);
	}

}
