/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import com.tokogame.domain.BelanjaDetail;

/**
 * @author mardy jonathan
 *
 */
public interface EksporService {

	public List<BelanjaDetail> getListBelanjaDetail(int pkBelanja);
	
	public List<HashMap> getListBelanjaDetailHelper(int pkBelanja);
}
