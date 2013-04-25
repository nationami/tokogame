/**
 * 
 */
package com.tokogame.service;

/**
 * @author mardy jonathan
 * Using MD5 Encryption
 */
public interface PasswordEncryptor {

	/**
	 * Encrypt string  
	 */
	public String encrypt(String password);
}
