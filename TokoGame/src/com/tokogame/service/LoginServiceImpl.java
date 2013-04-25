/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.UserDAO;
import com.tokogame.domain.User;
import com.tokogame.domain.UserExample;

/**
 * @author mardy jonathan
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User validationUserPass(User user) {
		// TODO Auto-generated method stub
		PasswordEncryptor encrypt = new PasswordEncryptorImpl();
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUserLoginEqualTo(user.getUserLogin());
		criteria.andPasswordEqualTo(encrypt.encrypt(user.getPassword()));
		List<User> listUser = userDAO.selectByExample(userExample);
		if(listUser.size()>0){
			return listUser.get(0);
		}
				
		return null;
	}

}
