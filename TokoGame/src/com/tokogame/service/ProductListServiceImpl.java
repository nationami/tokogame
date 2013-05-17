/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.action.ProductListActionBean;
import com.tokogame.dao.ItemDAO;
import com.tokogame.dao.ItemHelperDAO;
import com.tokogame.dao.KategoriDAO;
import com.tokogame.dao.KoleksiDAO;
import com.tokogame.dao.OpnameDAO;
import com.tokogame.domain.Item;
import com.tokogame.domain.ItemExample;
import com.tokogame.domain.Kategori;
import com.tokogame.domain.KategoriExample;
import com.tokogame.domain.Koleksi;
import com.tokogame.domain.KoleksiExample;
import com.tokogame.domain.Opname;
import com.tokogame.domain.OpnameExample;

/**
 * @author mardy jonathan
 *
 */
@Service("productListService")
public class ProductListServiceImpl implements ProductListService{

	@Autowired
	private KoleksiDAO koleksiDAO;
	
	@Autowired
	private KategoriDAO kategoriDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private ItemHelperDAO itemHelperDAO;
	
	@Autowired
	private OpnameDAO opnameDAO;
	
	@Override
	public List<Koleksi> getKoleksiList() {
		// TODO Auto-generated method stub
		KoleksiExample koleksiExample = new KoleksiExample();
		KoleksiExample.Criteria criteria = koleksiExample.createCriteria();
		koleksiExample.setOrderByClause("koleksi_name asc");
		return koleksiDAO.selectByExample(koleksiExample);
	}

	@Override
	public List<Kategori> getKategoriList() {
		// TODO Auto-generated method stub
		KategoriExample kategoriExample = new KategoriExample();
		KategoriExample.Criteria criteria = kategoriExample.createCriteria();
		kategoriExample.setOrderByClause("kategori_name asc");
		return kategoriDAO.selectByExample(kategoriExample);
	}

	@Override
	public List<Item> getItemList(Item item, String sorting) {
		// TODO Auto-generated method stub
		ItemExample itemExample = new ItemExample();
		ItemExample.Criteria criteria = itemExample.createCriteria();
		if(item!=null){
			if(item.getFkKoleksi()!=null && item.getFkKoleksi()!=0){
				criteria.andFkKoleksiEqualTo(item.getFkKoleksi());
			}
			if(item.getFkKategori()!=null && item.getFkKategori()!=0){
				criteria.andFkKategoriEqualTo(item.getFkKategori());
			}
			if(item.getItemName()!=null && !("".equals(item.getItemName()))){
				criteria.andItemNameLike("%"+item.getItemName()+"%");
			}
		}		
		itemExample.setOrderByClause(sorting+"item_name asc");
		return itemDAO.selectByExample(itemExample);
	}

}
