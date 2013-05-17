/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.OpnameDAO;
import com.tokogame.domain.Opname;
import com.tokogame.domain.OpnameExample;

/**
 * @author mardy jonathan
 *
 */
@Service("opnameService")
public class OpnameServiceImpl implements OpnameService{

	@Autowired
	private OpnameDAO opnameDAO;
	
	@Override
	public List<Opname> getOpname() {
		// TODO Auto-generated method stub
		OpnameExample example = new OpnameExample();
		OpnameExample.Criteria criteria = example.createCriteria();
		return opnameDAO.selectByExample(example);
	}

	@Override
	public void insertOpname(Opname opname) {
		// TODO Auto-generated method stub
		opnameDAO.insert(opname);
	}
}
