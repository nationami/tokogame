/**
 * 
 */
package com.tokogame.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Belanja;
import com.tokogame.service.EksporService;
import com.tokogame.service.PembayaranService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/pembayaran")
public class PembayaranActionBean extends BaseActionBean{

	@SpringBean
	private PembayaranService pembayaranService;
	
	@SpringBean
	private EksporService eksporService;
	
	public List<HashMap> buyingItem;
	public int size;
	public Belanja belanja;
	public List<HashMap> detailBuyingItem;
	
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
	public Resolution show() throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Object> criteria = new HashMap<String, Object>();
		makeOffset("cart_list.offset");
		buyingItem = pembayaranService.getAllDaftarBelanjaMap(criteria);
		setSize(buyingItem.size());
		return new ForwardResolution("/WEB-INF/pages/admin/pembayaran.jsp");
	}
	
	public Resolution detail(){
		makeOffset("cart_list.offset");
		detailBuyingItem = eksporService.getListBelanjaDetailHelper(belanja.getPkBelanja());
		setSize(detailBuyingItem.size());
		return new ForwardResolution("/WEB-INF/pages/admin/detail_pembayaran.jsp");
	}

	/* Setter & Getter     */
	
	public List<HashMap> getBuyingItem() {
		return buyingItem;
	}

	public void setBuyingItem(List<HashMap> buyingItem) {
		this.buyingItem = buyingItem;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Belanja getBelanja() {
		return belanja;
	}

	public void setBelanja(Belanja belanja) {
		this.belanja = belanja;
	}

	public List<HashMap> getDetailBuyingItem() {
		return detailBuyingItem;
	}

	public void setDetailBuyingItem(List<HashMap> detailBuyingItem) {
		this.detailBuyingItem = detailBuyingItem;
	}

	
	
	
}
