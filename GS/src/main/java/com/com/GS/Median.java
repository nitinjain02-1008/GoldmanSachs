package com.GS;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {4, 10};
		int[] arr2 = {3, 8, 11, 20, 22, 23};
		
		// {3, 4, 8, 10, 11, 20, 22, 23} count = 4 size =8 %2 ==0
		
		System.out.println(getMedian(arr1, arr2));
		//System.out.println(getBinaryMedian(arr1, arr2));

	}
	
	public static int getMedian(int arr1[], int arr2[]) {
		int m1 = -1, m2 = -1;
		
		int n = arr1.length;
		int m = arr2.length;
		
		int i = 0, j = 0;
		int count;
		
		for(count = 0; count <= (n+m)/2; count++) {
			m2 = m1;
			if(i != n && j != m) {
				m1 = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
			}else if(i < n) {
				m1 = arr1[i++];
			}else {
				m1 = arr2[j++];
			}
		}
		
		if((n+m) % 2 == 1)
			return m1;
		else
			return (m1 + m2)/2;// 10+11/2=10
	}
	
	public static double getBinaryMedian(int arr1[], int arr2[]) {
		
		int n = arr1.length;
		int m = arr2.length;
		
		if(n > m)
			return getBinaryMedian(arr2, arr1);
		
		int start = 0, end = n, realMid = (n + m +1) / 2;
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			int leftFASize = mid;
			int leftSASize = realMid - mid;
			
			int leftFA = leftFASize > 0 ? arr1[leftFASize-1] : Integer.MIN_VALUE;
			int leftSA = leftSASize > 0 ? arr2[leftSASize-1] : Integer.MIN_VALUE;
			
			int rightFA = leftFASize < n ? arr1[leftFASize] : Integer.MAX_VALUE;
			int rightSA = leftSASize < m ? arr2[leftSASize] : Integer.MAX_VALUE;
			
			if(leftFA <= rightSA && leftSA <= rightFA) {
				if((n+m)%2 == 0) {
					return (Math.max(leftFA, leftSA) + Math.max(rightFA, rightSA)) / 2.0;
				}
				return Math.max(leftFA, leftSA);
			} else if(leftFA > leftSA)
				end = mid-1;
			else
				start = mid+1;
		}
		
		return 0.0;
	}
}
