/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tokogame.domain.User;

/**
 * @author mardy jonathan
 *
 */
public interface UserMaintenanceService {
	
	public List<User> getUserList(User user);
	
	public void insertUser(User user);
	
	public void updateUser(User user);

	public void deleteUser(User user);
}
