package com.sc.crm.util;

import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5 {
	
	public static String getMd5Pass(String upass,String salt) throws NoSuchAlgorithmException {
		String str = new Md5Hash(upass, salt).toString();
		return str;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String s="123";
		String sa="abc";
		String pass = Md5.getMd5Pass(s, sa);
		System.out.println(pass);
	}
}
