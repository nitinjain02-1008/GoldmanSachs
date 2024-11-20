package com.GS;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayUniqueElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 1, 2, 3, 4, 5, 1, 2, 3 }; 

		//int res = largestSubarray(arr);
		System.out.println(largestSubarray(arr));
		
		// Optional<Employee> emp = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
	}
	
	static int largestSubarray(int[] arr) {
		
		Map<Integer, Integer> index = new HashMap<>();
		
		int result = 0;
		
		for(int i = 0, j = 0; i<arr.length; i++) {
			
			j = Math.max(index.containsKey(arr[i]) ? index.get(arr[i]) : 0, j);
			
			result = Math.max(result, i - j +1);
			
			index.put(arr[i], i+1);
		}
		
		return result;
	}

}
