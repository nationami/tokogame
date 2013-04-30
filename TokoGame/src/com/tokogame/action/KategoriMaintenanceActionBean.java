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

import com.tokogame.domain.Kategori;
import com.tokogame.service.KategoriMaintenanceService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/kategoriMaintenance")
public class KategoriMaintenanceActionBean extends BaseActionBean{

	public int size;
	public List<Kategori> listKategori;
	public Kategori kategori;
	
	@SpringBean
	private KategoriMaintenanceService kategoriMaintenanceService;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		return this.search();
	}
	
	public Resolution search(){
		Kategori kategori = new Kategori();
		listKategori = kategoriMaintenanceService.getKategoriList(kategori);
		
		return new ForwardResolution("/WEB-INF/pages/admin/kategori_maintenance.jsp");
	}
	
	public Resolution add(){
		
		return new ForwardResolution("/WEB-INF/pages/admin/kategori_maintenance_field.jsp");
	}
	
	public Resolution edit(){
		listKategori = kategoriMaintenanceService.getKategoriList(kategori);
		if(listKategori.size()>0){
			kategori = listKategori.get(0);
		}
		return new ForwardResolution("/WEB-INF/pages/admin/kategori_maintenance_field.jsp");
	}
	
	public Resolution delete(){
		kategoriMaintenanceService.deleteKategori(kategori);
		return this.show();
	}
	
	public Resolution save(){
		if(kategori.getPkKategori()==null){
			kategoriMaintenanceService.insertKategori(kategori);
		}
		else if(kategori.getPkKategori()!=null){
			kategoriMaintenanceService.updateKategori(kategori);
		}
		return this.show();
	}
	
	public Resolution cancel(){
		
		return this.show();
	}

	
	/* Setter & Getter     */
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Kategori> getListKategori() {
		return listKategori;
	}

	public void setListKategori(List<Kategori> listKategori) {
		this.listKategori = listKategori;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	
}
