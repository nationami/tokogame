/**
 * 
 */
package com.tokogame.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.BelanjaDetail;
import com.tokogame.service.EksporService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/ekspor")
public class EksporActionBean extends BaseActionBean{

	public int size;
	public int pkBelanja;
	public List<BelanjaDetail> detailList;
	public List<HashMap> detailListMap;
	public String action;
	public String path;
	
	@SpringBean
	private EksporService eksporService;
	
	@Override
	@DefaultHandler
	public Resolution show() throws IOException {
		// TODO Auto-generated method stub
		detailListMap = eksporService.getListBelanjaDetailHelper(pkBelanja);
		setSize(detailListMap.size());
		if("explorer".equals(action)){
			java.awt.Desktop.getDesktop().open(new java.io.File("C:\\"));
		}
		return new ForwardResolution("/WEB-INF/pages/customer/ekspor_belanja.jsp");
	}
	
	public Resolution download(){
		HttpServletResponse response = getContext().getResponse();
		
		String fileName = path.substring(path.lastIndexOf("/"));
		String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
		String appType = "";
		
//		switch(fileExt) {
//	        case "pdf":
//	        	appType = "application/pdf";
//	            break;
//	        case "exe":
//	        	appType = "application/octet-stream";
//	            break;
//	        case "zip":
//	        	appType = "application/zip";
//	            break;
//	        case "doc":
//	        	appType = "application/msword";
//	            break;
//	        case "xls":
//	        	appType = "application/vnd.ms-excel";
//	            break;
//	        case "ppt":
//	        	appType = "application/vnd.ms-powerpoint";
//	            break;
//	        case "gif":
//	        	appType = "image/gif";
//	            break;
//	        case "png":
//	        	appType = "image/png";
//	            break;
//	        case "jpeg":
//	        	appType = "image/jpg";
//	            break;
//	        case "jpg":
//	        	appType = "image/jpg";
//	            break;
//	        case "mp3":
//	        	appType = "audio/mpeg";
//	            break;
//	        case "wav":
//	        	appType = "audio/x-wav";
//	            break;
//	        case "mpeg":
//	        	appType = "video/mpeg";
//	            break;
//	        case "mpg":
//	        	appType = "video/mpeg";
//	            break;
//	        case "mpe":
//	        	appType = "video/mpeg";
//	            break;
//	        case "mov":
//	        	appType = "video/quicktime";
//	            break;
//	        case "avi":
//	        	appType = "video/x-msvideo";
//	            break;
//	        case "src":
//	        	appType = "plain/text";
//	            break;
//	        default:
//	        	appType = "application/force-download";
//	    }
		
		
		response.setContentType(appType);
        response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
        
        if(path!=null){
        	//File file = new File(path);
        	//FileInputStream fileIn;
        	
        	//System.out.println("File length : >>>>>>>>>>>>>> "+file.length());
        	
			try {
				//fileIn = new FileInputStream(file);
				
				URL url = new URL(path);
				/*URLConnection con = url.openConnection();
	            
	            InputStream fileIn = con.getInputStream();
				*/
				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		        int responseCode = httpConn.getResponseCode();
		        InputStream fileIn = httpConn.getInputStream();
		        
				// Get the size of the file
	        	long streamLength = fileIn.available();
	        	String saveFilePath = "E:/source" + File.separator + fileName;
	        	
	        	System.out.println("File of Size : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + streamLength);
				//ServletOutputStream out = response.getOutputStream();
        	    FileOutputStream out = new FileOutputStream(saveFilePath);
				
	        	byte[] outputByte = new byte[4096];
	        	
	        	int offset = 0;
	        	int numRead = 0;
	        	int downstream = outputByte.length;
	        	
	        	//copy binary contect to output stream
	        	/*while(fileIn.read(outputByte, offset, 4096) != -1)
	        	{
	        		out.write(outputByte, 0, 4096);
	        		
	        	}*/
	        	System.out.println("Output Byte Length : >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + outputByte);
	        	while (offset < streamLength
				  && (numRead = fileIn.read(outputByte,
				  0, downstream)) >= 0) {
	        		
	        		offset += numRead;
	        		out.write(outputByte, 0, downstream);
	        		System.out.println("Progress : >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + offset );
				  
				 }
	        	
	        	if (offset < streamLength) {
	        		 throw new IOException("Could not completely read file ");
        		 }
	        	
	        	fileIn.close();
	        	out.flush();
	        	out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
        
        
        
		
		return null;
	}

	/* Setter & Getter     */
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPkBelanja() {
		return pkBelanja;
	}

	public void setPkBelanja(int pkBelanja) {
		this.pkBelanja = pkBelanja;
	}

	public List<BelanjaDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<BelanjaDetail> detailList) {
		this.detailList = detailList;
	}

	public List<HashMap> getDetailListMap() {
		return detailListMap;
	}

	public void setDetailListMap(List<HashMap> detailListMap) {
		this.detailListMap = detailListMap;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	
}
