/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.BelanjaDAO;
import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaExample;

/**
 * @author mardy jonathan
 *
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private BelanjaDAO belanjDAO;
	
	@Override
	public Belanja autentikasiBelanja(Belanja belanja) {
		// TODO Auto-generated method stub
		BelanjaExample example = new BelanjaExample();
		BelanjaExample.Criteria criteria = example.createCriteria();
		criteria.andKodeBelanjaEqualTo(belanja.getKodeBelanja());
		criteria.andKodeAutentikasiEqualTo(belanja.getKodeAutentikasi());
		Belanja data = new Belanja();
		List<Belanja> list = belanjDAO.selectByExample(example); 
		if(list.size()>0){
			data = list.get(0);
		}
		return data;
	}

	

}
