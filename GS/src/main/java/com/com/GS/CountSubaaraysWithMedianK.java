package com.GS;

import java.util.HashMap;
import java.util.Map;

public class CountSubaaraysWithMedianK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * */
		//int[] arr = {3,2,1,4,5};
		//int[] arr = {12, 5, 3, 10, 4,8, 10, 12, -6, -1};
		//int[] arr = {1,4,2,10}; 
		//int[] arr = {0,4,3,-1};
		
		
		int[] arr = {2,1,4};
		//Set<Integer> set =new HashSet<Integer>(Arrays.asList(arr));
		/** t = -3,r = 0, m(-3,1) -->
		 *  t = -3+4-4 =-3, r = 0, r=1, m(-3,2) -->
		 *  t = -3+2-4 = -5, r =1, m({-3,2}, {-5,1}) -->
		 *  t = -5 + 6-4 =-3, r= 1+2=2, m({-3,2}, {-5,2}) -->
		 *  t = -3+10-4 = 3, r=2, m({-3,2}, {-5,2}) --> 
		 *  s = 2200000000 --> {}
		**/
		System.out.println("Count = " + countSubarrays(arr, 3));
		System.out.println("Count = " + subArraysSum(arr, 3));
		System.out.println("Count = " + solve1(arr, 3));
		
	}
	
	public static int subArraysSum(int[] nums , int k) {
		int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
	}
	
			private static int solve1(int[] a, int S) {
			    int n = a.length;
			    Map<Long, Integer> map = new HashMap<>();
			    map.put(0L, 1);
			    long runningSum = 0;
			    long res = 0;
			    for (int i = 0; i < n; i++) {
			        runningSum += a[i];
			        long key = runningSum - ((long) S * (i + 1));
			        res += map.getOrDefault(key, 0);
			        if (res > 1000000000)
			            return 1000000000;
			        map.put((long) key, map.getOrDefault(key, 0) + 1);
			       
			    }
			    return (int) res;
			}
	
	public static int countSubarrays(int[] nums, int k) {
        int res = 0, total =0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            total += nums[i]-k;

            if(total == 0){
                res++;
            }

            if(map.containsKey(total)){
                res += map.get(total);
                map.put(total, map.get(total)+1);
            }else{
                map.put(total, 1);
            }
        }

        return res;
    }

}
