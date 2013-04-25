/**
 * 
 */
package com.tokogame.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tokogame.domain.User;
import com.tokogame.service.LoginService;
import com.tokogame.util.UtilConstants;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/login")
public class LoginActionBean extends BaseActionBean{
	private static final Log		log		= LogFactory.getLog(LoginActionBean.class);
	
	
	public String user;
	public String pass;
	private User userResult;
	
	@SpringBean
	private LoginService loginService;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		userResult = getContext().getUser();
		if(userResult==null){
			return new ForwardResolution("/WEB-INF/pages/login.jsp");
		}
		else{
			if(UtilConstants.ROLE.MEMBER.equalsIgnoreCase(userResult.getRole())){
				return new RedirectResolution(HomeActionBean.class);
			}
			else{
				return new RedirectResolution(AdminHomeActionBean.class);
			}
		}
		
	}
	
	public Resolution login(){
		User paramUser = new User();
		if(user!=null && pass!=null){		
			paramUser.setUserLogin(user);
			paramUser.setPassword(pass);
			userResult = loginService.validationUserPass(paramUser);
			
			if(userResult!=null){
				setSessionAttribute(UtilConstants.SESSION.USER, userResult);
				if(UtilConstants.ROLE.MEMBER.equalsIgnoreCase(userResult.getRole())){
					return new RedirectResolution(HomeActionBean.class);
				}
				else{
					return new RedirectResolution(AdminHomeActionBean.class);
				}
			}
			else{
				this.addGlobalError("validation.login.invalid");
			}
		}
		else{
			this.addGlobalError("validation.login.empty");
		}
		return this.show();
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User getUserResult() {
		return userResult;
	}

	public void setUserResult(User userResult) {
		this.userResult = userResult;
	}

	
}
