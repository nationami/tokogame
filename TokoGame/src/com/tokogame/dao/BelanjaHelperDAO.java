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
public interface BelanjaHelperDAO {

	public List<HashMap> selectBelanja(HashMap<String,Object> param);
}
