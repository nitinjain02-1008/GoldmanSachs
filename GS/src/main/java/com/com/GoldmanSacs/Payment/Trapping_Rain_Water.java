package com.GoldmanSacs.Payment;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		
		int[] blocks = {0,1,0,2,0,0,1,3,2,1,2,1};
		int length = blocks.length;
		
		System.out.println("Trapping water using bestApproach = " + bestApproach(blocks, length));
		System.out.println("Trapping water using twoPointerApproach= " + twoPointerApproach(blocks, length));
		System.out.println("Trapping water using stackApproach = " + stackApproach(blocks, length));
		System.out.println("Trapping water using preCalculation = " + preCalculation(blocks, length));
		System.out.println("Trapping water using bruteForce = " + bruteForce(blocks, length));
	}
	
	// T.C = O(N^2) S.C = O(1)
		public static int bruteForce(int[] blocks, int n) {
			int result =0;
			
			for(int i = 0; i < n; i++) {
				int left_max = blocks[i];
				int right_max = blocks[i];
				
				for(int j = i-1; j >= 0; j-- ) {
					left_max = Math.max(left_max, blocks[j]);
				}
				
				for(int j = i+1; j < n; j++) {
					right_max = Math.max(right_max, blocks[j]);
				}
				
				result += Math.min(left_max, right_max) - blocks[i];
			}
			return result;
		}
	
	// T.C = O(N)+O(N)+O(N) S.C = O(N)
		public  static int preCalculation(int[] blocks, int n) {
			int result =0;
			
			int[] left_max = new int[blocks.length];
			int[] right_max = new int[blocks.length];
			
			left_max[0] = blocks[0];
			right_max[n-1] = blocks[n-1];
			
			for(int i = 1; i < n; i++) {
				left_max[i] = Math.max(left_max[i-1], blocks[i]);
			}
			
			for(int i = n-2; i >= 0; i--) {
				right_max[i] = Math.max(right_max[i+1], blocks[i]);
			}
			
			for(int i = 0; i < n; i++) {
				result += Math.min(left_max[i], right_max[i]) - blocks[i];
			}
			
			return result;
		}
		
	// T.C = O(N) S.C = O(1)
		public static int  twoPointerApproach(int[] blocks, int n) {
			int result =0;
			
			int left_max = 0;
			int right_max = 0;
			
			int i = 0;
			int j = blocks.length-1;
			
			while(i < j) {
				
				left_max = Math.max(left_max, blocks[i]);
				right_max = Math.max(right_max, blocks[j]);
				
				if(left_max < right_max) {
					result += left_max - blocks[i];
					i++;
				}else {
					result += right_max - blocks[j];
					j--;
				}
			}
			
			return result;
		}
		
		
	// T.C = O(N) S.C = O(1)
	public static int bestApproach(int[] blocks, int n) {
		int result =0;
		
		int size = n-1;
		
		int prev = blocks[0];
		
		int prev_index = 0;
		int temp =0;
		
		for(int i = 1; i <= n-1; i++) {
			if(prev <= blocks[i]) {
				prev = blocks[i];
				prev_index = i;
				
				temp = 0;
			}else {
				result += prev - blocks[i];
				temp += prev - blocks[i];
			}
		}
		
		if(prev_index < size) {
			result -= temp;
			prev = blocks[size];
			
			for(int i = size; i >= prev_index; i--) {
				if(prev <= blocks[i])
					prev = blocks[i];
				else
					result += prev - blocks[i];
			}
		}
		return result;
	}
	
	
	// T.C = O(N) S.C = O(N) due to stack
	public static int stackApproach(int[] blocks, int n) {
		int result =0;
		
		return result;
	}
	
	
	
	
}
