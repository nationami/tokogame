/**
 * 
 */
package com.tokogame.util;

/**
 * @author mardy jonathan
 *
 */
public interface UtilConstants {

	public interface ROLE {
    	String ADMIN = "ADMIN";
    	String OPERATOR = "OPERATOR";
    	String MEMBER = "MEMBER";
    	String PERSONAL = "PERSONAL";
    	
    }
	
	public interface SESSION {
    	public String USER = "__user";
    	public String BUYING_ITEM = "__buyingitem";
    	public String ROLE = "__role";
    }
	
	public interface SEQUENCE {
    	public String KODE_BELANJA = "kode_belanja";
    }
	
	public interface CONS {
    	public int RETUR = 1;
    	public int BATAL_RETUR = 0;
    }
	
	public interface BELANJA_STATUS {
    	public String PENDING = "PENDING";
    	public String BAYAR = "BAYAR";
    }
	
	
}
