/**
 * 
 */
package com.tokogame.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.json.JSONArray;

import com.tokogame.domain.Item;
import com.tokogame.domain.PromoDetail;
import com.tokogame.domain.PromoMain;
import com.tokogame.service.ProductListService;
import com.tokogame.service.PromoMaintenanceService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/promoMaintenance")
public class PromoMaintenanceActionBean extends BaseActionBean{

	public int size;
	public List<PromoMain> listPromoMain;
	public List<HashMap> listPromoMainMap;
	public PromoMain promoMain;
	public List<Item> listItem;
	public List<PromoDetail> listPromoDetail;
	public String jsonItem;
	public List<Integer> fkItem;
	public List<Integer> nilaiDiskon;
	public List<String> jenisDiskon;
	
	
	@SpringBean
	private PromoMaintenanceService promoMaintenanceService;
	
	@SpringBean
	private ProductListService productListService;
	
	@Override
	@DefaultHandler
	public Resolution show(){
		// TODO Auto-generated method stub
		return this.search();
	}
	
	public Resolution search(){
		this.makeOffset("promo_list.offset");
		HashMap<String, Object> map = new HashMap<String, Object>();
		listPromoMainMap = promoMaintenanceService.getAllListPromoMainHelper(map);
		setSize(listPromoMainMap.size());
		return new ForwardResolution("/WEB-INF/pages/admin/promo_maintenance.jsp");
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
				listItemMap.add(map);
			}
		}
		JSONArray jArr=new JSONArray(listItemMap);
		setJsonItem(jArr.toString());
		System.out.println("Json Item : >>>>>>>> "+ getJsonItem());
		return new ForwardResolution("/WEB-INF/pages/admin/promo_maintenance_field.jsp");
	}
	
	public Resolution save() throws IOException{
		if(promoMain.getPromoActive()!=null){
			if(promoMain.getPromoActive()!=0){
				promoMain.setPromoActiveDate(new Date());
			}
		}else{
			promoMain.setPromoActive(0);
		}
		
		if(promoMain.getPkPromoMain()==null){
			promoMaintenanceService.insertPromoMain(promoMain);
		}
		else{
			promoMaintenanceService.updatePromoMain(promoMain);
		}
		
		if(fkItem!=null){
			int totalItem = fkItem.size();
			listPromoDetail = new ArrayList<PromoDetail>();
			for(int i=0;i<totalItem;i++){
				PromoDetail pd = new PromoDetail();
				pd.setFkPromoMain(promoMain.getPkPromoMain());
				pd.setFkItem(fkItem.get(i));
				pd.setNilaiDiskon(nilaiDiskon.get(i));
				pd.setJenisDiskon(jenisDiskon.get(i));
				listPromoDetail.add(pd);
			}
			
			promoMaintenanceService.insertPromoDetail(listPromoDetail);	
		}
		
		
		return this.show();
	}
	
	public Resolution edit(){
		listPromoMain = promoMaintenanceService.getCriteriaListPromoMain(promoMain);
		if(listPromoMain.size()>0){
			promoMain = listPromoMain.get(0);
		}
		PromoDetail promoDetail = new PromoDetail();
		promoDetail.setFkPromoMain(promoMain.getPkPromoMain());
		listPromoDetail = promoMaintenanceService.getPromoDetail(promoDetail);
		
		ArrayList<HashMap<String, Object>> listItemMap = new ArrayList<HashMap<String, Object>>();
		Item item = new Item();
		listItem = productListService.getItemList(item, "");
		setSize(listItem.size());
		if(listItem!=null){
			for(int i=0;i<listItem.size();i++){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("pkItem", listItem.get(i).getPkItem());
				map.put("itemName", listItem.get(i).getItemName());
				listItemMap.add(map);
			}
		}
		JSONArray jArr=new JSONArray(listItemMap);
		setJsonItem(jArr.toString());
		System.out.println("Json Item : >>>>>>>> "+ getJsonItem());
		return new ForwardResolution("/WEB-INF/pages/admin/promo_maintenance_field.jsp");
	}
	
	public Resolution cancel(){
		
		return this.show();
	}
	
	public Resolution delete(){
		promoMaintenanceService.deletePromoDetail(promoMain.getPkPromoMain());
		promoMaintenanceService.deletePromoMain(promoMain.getPkPromoMain());
		return this.show();
	}

	/* Setter & Getter */
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<PromoMain> getListPromoMain() {
		return listPromoMain;
	}

	public void setListPromoMain(List<PromoMain> listPromoMain) {
		this.listPromoMain = listPromoMain;
	}

	public PromoMain getPromoMain() {
		return promoMain;
	}

	public void setPromoMain(PromoMain promoMain) {
		this.promoMain = promoMain;
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

	public List<PromoDetail> getListPromoDetail() {
		return listPromoDetail;
	}

	public void setListPromoDetail(List<PromoDetail> listPromoDetail) {
		this.listPromoDetail = listPromoDetail;
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

	public List<Integer> getNilaiDiskon() {
		return nilaiDiskon;
	}

	public void setNilaiDiskon(List<Integer> nilaiDiskon) {
		this.nilaiDiskon = nilaiDiskon;
	}

	public List<String> getJenisDiskon() {
		return jenisDiskon;
	}

	public void setJenisDiskon(List<String> jenisDiskon) {
		this.jenisDiskon = jenisDiskon;
	}

	public List<HashMap> getListPromoMainMap() {
		return listPromoMainMap;
	}

	public void setListPromoMainMap(List<HashMap> listPromoMainMap) {
		this.listPromoMainMap = listPromoMainMap;
	}

	
	
}
