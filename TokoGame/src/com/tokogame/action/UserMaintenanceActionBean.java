/**
 * 
 */
package com.tokogame.action;

import java.util.List;

import sun.security.util.Password;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.User;
import com.tokogame.service.PasswordEncryptorImpl;
import com.tokogame.service.UserMaintenanceService;
import com.tokogame.service.PasswordEncryptor;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/userMaintenance")
public class UserMaintenanceActionBean extends BaseActionBean{

	public int size;
	public List<User> listUser;
	public User user;
	
	@SpringBean
	private UserMaintenanceService userMaintenanceService;
	
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		return this.search();
	}
	
	public Resolution search(){
		User user = new User();
		listUser = userMaintenanceService.getUserList(user);
		
		return new ForwardResolution("/WEB-INF/pages/admin/user_maintenance.jsp");
	}
	
	public Resolution add(){
		
		return new ForwardResolution("/WEB-INF/pages/admin/user_maintenance_field.jsp");
	}
	
	public Resolution edit(){
		listUser = userMaintenanceService.getUserList(user);
		if(listUser.size()>0){
			user = listUser.get(0);
		}
		return new ForwardResolution("/WEB-INF/pages/admin/user_maintenance_field.jsp");
	}
	
	public Resolution delete(){
		userMaintenanceService.deleteUser(user);
		return this.show();
	}
	
	public Resolution save(){
		if(user.getUserId()==null){
			if(user.getPassword()!=null)
			{
				PasswordEncryptor encrypt = new PasswordEncryptorImpl();
				user.setUserLogin(user.getUserLogin());
				user.setName(user.getName());
				user.setPassword(encrypt.encrypt(user.getPassword()));
				user.setHandphone(user.getHandphone());
				user.setRole(user.getRole());
				if (user.getActive() == null){
					user.setActive(0);
				}
					else {
						user.setActive(1);
				}
				userMaintenanceService.insertUser(user);	
			}
		}
		else if(user.getUserId()!=null)
		{
			if (user.getPassword() == null)
			{
				//PasswordEncryptor encrypt = new PasswordEncryptorImpl();
				user.setUserLogin(user.getUserLogin());
				user.setName(user.getName());
				//user.setPassword(encrypt.encrypt(user.getPassword()));
				user.setHandphone(user.getHandphone());
				user.setRole(user.getRole());
				if (user.getActive() == null)
				{
					user.setActive(0);
				}
				else
				{
						user.setActive(1);
				}
				userMaintenanceService.updateUser(user);
			}
			else if(user.getPassword() != null)
			{
				PasswordEncryptor encrypt = new PasswordEncryptorImpl();
				user.setUserLogin(user.getUserLogin());
				user.setName(user.getName());
				user.setPassword(encrypt.encrypt(user.getPassword()));
				user.setHandphone(user.getHandphone());
				user.setRole(user.getRole());
				if (user.getActive() == null)
				{
					user.setActive(0);
				}
				else
				{
					user.setActive(1);
				}
				userMaintenanceService.updateUser(user);
			}
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

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
