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
import com.tokogame.service.KoleksiMaintenanceService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/koleksiMaintenance")
public class KoleksiMaintenanceActionBean extends BaseActionBean{

	public int size;
	public List<Koleksi> listKoleksi;
	public Koleksi koleksi;
	
	@SpringBean
	private KoleksiMaintenanceService koleksiMaintenanceService;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		return this.search();
	}
	
	public Resolution search(){
		Koleksi koleksi = new Koleksi();
		listKoleksi = koleksiMaintenanceService.getKoleksiList(koleksi);
		
		return new ForwardResolution("/WEB-INF/pages/admin/koleksi_maintenance.jsp");
	}
	
	public Resolution add(){
		
		return new ForwardResolution("/WEB-INF/pages/admin/koleksi_maintenance_field.jsp");
	}
	
	public Resolution edit(){
		listKoleksi = koleksiMaintenanceService.getKoleksiList(koleksi);
		if(listKoleksi.size()>0){
			koleksi = listKoleksi.get(0);
		}
		return new ForwardResolution("/WEB-INF/pages/admin/koleksi_maintenance_field.jsp");
	}
	
	public Resolution delete(){
		koleksiMaintenanceService.deleteKoleksi(koleksi);
		return this.show();
	}
	
	public Resolution save(){
		if(koleksi.getPkKoleksi()==null){
			koleksiMaintenanceService.insertKoleksi(koleksi);
		}
		else if(koleksi.getPkKoleksi()!=null){
			koleksiMaintenanceService.updateKoleksi(koleksi);
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

	public List<Koleksi> getListKoleksi() {
		return listKoleksi;
	}

	public void setListKoleksi(List<Koleksi> listKoleksi) {
		this.listKoleksi = listKoleksi;
	}

	public Koleksi getKoleksi() {
		return koleksi;
	}

	public void setKoleksi(Koleksi koleksi) {
		this.koleksi = koleksi;
	}

	
}
