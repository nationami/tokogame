/**
 * 
 */
package com.tokogame.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tokogame.domain.Item;
import com.tokogame.domain.ItemExample;

/**
 * @author mardy jonathan
 *
 */
public class ItemHelperDAOImpl extends SqlMapClientDaoSupport implements ItemHelperDAO{

	@SuppressWarnings("unchecked")
    public List<Item> selectByExample(ItemExample example, int page) {
        List<Item> list = getSqlMapClientTemplate().queryForList("item.ibatorgenerated_selectByExample", example, page, 10);
        return list;
    }
}
