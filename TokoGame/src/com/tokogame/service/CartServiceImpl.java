/**
 * 
 */
package com.tokogame.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokogame.dao.BelanjaDAO;
import com.tokogame.dao.BelanjaDetailDAO;
import com.tokogame.dao.CartHelperDAO;
import com.tokogame.dao.SequenceDAO;
import com.tokogame.dao.UserDAO;
import com.tokogame.domain.Belanja;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.Item;
import com.tokogame.domain.Sequence;
import com.tokogame.domain.SequenceExample;
import com.tokogame.domain.User;
import com.tokogame.util.DateTimeUtil;
import com.tokogame.util.UtilConstants;

/**
 * @author mardy jonathan
 *
 */
@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartHelperDAO cartHelperDAO;
	
	@Autowired
	private BelanjaDAO belanjDAO;
	
	@Autowired
	private BelanjaDetailDAO belanjaDetailDAO;
	
	@Autowired
	private SequenceDAO sequenceDAO;
	
	
	@Override
	public void userInsert(User user) {
		// TODO Auto-generated method stub
		userDAO.insertSelective(user);
	}

	@Override
	public void belanjaInsert(Belanja belanja) {
		// TODO Auto-generated method stub
		belanjDAO.insert(belanja);
	}

	@Override
	public void detailBelanjaInsert(BelanjaDetail detail) {
		// TODO Auto-generated method stub
		belanjaDetailDAO.insert(detail);
	}

	@Override
	public void batchBelanjaDetail(int pkBelanja, List<Item> listItem) {
		// TODO Auto-generated method stub
		cartHelperDAO.batchBelanjaDetail(pkBelanja, listItem);
	}

	
	public String generateKodeBelanja(String format){
		String kodeBelanja="";
		String year = DateTimeUtil.getCurrentYear()+"";
		String month = DateTimeUtil.getCurrentMonth()+"";
		String day = DateTimeUtil.getCurrentDate().split("/")[2];
		kodeBelanja = kodeBelanja+format+year+month+day;
		
		SequenceExample example = new SequenceExample();
		SequenceExample.Criteria criteria = example.createCriteria();
		criteria.andSequenceNameEqualTo(UtilConstants.SEQUENCE.KODE_BELANJA);
		criteria.andSequenceDateEqualTo(new Date());
		
		String seqNo = "";
		int nextNo = 0;
		Sequence seq = new Sequence();
		
		List<Sequence> sequenceList = sequenceDAO.selectByExample(example);
		if(sequenceList.size()>0){
			 seq = sequenceList.get(0); 
			for(int i=0;i<4-seq.getSequenceNo().toString().length();i++){
				seqNo = seqNo + "0";
			}
			seqNo = seqNo + seq.getSequenceNo();
			nextNo = seq.getSequenceNo()+1;
		}	
		else{
			seqNo = "0001";
			nextNo = 1;
		}
		kodeBelanja = kodeBelanja + seqNo;
		
		criteria.andSequenceDateIsNotNull();
		seq.setSequenceNo(nextNo);
		seq.setSequenceDate(new Date());
		sequenceDAO.updateByExample(seq, example);
		return kodeBelanja;
	}
	
}
