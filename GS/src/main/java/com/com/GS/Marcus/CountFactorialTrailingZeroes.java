package com.GS.Marcus;

public class CountFactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 10;
		int count = 0;
		
		while (n > 0) {
			n = n / 5;
			count += n;
		}

		System.out.println("Count Factorial Trailing zeroes = " + count);
	}

}
