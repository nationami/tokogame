/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.KoleksiDAO;
import com.tokogame.domain.Koleksi;
import com.tokogame.domain.KoleksiExample;

/**
 * @author mardy jonathan
 *
 */
@Service("productListService")
public class ProductListServiceImpl implements ProductListService{

	@Autowired
	private KoleksiDAO koleksiDAO;
	
	@Override
	public List<Koleksi> getAllKoleksiList() {
		// TODO Auto-generated method stub
		KoleksiExample koleksiExample = new KoleksiExample();
		return koleksiDAO.selectByExample(koleksiExample);
	}

}
