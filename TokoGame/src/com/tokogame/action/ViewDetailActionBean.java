/**
 * 
 */
package com.tokogame.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/viewDetail")
public class ViewDetailActionBean extends BaseActionBean{

	public int kategoriId;
	public int koleksiId;
	public int itemId; 
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
//		return new ForwardResolution("/WEB-INF/pages/customer/product_detail.jsp");
		return new ForwardResolution("/WEB-INF/pages/testing/testing.jsp");
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
	
	
	

}
