package com.GS;

public class PushZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int L = 0;
		int[] A = {0,1, 0, 3, 12};
		
		for(int R = 0; R < A.length; R++) {
			if(A[R] != 0) {
				int temp = A[R];
				A[R] = A[L];
				A[L] = temp;
				L++;
			}
		}
		for(int i = 0 ; i < A.length; i ++) {
			System.out.println(A[i]);
		}
	}
	
}
