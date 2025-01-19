package com.test.Altimetrik;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
//		 Test case 1
//        System.out.println(solve(new int[]{0, 2, 2}, new int[]{2, 0, 0}, 2));  // Expected output: 2

//         Test case 2
//        System.out.println(solve(new int[]{0, 0, 1, 1, 2}, new int[]{1, 0, 2, 2}, 2));  // Expected output: 1
        
//        System.out.println(solve(new int[]{0, 1}, new int[]{0}, 2));  // Expected output: 1
        
//        System.out.println(solve(new int[]{0,  1, 1}, new int[]{2, 0, 2, 0,0,2}, 2));  // Expected output: 3
//		System.out.println(optimizedSolution(new ArrayList<Integer>(Arrays.asList(2,  10, 2)), new ArrayList<Integer>(Arrays.asList(2, 0, 2, 0,0,0,0,2)), 2));
//		System.out.println(solution(new ArrayList<Integer>(Arrays.asList(2,  10, 2)), new ArrayList<Integer>(Arrays.asList(2, 0, 2, 0,0,0,0,2)), 2));
		
		
		System.out.println(optimizedSolution(new ArrayList<Integer>(Arrays.asList(2,  10, 2)), new ArrayList<Integer>(Arrays.asList(2, 0, 2, 0,3,3,5,6)), 2));
		System.out.println(solution(new ArrayList<Integer>(Arrays.asList(2,  10, 2)), new ArrayList<Integer>(Arrays.asList(2, 0, 2, 0,3,3,5,6)), 2));
		
		
//        System.out.println(solve(new int[]{0, 1, 1, 1}, new int[]{0, 0, 2}, 2));  // Expected output: 1
//        System.out.println(solution(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1)), new ArrayList<Integer>(Arrays.asList(0,0,2)), 2)); 
        
//        System.out.println(solve(new int[]{0, 0, 1, 1, 2}, new int[]{1, 0, 2, 2}, 2));  // Expected output: 1
	}
	
	public static long solve(int[] onHand, int[] supplier, int demand) {
        // Step 1: Find the maximum expiry day
        int maxDay = Math.max(Arrays.stream(onHand).max().orElse(0), Arrays.stream(supplier).max().orElse(0));
        // Step 2: Create arrays to count how many creamers expire on each day
        int[] exp1 = new int[maxDay + 1];  // Counts for onHand
        int[] exp2 = new int[maxDay + 1];  // Counts for supplier
        // Step 3: Populate the exp1 array with creamers from onHand
        for (int x : onHand) {
            exp1[x]++;
        }
        // Step 4: Populate the exp2 array with creamers from supplier
        for (int x : supplier) {
            exp2[x]++;
        }
        // Step 5: Initialize variables for the simulation
        long totalDemand = 0;
        long expired1 = 0;
        long expired2 = 0;
        long mx = 0;
        // Step 6: Simulate the usage of creamers day by day
        for (int i = 0; i <= maxDay; i++) {
            expired1 += exp1[i];  // Update expired creamers from onHand
            expired2 += exp2[i];  // Update expired creamers from supplier
            totalDemand += demand;  // Add the demand for the current day
            // Step 7: Check if we have enough creamers for the day
            if (expired1 > totalDemand) {
                return -1;  // Waste is guaranteed
            }
            // Step 8: Calculate the maximum number of creamers we can order
            mx = Math.max(mx, expired1 + expired2 - totalDemand);
        }
        // Step 9: Return the maximum creamers that can be ordered without waste
        return (long) supplier.length - mx;
    }

	public static int solution(List<Integer> onHand, List<Integer> supplier, int demand) {
		
		int maxDays = Math.max(onHand.stream().max(Comparator.naturalOrder()).orElse(0), supplier.stream().max(Comparator.naturalOrder()).orElse(0));
		
		int[] onHandCountExpired = new int[maxDays + 1];
		int[] supplierCountExpired = new int[maxDays + 1];
		
		for(int i : onHand) { // O(N)
			onHandCountExpired[i]++; 
		}
		
		for(int j : supplier) { // O(M)
			supplierCountExpired[j]++;
		}
		
		int totalDemand = 0;
		int maxCount = 0;
		int onHandExpired = 0;
		int supplierExpired =0;
		System.out.println(maxDays+1);
		for(int i =0; i<= maxDays; i++) {// O(maxDays)
			onHandExpired += onHandCountExpired[i];
			supplierExpired += supplierCountExpired[i];
			
			totalDemand += demand;
			
			if(onHandExpired > totalDemand) {
				return -1;
			}
			
			maxCount = Math.max(maxCount, onHandExpired + supplierExpired - totalDemand);
		}
		return supplier.size() - maxCount;
	}

	public static int optimizedSolution(List<Integer> stock, List<Integer> supplier, int demand) {
		int supplierCount = supplier.size();
		
		Map<Integer, Integer> stockMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> supplierMap = new HashMap<Integer, Integer>();
		
		Set<Integer> uniqueExpiryDays = new TreeSet<Integer>();
		
		for(Integer key : stock) {
			stockMap.put(key, stockMap.getOrDefault(key, 0)+1);
			uniqueExpiryDays.add(key);
		}
		
		for(Integer key : supplier) {
			supplierMap.put(key, supplierMap.getOrDefault(key, 0)+1);
			uniqueExpiryDays.add(key);
		}
		
		int totalDemand = 0;
		int maxCount = 0;
		int stockExpiredCount = 0;
		int supplierExpiredCount =0;
		
		System.out.println(uniqueExpiryDays.size());
		
		for(Integer expiryDays : uniqueExpiryDays) {
			
			stockExpiredCount += stockMap.getOrDefault(expiryDays, 0);
			
			supplierExpiredCount += supplierMap.getOrDefault(expiryDays, 0);
			
			totalDemand = (expiryDays + 1) * demand ;
			
			if(stockExpiredCount > totalDemand) {
				return -1;
			}
			
			maxCount = Math.max(maxCount, supplierExpiredCount + stockExpiredCount - totalDemand);
			
		}
		
		return supplierCount - maxCount;
	}
}


