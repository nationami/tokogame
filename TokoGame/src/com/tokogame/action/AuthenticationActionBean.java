/**
 * 
 */
package com.tokogame.action;

import java.util.HashMap;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Belanja;
import com.tokogame.service.AuthenticationService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/authentication")
public class AuthenticationActionBean extends BaseActionBean{

	@SpringBean
	private AuthenticationService authenticationService;
	
	public Belanja belanja;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		
		return new ForwardResolution("/WEB-INF/pages/customer/authentikasi.jsp");
	}
	
	public Resolution proses(){
		Belanja data = authenticationService.autentikasiBelanja(belanja);
		if(data.getPkBelanja()!=null){
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("show", "");			
			hashmap.put("pkBelanja", data.getPkBelanja());
			return new RedirectResolution(EksporActionBean.class).addParameters(hashmap);
		}
		return new ForwardResolution("/WEB-INF/pages/customer/authentikasi.jsp");
	}
	
	/* Setter & Getter     */

	public Belanja getBelanja() {
		return belanja;
	}

	public void setBelanja(Belanja belanja) {
		this.belanja = belanja;
	}
	
	
	

}
