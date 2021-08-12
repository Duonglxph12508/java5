package com.asg.libs;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtils {
	public static String Hash(String plain) {//plain là pw chưa mã hóa
		
		return BCrypt.hashpw(plain, BCrypt.gensalt());
	
	}
	
	public static boolean verify(String plain, String hashed) {
	
		return BCrypt.checkpw(plain, hashed);
	}
}
