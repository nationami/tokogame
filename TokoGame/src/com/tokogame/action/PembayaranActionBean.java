/**
 * 
 */
package com.tokogame.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.Penjualan;
import com.tokogame.domain.Retur;
import com.tokogame.service.EksporService;
import com.tokogame.service.PembayaranService;
import com.tokogame.util.UtilConstants;

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
	public Retur retur;
	public int hargaItem;
	public int pkDetail;
	public Penjualan penjualan;
	
	
	@Override
	@DefaultHandler
	public Resolution show() throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("status", UtilConstants.BELANJA_STATUS.PENDING);
		makeOffset("cart_list.offset");
		buyingItem = pembayaranService.getAllDaftarBelanjaMap(criteria);
		setSize(buyingItem.size());
		return new ForwardResolution("/WEB-INF/pages/admin/pembayaran.jsp");
	}
	
	public Resolution detail(){
		makeOffset("cart_list.offset");
		detailBuyingItem = eksporService.getListBelanjaDetailRetur(belanja.getPkBelanja());
		setSize(detailBuyingItem.size());
		return new ForwardResolution("/WEB-INF/pages/admin/detail_pembayaran.jsp");
	}
	
	public Resolution retur(){
		retur.setFkBelanjaDetail(pkDetail);
		List<Retur> listRetur = pembayaranService.getReturByPkDetail(pkDetail);
		if(listRetur.size()>0){
			Retur tempData = listRetur.get(0);
			int qtyRetur = retur.getReturQty();
			
			retur.setReturQty(tempData.getReturQty()+qtyRetur);
			pembayaranService.updateRetur(retur);
		}
		else{
			pembayaranService.insertRetur(retur);
		}
		BelanjaDetail detail = new BelanjaDetail();
		detail.setPkBelanjaDetail(pkDetail);
		detail.setIsRetur(UtilConstants.CONS.RETUR);
		pembayaranService.updateDetailBelanja(detail);
		
		Belanja belanja = new Belanja();
		belanja.setPkBelanja(retur.getFkBelanja());
		setBelanja(belanja);
		return this.detail();
	}
	
	public Resolution cancelRetur(){
		retur.setFkBelanjaDetail(pkDetail);
		pembayaranService.deleteRetur(retur);
		
		BelanjaDetail detail = new BelanjaDetail();
		detail.setPkBelanjaDetail(pkDetail);
		detail.setIsRetur(UtilConstants.CONS.BATAL_RETUR);
		pembayaranService.updateDetailBelanja(detail);
		
		
		Belanja belanja = new Belanja();
		belanja.setPkBelanja(retur.getFkBelanja());
		setBelanja(belanja);
		return this.detail();
	}
	
	public Resolution bayar() throws IOException{
		penjualan.setTanggalJual(new Date());
		pembayaranService.insertPenjualan(penjualan);
		
		Belanja belanja = new Belanja();
		belanja.setPkBelanja(penjualan.getFkBelanja());
		belanja.setStatus(UtilConstants.BELANJA_STATUS.BAYAR);
		pembayaranService.updateBelanja(belanja);
		
		return this.show();
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

	public Retur getRetur() {
		return retur;
	}

	public void setRetur(Retur retur) {
		this.retur = retur;
	}

	public int getHargaItem() {
		return hargaItem;
	}

	public void setHargaItem(int hargaItem) {
		this.hargaItem = hargaItem;
	}

	public int getPkDetail() {
		return pkDetail;
	}

	public void setPkDetail(int pkDetail) {
		this.pkDetail = pkDetail;
	}

	public Penjualan getPenjualan() {
		return penjualan;
	}

	public void setPenjualan(Penjualan penjualan) {
		this.penjualan = penjualan;
	}

	
	
	
}
