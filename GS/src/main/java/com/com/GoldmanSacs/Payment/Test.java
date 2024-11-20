package com.GoldmanSacs.Payment;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Double d = new Double(123.5000);
		
		String str = "-abc123cd e345";
		String str1 = str.replaceAll("[^0-9]", "");
		System.out.println(str1);
	}

}
