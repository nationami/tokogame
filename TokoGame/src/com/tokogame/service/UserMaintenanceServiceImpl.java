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
@Service("userMaintenanceService")
public class UserMaintenanceServiceImpl implements UserMaintenanceService{

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		if(user.getUserId()!=null){
			criteria.andUserIdEqualTo(user.getUserId());
		}
		if(user.getUserLogin()!=null){
			criteria.andUserLoginEqualTo(user.getUserLogin());
		}
		userExample.setOrderByClause("user_login asc");
		return userDAO.selectByExample(userExample);
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDAO.insert(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.updateByPrimaryKey(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		int userId = user.getUserId();
		userDAO.deleteByPrimaryKey(userId);
	}
	
	

	
}