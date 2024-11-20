package com.synechron.morgan;

import java.util.stream.IntStream;

public class CountSpecialChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is the test of counting of special character!@$";
		
		//long count = s.replaceAll(" ", s).toCharArray().filter(c -> !Character.isLetter(s.charAt(c-1)) || ! Character.isDigit(s.charAt(c-1))).count();
		
		//Stream.of(s.replaceAll(" ", s).toCharArray()).filter(c -> !Character.isLetterOrDigit((char)c) || ! Character.isDigit(s.charAt(c-1))).count();
		
		System.out.println(s.replaceAll(" ", "").trim());
		
		//long count = s.replaceAll(" ", "").trim().chars().mapToObj(c -> (char) c).filter(c -> !Character.isLetterOrDigit(c)).count();
		
		IntStream intStream = s.replaceAll(" ", "").chars();
		
	//	intStream.forEach(System.out::println);
		
		long count = intStream.filter(a -> !Character.isLetterOrDigit(a)).count();
		
		System.out.println("Special character count is = " + count);
		
		count = s.chars().filter(c -> c!=32 && (c<48 || c>57) && (c<65 || c>90) && (c<97 || c>122)).count();
		
		//long count = s.replaceAll(" ", "").trim().chars().filter(c -> Character.isLetterOrDigit(s.charAt(c))).count();
		System.out.println("Special character count is = " + count);
	}

}
