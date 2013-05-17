/**
 * 
 */
package com.tokogame.action;

import java.io.File;
import java.io.IOException;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Konfigurasi;
import com.tokogame.service.KategoriMaintenanceService;
import com.tokogame.service.KonfigurasiService;
import com.tokogame.util.ConfigManager;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/konfigurasi")
public class KonfigurasiActionBean extends BaseActionBean{

	public Konfigurasi konfigurasi;
	private FileBean imageFile;
	public long imageId;
	
	@SpringBean
	private KonfigurasiService konfigurasiService;
	
	@Override
	@DefaultHandler
	public Resolution show() throws IOException {
		// TODO Auto-generated method stub
		konfigurasi = konfigurasiService.getKonfigurasi();
		return new ForwardResolution("/WEB-INF/pages/admin/konfigurasi_maintenance.jsp");
	}
	

	public Resolution save() throws IOException{
		if(konfigurasi!=null && konfigurasi.getBannerPath()!=null){
			File file = new File(konfigurasi.getBannerPath());
			if(file.exists()){
				file.delete();
			}
		}
		
		if(imageFile!=null){
			String fileName = imageFile.getFileName();
			String fileExt  = (fileName.lastIndexOf(".") > 0)? fileName.substring(fileName.lastIndexOf(".")) : ".";
			konfigurasi.setBannerName(fileName);
			konfigurasi.setBannerPath(ConfigManager.getConfiguration().getString("UPLOAD_DIR") + File.separator + getImageId() + fileExt);
			
			// save file
			try {
				File dir = new File(ConfigManager.getConfiguration().getString("UPLOAD_DIR"));
				if(!dir.exists()){
					dir.mkdirs();
				}
				imageFile.save(new File(konfigurasi.getBannerPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(konfigurasi.getPkKonfigurasi()==null){
			konfigurasiService.insertKonfigurasi(konfigurasi);
		}
		else{
			konfigurasiService.updateKonfigurasi(konfigurasi);
		}
		
		return this.show();
	}
	
	public Resolution cancel(){
		
		return new RedirectResolution(AdminHomeActionBean.class);
	}

	/* Setter & Getter     */
	
	public Konfigurasi getKonfigurasi() {
		return konfigurasi;
	}

	public void setKonfigurasi(Konfigurasi konfigurasi) {
		this.konfigurasi = konfigurasi;
	}


	public long getImageId() {
		return System.currentTimeMillis();
	}


	public void setImageId(long imageId) {
		this.imageId = imageId;
	}


	public FileBean getImageFile() {
		return imageFile;
	}


	public void setImageFile(FileBean imageFile) {
		this.imageFile = imageFile;
	}
	
	
	
}
