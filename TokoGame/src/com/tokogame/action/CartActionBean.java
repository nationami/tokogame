/**
 * 
 */
package com.tokogame.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Belanja;
import com.tokogame.domain.Item;
import com.tokogame.domain.User;
import com.tokogame.service.CartService;
import com.tokogame.util.UtilConstants;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/cart")
public class CartActionBean extends BaseActionBean{

	public int size;
	public List<Item> buyingItem;
	public int idx;
	public User user;
	
	@SpringBean
	private CartService cartService;
	
	@SuppressWarnings("unchecked")
	@Override
	@DefaultHandler
	public Resolution show() {
		// TODO Auto-generated method stub
		buyingItem = (List<Item>) getSessionAttribute(UtilConstants.SESSION.BUYING_ITEM);
		if(buyingItem==null) buyingItem = new ArrayList<Item>();
		setSize(buyingItem.size());
		return new ForwardResolution("/WEB-INF/pages/customer/cart.jsp");
	}
	
	@SuppressWarnings("unchecked")
	public Resolution batal(){
		buyingItem = (List<Item>) getSessionAttribute(UtilConstants.SESSION.BUYING_ITEM);
		if(buyingItem.get(idx).getItemQty()>1){
			int jumlah = buyingItem.get(idx).getItemQty()-1;
			buyingItem.get(idx).setItemQty(jumlah);
		}
		else{
			buyingItem.remove(idx);
		}
		setSessionAttribute(UtilConstants.SESSION.BUYING_ITEM, buyingItem);
		return this.show();
	}
	
	@SuppressWarnings("unchecked")
	public Resolution submit(){
		String format = "";
		if(UtilConstants.ROLE.PERSONAL.equals(user.getRole())){
			cartService.userInsert(user);
			format = "PS";
		}
		else{
			user = getContext().getUser();
			format = "MB";
		}
		
		buyingItem = (List<Item>) getSessionAttribute(UtilConstants.SESSION.BUYING_ITEM);
		
		Belanja belanja = new Belanja();
		belanja.setFkUser(user.getPkUser());
		belanja.setKodeBelanja(cartService.generateKodeBelanja(format));
		belanja.setUpdatedDate(new Date());
		belanja.setTotalItem(buyingItem.size());
		
		cartService.belanjaInsert(belanja);
		
		
		cartService.batchBelanjaDetail(belanja.getPkBelanja(), buyingItem);
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("show", "");			
		hashmap.put("code", belanja.getKodeBelanja());
		
		removeSessionAttribute(UtilConstants.SESSION.BUYING_ITEM);
		return new RedirectResolution(HomeActionBean.class).addParameters(hashmap);
	}

	
	/* Setter & Getter     */
	public List<Item> getBuyingItem() {
		return buyingItem;
	}

	public void setBuyingItem(List<Item> buyingItem) {
		this.buyingItem = buyingItem;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

}
