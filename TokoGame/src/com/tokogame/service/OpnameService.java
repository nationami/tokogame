/**
 * 
 */
package com.tokogame.service;

import java.util.List;

import com.tokogame.domain.Opname;

/**
 * @author mardy jonathan
 *
 */
public interface OpnameService {

	public List<Opname> getOpname();
	
	public void insertOpname(Opname opname);
	
}
