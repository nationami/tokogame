/**
 * 
 */
package com.tokogame.dao;

import java.util.HashMap;
import java.util.List;

/**
 * @author mardy jonathan
 *
 */
public interface BelanjaDetailHelperDAO {

	public List<HashMap> selectDetailBelanja(HashMap<String,Object> param);
	
}
