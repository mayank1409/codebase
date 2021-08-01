package com.javatech.codebaseusersapi.util;

import java.util.UUID;

public class UserUtils {
	
	public static String generateUserId() {
		return UUID.randomUUID().toString();
	}

}
