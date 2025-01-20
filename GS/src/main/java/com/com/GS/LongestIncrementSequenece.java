package com.GS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncrementSequenece {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {10, 22, 9, 11, 12, 13, 14, 33, 21, 50, 41, 60}; // {10, 22, 33, 50, 60} {9,11,12,13, 14, 21, 50, 60} // 8
		int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
		List<Integer> lis = LengthOfLIS(nums);
		System.out.println("LIS = " + lis + " and size is = " + lis.size());
	}

	public static List<Integer> LengthOfLIS(int[] nums) {
		
//		int n = nums.length;
		List<Integer> list = new ArrayList<>();
		
		list.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {// O(N)
			if(nums[i] > list.get(list.size()-1)) {
				list.add(nums[i]);
			}else {
				int low = Collections.binarySearch(list, nums[i]); // O(logn)
				
				if(low < 0) {
					low = -(low+1); 
				}
				
				list.set(low, nums[i]);
			}
		}
		// O(nlogn)
		return list;
	}
}
