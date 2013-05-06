/**
 * 
 */
package com.tokogame.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.BelanjaDetailDAO;
import com.tokogame.dao.BelanjaDetailHelperDAO;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.BelanjaDetailExample;

/**
 * @author mardy jonathan
 *
 */
@Service("eksporService")
public class EksporServiceImpl implements EksporService{

	@Autowired
	private BelanjaDetailDAO belanjaDetailDAO;
	
	@Autowired
	private BelanjaDetailHelperDAO belanjaDetailHelperDAO;
	
	@Override
	public List<BelanjaDetail> getListBelanjaDetail(int pkBelanja) {
		// TODO Auto-generated method stub
		BelanjaDetailExample example = new BelanjaDetailExample();
		BelanjaDetailExample.Criteria criteria = example.createCriteria();
		criteria.andFkBelanjaEqualTo(pkBelanja);
		return belanjaDetailDAO.selectByExample(example);
	}

	@Override
	public List<HashMap> getListBelanjaDetailHelper(int pkBelanja) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("fkBelanja", pkBelanja);
		map.put("jenisItem", "DATA");
		return belanjaDetailHelperDAO.selectDetailBelanja(map);
	}

}
