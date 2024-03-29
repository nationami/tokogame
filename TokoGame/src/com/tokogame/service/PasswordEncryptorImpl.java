/**
 * 
 */
package com.tokogame.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

/**
 * @author mardy jonathan
 * Using MD5 Encryption
 */
@Service("passwordEncryptor")
public class PasswordEncryptorImpl implements PasswordEncryptor{

	@Override
	public String encrypt(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.reset();
		md.update(password.getBytes());
		byte[] digest = md.digest();
		return dumpBytes(digest);
	}
	
	private static String dumpBytes(byte[] bytes) {

		int size = bytes.length;
		StringBuffer sb = new StringBuffer(size * 2);
		String s;

		for (int i = 0; i < size; i++) {

			s = Integer.toHexString(bytes[i]);

			if (s.length() == 8) // -128 <= bytes[i] < 0
				sb.append(s.substring(6));
			else if (s.length() == 2) // 16 <= bytes[i] < 128
				sb.append(s);
			else
				sb.append("0").append(s); // 0 <= bytes[i] < 16
		}

		return sb.toString();
	}

}
