/**
 * 
 */
package com.tokogame.action;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Item;
import com.tokogame.service.ViewDetailService;
import com.tokogame.util.UtilConstants;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/viewDetail")
public class ViewDetailActionBean extends BaseActionBean{

	public int kategoriId;
	public int koleksiId;
	public int itemId;
	public int harga;
	public Item item;
	public List<Item> buyingItem;
	
	@SpringBean
	private ViewDetailService viewDetailService;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		
		item = viewDetailService.getItemByPK(itemId);
		return new ForwardResolution("/WEB-INF/pages/customer/product_detail.jsp");
		
	}
	
	@SuppressWarnings("unchecked")
	public Resolution beli(){
		if(itemId!=0){
			boolean exists = false;
			int index = 0;
			
			buyingItem = (List<Item>) getSessionAttribute(UtilConstants.SESSION.BUYING_ITEM); 
			if(buyingItem==null) buyingItem = new ArrayList<Item>();
			
			for(int i=0;i<buyingItem.size();i++){
				if(itemId == buyingItem.get(i).getPkItem()){
					exists = true;
					index = i;
				}
			}
			
			if(exists){
				int jumlah = buyingItem.get(index).getItemQty()+1;
//				int totalHarga = buyingItem.get(index).getHarga() + harga;
				buyingItem.get(index).setItemQty(jumlah);
//				buyingItem.get(index).setHarga(totalHarga);
			}
			else{
				item = viewDetailService.getItemByPK(itemId);
				item.setItemQty(1);
				item.setHarga(harga);
				buyingItem.add(item);
			}
			setSessionAttribute(UtilConstants.SESSION.BUYING_ITEM, buyingItem);
		}
		return new RedirectResolution(ProductListActionBean.class);
	}

	
	/* Setter & Getter     */
	
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
	
	
	

}
