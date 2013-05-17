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

import com.tokogame.domain.User;
import com.tokogame.service.EmailValidator;
import com.tokogame.service.EmailValidatorImpl;
import com.tokogame.service.PasswordEncryptor;
import com.tokogame.service.PasswordEncryptorImpl;
import com.tokogame.service.UserMaintenanceService;

/**
 * @author willyam surya
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
		//show item list with paging
		makeOffset("user_list.offset");
		
		listUser = userMaintenanceService.getUserList(user);
		setSize(listUser.size());
		return new ForwardResolution("/WEB-INF/pages/admin/user_maintenance.jsp");
	}
	
	public Resolution test() {
		// TODO Auto-generated method stub
		return new ForwardResolution("/WEB-INF/pages/admin/user_maintenance_field.jsp");
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
		PasswordEncryptor encrypt = new PasswordEncryptorImpl();
		EmailValidator email = new EmailValidatorImpl();
		if(user.getPkUser()==null){
			//if(user.getPassword()!=null){
			user.setUserLogin(user.getUserLogin());
			if(userMaintenanceService.countUserLogin(user.getUserLogin()) > 0){
				this.addGlobalError("validation.user.userlogin");
				return this.test();
			}
			else if(userMaintenanceService.countUserLogin(user.getUserLogin()) <= 0){
				user.setName(user.getName());
				user.setHandphone(user.getHandphone());
				user.setPassword(encrypt.encrypt(user.getPassword()));
				if (user.getHandphone().length() >= 10){
					user.setRole(user.getRole());
					if (user.getActive() == null){
						user.setActive(0);
					}
					else {
						user.setActive(1);
					}
					if (email.email(user.getEmail()) == true){
						user.setEmail(user.getEmail());
						user.setAddress(user.getAddress());
						userMaintenanceService.insertUser(user);
						return this.show();
					}
					else if(email.email(user.getEmail()) == false){
						this.addGlobalError("validation.user.email");
						return this.test();
					}
				}
				else if (user.getHandphone().length() < 10){
					this.addGlobalError("validation.user.minlength.handphone");
					return this.test();
				}
			}
		}
		else if(user.getPkUser()!=null){
			if (user.getPassword() == null){
				user.setUserLogin(user.getUserLogin());
				user.setName(user.getName());
				user.setHandphone(user.getHandphone());
				if (user.getHandphone().length() >= 10){
					user.setRole(user.getRole());
					if (user.getActive() == null)
					{
						user.setActive(0);
					}
					else
					{
						user.setActive(1);
					}
					if (email.email(user.getEmail()) == true){
						user.setEmail(user.getEmail());
						user.setAddress(user.getAddress());
						userMaintenanceService.updateUserSelective(user);
						return this.show();
					}
					else if(email.email(user.getEmail()) == false){
						this.addGlobalError("validation.user.email");
						return this.test();
					}
				}
				else if (user.getHandphone().length() < 10){
					this.addGlobalError("validation.user.minlength.handphone");
					return this.test();
				}
			}
			else if(user.getPassword() != null)
			{
				//PasswordEncryptor encrypt = new PasswordEncryptorImpl();
				user.setUserLogin(user.getUserLogin());
				user.setName(user.getName());
				user.setPassword(encrypt.encrypt(user.getPassword()));
				user.setHandphone(user.getHandphone());
				if (user.getHandphone().length() >= 10){
					user.setRole(user.getRole());
					if (user.getActive() == null)
					{
						user.setActive(0);
					}
					else
					{
						user.setActive(1);
					}
					if (email.email(user.getEmail()) == true){
						user.setEmail(user.getEmail());
						user.setAddress(user.getAddress());
						userMaintenanceService.updateUser(user);
						return this.show();
					}
					else if(email.email(user.getEmail()) == false){
						this.addGlobalError("validation.user.email");
						return this.test();
					}
				}
				else if (user.getHandphone().length() < 10){
					this.addGlobalError("validation.user.minlength.handphone");
					return this.test();
				}
			}
		}
		return show();
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
