package com.example.demo.com;

import java.util.Random;

/**
 * ランダムパスワード作成
 *
 */
public class PasswordGenerator {
	
	 public static String generateRandomPassword(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(characters.length());
	            char randomChar = characters.charAt(randomIndex);
	            sb.append(randomChar);
	        }

	        return sb.toString();
	    }

}
