package com.ibm.orderservice.util;

public class OrderUtil {
	
	 public static String  getTokenFromBearerToken(String bearerToken) {
		return bearerToken.split(" ")[1];
	}

}
