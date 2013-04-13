/**
 * 
 */
package com.tokogame.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/welcome")
public class DefaultActionBean extends BaseActionBean{

	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		return new ForwardResolution("/WEB-INF/pages/welcome.jsp");
	}
	
	
	

}
