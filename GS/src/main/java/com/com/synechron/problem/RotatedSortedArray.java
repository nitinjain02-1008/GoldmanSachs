package com.synechron.problem;

public class RotatedSortedArray {

	public static void main(String[] args) { // O(logN) + O(logN) == O(logN)
		
		int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
		
		int target = 5;
		
		int rotatedIndex = countRotation(arr); // Using binary search T.C. O(logN)
		
		int elementIndex = searchElement(arr, target); // Using binary search T.C. O(logN)
		
		System.out.println("rotatedIndex = " + rotatedIndex + " and element index = " + elementIndex);
		
		int index = -1;
		
		if(rotatedIndex < elementIndex) {
			
			index = elementIndex - rotatedIndex;
			
		}else {
			
			index = arr.length - rotatedIndex + elementIndex ;
			
		}
		
		System.out.println("Index = " + index);
	}	
	
	static int searchElement(int[] arr, int target) { // O(logN)
		
		int l = arr.length;
		
		int start = 0, end = l-1;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[start] <= arr[mid]) {
				if(arr[start] <= target && target <= arr[mid]) {
					end = mid;
				}else
					start = mid+1;
			}else {
				if(arr[mid] < target  && target <= arr[l-1]) {
					start = mid + 1;
				}else {
					end = mid;
				}
			}
		}
		
		return arr[start] == target ? start : -1;
	}
	
	static int countRotation(int[] arr) { // O(logN)
		
		int n = arr.length;
		int start = 0;
		int end = n-1;
		
		while(start <= end) {
		
			int mid = start + (end - start) / 2;
			int prev = (mid - 1 + n ) % n;
			int next = (mid + 1) % n;
			
			if(arr[mid] <= arr[prev] && arr[mid] <= arr[next])
				return mid;
			else if(arr[mid] <= arr[end])
				end = mid - 1;
			else if(arr[mid] >= arr[start])
				start = mid + 1;
		}
		
		return 0;
	}

}
