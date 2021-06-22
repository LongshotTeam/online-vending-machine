package com.vendingmachine.controller;

import java.util.Base64;

public class FlexBase64 {

	public static void main(String[] args) {

		String encoded = "787f5fe5195c40ef924ac8d67948e15a";
		byte[] actualByte = Base64.getDecoder().decode(encoded);

		String actualString = new String(actualByte);

// print actual String 
		System.out.println("actual String:\n" + actualString);
	}

}
