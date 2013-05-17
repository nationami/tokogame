/**
 * 
 */
package com.tokogame.action;

import java.util.Date;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.tokogame.domain.Item;
import com.tokogame.domain.Opname;
import com.tokogame.service.OpnameService;
import com.tokogame.service.ProductListService;

/**
 * @author mardy jonathan
 *
 */
@UrlBinding("/action/opname")
public class OpnameActionBean extends BaseActionBean{

	@SpringBean
	private ProductListService productListService;
	
	@SpringBean
	private OpnameService opnameService;
	
	public int size;
	public List<Item> listItem;
	public List<Opname> listOpname;
	public Opname opname;
	
	@Override
	@DefaultHandler
	public Resolution show(){
		// TODO Auto-generated method stub
		this.makeOffset("main_opname_list.offset");
		listOpname = opnameService.getOpname();
		setSize(listOpname.size());
		return new ForwardResolution("/WEB-INF/pages/admin/opname_list.jsp");
	}
	
	public Resolution add(){
		Item item = new Item();
		listItem = productListService.getItemList(item, "");
		return new ForwardResolution("/WEB-INF/pages/admin/opname.jsp");
	}
	
	public Resolution proses(){
		opname.setTanggalOpname(new Date());
		opnameService.insertOpname(opname);
		return this.show();
	}

	/* Setter & Getter*/
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

	public List<Opname> getListOpname() {
		return listOpname;
	}

	public void setListOpname(List<Opname> listOpname) {
		this.listOpname = listOpname;
	}

	public Opname getOpname() {
		return opname;
	}

	public void setOpname(Opname opname) {
		this.opname = opname;
	}

	
	
}
