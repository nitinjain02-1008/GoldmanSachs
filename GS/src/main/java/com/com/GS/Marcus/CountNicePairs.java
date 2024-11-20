package com.GS.Marcus;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

	/*
	 * You are given an array nums that consists of non-negative integers. Let us
	 * define rev(x) as the reverse of the non-negative integer x. For example,
	 * rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it
	 * satisfies all of the following conditions:
	 * 
	 * 1. 0 <= i < j < nums.length 
	 * 2. nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {42,11,1,97, 13,10,35,24,76};
		System.out.println("Count = " + countOfNicePairs(nums));
	}
	
	public static int countOfNicePairs(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : nums) {
			
			int d = num - reverse(num);
			map.put(d, map.getOrDefault(d,0)+1);
			//map.merge(d, 1, Integer::sum);			
		}
		
		final int mod = (int) 1e9 + 7;
		
		long count = 0;
		
		for(int c : map.values()) {
			
			count = (count + (long) c * (c - 1) / 2) % mod;
		}
		
		return (int) count;
	}
	
	private static int reverse(int num) {
		int reversed = 0;
		
		while(num > 0) {
			reversed = reversed * 10 + num % 10;
			num /= 10;
		}
		return reversed;
	}

}
