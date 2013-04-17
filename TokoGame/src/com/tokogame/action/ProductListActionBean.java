/**
 * 
 */
package com.tokogame.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

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
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		listKoleksi = productListService.getAllKoleksiList();
		return new ForwardResolution("/WEB-INF/pages/customer/productList.jsp");
	}

	
	
	
	/* Setter & Getter     */
	
	public List<Koleksi> getListKoleksi() {
		return listKoleksi;
	}

	public void setListKoleksi(List<Koleksi> listKoleksi) {
		this.listKoleksi = listKoleksi;
	}
	
	public int getSize(){
		
		return 0;
	}
	
	

}
