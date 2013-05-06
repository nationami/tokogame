/**
 * 
 */
package com.tokogame.action;

import com.tokogame.util.UtilConstants;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/home")
public class HomeActionBean extends BaseActionBean{

	public String code;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		return new ForwardResolution("/WEB-INF/pages/home.jsp");
	}
	
	public Resolution personal(){
		setSessionAttribute(UtilConstants.SESSION.ROLE, UtilConstants.ROLE.PERSONAL);
		return show();
	}
	
	public Resolution member(){
		return new RedirectResolution(LoginActionBean.class);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
}
