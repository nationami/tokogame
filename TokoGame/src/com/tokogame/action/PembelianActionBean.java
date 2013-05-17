/**
 * 
 */
package com.tokogame.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.json.JSONArray;

import com.tokogame.domain.Item;
import com.tokogame.domain.Pembelian;
import com.tokogame.domain.PembelianDetail;
import com.tokogame.domain.PromoDetail;
import com.tokogame.service.PembelianService;
import com.tokogame.service.ProductListService;
import com.tokogame.util.DateTimeUtil;
import com.tokogame.util.UtilConstants;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/pembelian")
public class PembelianActionBean extends BaseActionBean{

	@SpringBean
	private PembelianService pembelianService;
	
	@SpringBean
	private ProductListService productListService;
	
	public int size;
	public List<HashMap> listPembelian;
	public Pembelian pembelian;
	public String tanggal;
	public String waktu;
	public List<PembelianDetail> listPembelianDetail;
	public List<Item> listItem;
	public String jsonItem;
	public List<Integer> fkItem;
	public List<Integer> qty;
	public List<Integer> harga;
	public List<String> keterangan;
	public List<Integer> listItemQty;
	public List<String> itemVal;
	
	@Override
	@DefaultHandler
	public Resolution show(){
		// TODO Auto-generated method stub
		return this.search();
	}
	
	public Resolution search(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		this.makeOffset("pembelian_list.offset");
		listPembelian = pembelianService.getListPembelian(map);
		setSize(listPembelian.size());
		return new ForwardResolution("/WEB-INF/pages/admin/pembelian.jsp");
	}
	
	public Resolution add(){
		ArrayList<HashMap<String, Object>> listItemMap = new ArrayList<HashMap<String, Object>>();
		Item item = new Item();
		listItem = productListService.getItemList(item, "");
		setSize(listItem.size());
		if(listItem!=null){
			for(int i=0;i<listItem.size();i++){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("pkItem", listItem.get(i).getPkItem());
				map.put("itemName", listItem.get(i).getItemName());
				map.put("itemQty", listItem.get(i).getItemQty());
				listItemMap.add(map);
			}
		}
		JSONArray jArr=new JSONArray(listItemMap);
		setJsonItem(jArr.toString());
		System.out.println("Json Item : >>>>>>>> "+ getJsonItem());
		return new ForwardResolution("/WEB-INF/pages/admin/pembelian_field.jsp");
	}
	
	public Resolution edit(){
		pembelian = pembelianService.getPembelianByPK(pembelian.getPkPembelian());
		setTanggal(DateTimeUtil.formatDateToStr(pembelian.getTanggalBeli(), "dd-MMMM-yyyy"));
		setWaktu(DateTimeUtil.formatDateToStr(pembelian.getTanggalBeli(), "HH:mm:ss"));
		
		HashMap<String,Object> param = new HashMap<String, Object>();
		param.put("fkPembelian", pembelian.getPkPembelian());
		listPembelianDetail = pembelianService.getListPembelianDetail(param);
		
		ArrayList<HashMap<String, Object>> listItemMap = new ArrayList<HashMap<String, Object>>();
		Item item = new Item();
		listItem = productListService.getItemList(item, "");
		setSize(listItem.size());
		if(listItem!=null){
			for(int i=0;i<listItem.size();i++){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("pkItem", listItem.get(i).getPkItem());
				map.put("itemName", listItem.get(i).getItemName());
				map.put("itemQty", listItem.get(i).getItemQty());
				listItemMap.add(map);
			}
		}
		JSONArray jArr=new JSONArray(listItemMap);
		setJsonItem(jArr.toString());
		System.out.println("Json Item : >>>>>>>> "+ getJsonItem());
		System.out.println(this.getContext().getLocale());
		return new ForwardResolution("/WEB-INF/pages/admin/pembelian_field.jsp");
		
	}
	
	@SuppressWarnings("deprecation")
	public Resolution save() throws ParseException{
		String dateTime = tanggal+" "+waktu;
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss",Locale.US);
		date = formatter.parse(dateTime);
		pembelian.setTanggalBeli(date);
		String process = "";
		if(pembelian.getPkPembelian()==null){
			pembelianService.insertPembelian(pembelian);
			process = "insert";
		}
		else{
			pembelianService.updatePembelian(pembelian);
			process = "update";
		}
		
		if(itemVal!=null){
			listPembelianDetail = new ArrayList<PembelianDetail>();
			for(int i=0;i<itemVal.size();i++){
				int fkItemVal = Integer.parseInt(itemVal.get(i).split(",")[0]);
//				int itemQty = Integer.parseInt(itemVal.get(i).split(",")[1]);
				PembelianDetail pd = new PembelianDetail();
				pd.setFkPembelian(pembelian.getPkPembelian());
				pd.setFkItem(fkItemVal);
				pd.setHargaPembelian(harga.get(i));
				pd.setPembelianQty(qty.get(i));
				pd.setKeterangan(keterangan.get(i));
				listPembelianDetail.add(pd);
			}
			pembelianService.prosesPembelianDetail(listPembelianDetail,process);
		}
		
		return this.show();
	}
	
	public Resolution delete(){
		listPembelianDetail = new ArrayList<PembelianDetail>();
		PembelianDetail pd = new PembelianDetail();
		pd.setFkPembelian(pembelian.getPkPembelian());
		listPembelianDetail.add(pd);
		pembelianService.prosesPembelianDetail(listPembelianDetail,"delete");
		return this.show();
	}
	
	public Resolution cancel(){
		
		return this.show();
	}

	/* Setter & Getter */
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<HashMap> getListPembelian() {
		return listPembelian;
	}

	public void setListPembelian(List<HashMap> listPembelian) {
		this.listPembelian = listPembelian;
	}

	public Pembelian getPembelian() {
		return pembelian;
	}

	public void setPembelian(Pembelian pembelian) {
		this.pembelian = pembelian;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getWaktu() {
		return waktu;
	}

	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}

	public List<PembelianDetail> getListPembelianDetail() {
		return listPembelianDetail;
	}

	public void setListPembelianDetail(List<PembelianDetail> listPembelianDetail) {
		this.listPembelianDetail = listPembelianDetail;
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

	public String getJsonItem() {
		return jsonItem;
	}

	public void setJsonItem(String jsonItem) {
		this.jsonItem = jsonItem;
	}

	public List<Integer> getFkItem() {
		return fkItem;
	}

	public void setFkItem(List<Integer> fkItem) {
		this.fkItem = fkItem;
	}

	public List<Integer> getQty() {
		return qty;
	}

	public void setQty(List<Integer> qty) {
		this.qty = qty;
	}

	public List<Integer> getHarga() {
		return harga;
	}

	public void setHarga(List<Integer> harga) {
		this.harga = harga;
	}

	public List<String> getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(List<String> keterangan) {
		this.keterangan = keterangan;
	}

	public List<String> getItemVal() {
		return itemVal;
	}

	public void setItemVal(List<String> itemVal) {
		this.itemVal = itemVal;
	}

	public List<Integer> getListItemQty() {
		return listItemQty;
	}

	public void setListItemQty(List<Integer> listItemQty) {
		this.listItemQty = listItemQty;
	}
	
	
	
	
	
	

	
}
