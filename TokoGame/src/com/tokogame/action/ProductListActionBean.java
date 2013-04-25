/**
 * 
 */
package com.tokogame.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Item;
import com.tokogame.domain.Kategori;
import com.tokogame.domain.Koleksi;
import com.tokogame.service.ProductListService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/productList")
public class ProductListActionBean extends BaseActionBean{

	@SpringBean
	private ProductListService productListService;
	
	
	public List<Koleksi> listKoleksi;
	public List<Kategori> listKategori;
	public List<Item> listItem;
	public int size;
	public int kategoriId;
	public int koleksiId;
	public int itemId;
	public String valueSearch;
	public String criteria;
	public Item item;
	
	
	//function to create offset position paging of the table
	private void makeOffset(String param) {
		try {
			this.setOffset(Integer.parseInt(this.context.getRequest()
					.getParameter(param)));
		} catch (Exception e) {
		}
	} 
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		//for show the menu koleksi
		listKoleksi = productListService.getKoleksiList();
		//for show the menu kategori
		listKategori = productListService.getKategoriList();
		
		return this.search();
	}
	
	public Resolution search(){
		String sorting = "";
		
		//show item list with paging
		makeOffset("product_list.offset");
		item = new Item();
		item.setFkKoleksi(koleksiId);
		item.setFkKategori(kategoriId);
		item.setItemName(valueSearch);
		
		if(criteria!=null){
			if("new".equals(criteria)){
				sorting = "updated_date desc,";
			}
			else if("best".equals(criteria)){
				sorting = "rating desc,";
			}
		}
		
		listItem = productListService.getItemList(item, sorting);
		setSize(listItem.size());
		
		return new ForwardResolution("/WEB-INF/pages/customer/product_list.jsp");
	}
	
	public Resolution viewDetail(){
		
		return new RedirectResolution(ViewDetailActionBean.class);
	}

	
	
	
	/* Setter & Getter     */
	
	public List<Koleksi> getListKoleksi() {
		return listKoleksi;
	}

	public void setListKoleksi(List<Koleksi> listKoleksi) {
		this.listKoleksi = listKoleksi;
	}
	
	public List<Kategori> getListKategori() {
		return listKategori;
	}

	public void setListKategori(List<Kategori> listKategori) {
		this.listKategori = listKategori;
	}
	
	public List<Item> getListItem() {
		return listItem;
	}

	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}

	public int getKoleksiId() {
		return koleksiId;
	}

	public void setKoleksiId(int koleksiId) {
		this.koleksiId = koleksiId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getValueSearch() {
		return valueSearch;
	}

	public void setValueSearch(String valueSearch) {
		this.valueSearch = valueSearch;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	

}
