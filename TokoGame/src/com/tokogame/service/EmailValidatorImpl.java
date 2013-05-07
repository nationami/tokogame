/**
 * 
 */
package com.tokogame.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


/**
 * @author mardy jonathan
 * Using regex
 */
@Service("emailValidator")
public class EmailValidatorImpl implements EmailValidator{

	@Override
	public Boolean email(String email) {
		String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
		 
		 Pattern p = Pattern.compile(regEx);
		 Matcher m = p.matcher(email);
		 
		 if(m.find()) 
		 {
		  return true;
		 }
		 else
		 {
		  return false;
		 }
	}
}
