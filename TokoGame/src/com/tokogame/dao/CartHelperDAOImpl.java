/**
 * 
 */
package com.tokogame.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.Item;

/**
 * @author mardy jonathan
 *
 */
public class CartHelperDAOImpl extends SqlMapClientDaoSupport implements CartHelperDAO{

	@Override
	public void batchBelanjaDetail(final int pkBelanja, final List<Item> listItem) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				BelanjaDetail belanjaDetail = new BelanjaDetail();
				belanjaDetail.setFkBelanja(pkBelanja);
				for(Item data : listItem){
					belanjaDetail.setFkItem(data.getPkItem());
					belanjaDetail.setQty(data.getQty());
					executor.insert("belanja_detail.ibatorgenerated_insertSelective", belanjaDetail);
				}
				return new Integer(executor.executeBatch());
			}
			
		});
	}

	

}
