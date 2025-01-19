package com.test.Altimetrik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LoungeStocking {

    public static int stockLounge(List<Integer> stock, List<Integer> supplier, int demand) {
    	
    	int supplierCount = supplier.size();
		
		Map<Integer, Integer> stockMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> supplierMap = new HashMap<Integer, Integer>();
		
		Set<Integer> uniqueExpiryDays = new TreeSet<Integer>();
		
//		Step 1 : Map stock expiryDays with occurrences and store unique occurrence of expiryDays 
		for(Integer key : stock) {
			stockMap.put(key, stockMap.getOrDefault(key, 0)+1);
			uniqueExpiryDays.add(key);
		}
		
//		Step 2 : Map supplier expiryDays with occurrences and store unique occurrence of expiryDays
		for(Integer key : supplier) {
			supplierMap.put(key, supplierMap.getOrDefault(key, 0)+1);
			uniqueExpiryDays.add(key);
		}
		
//		Step 3 : Initialize variables for the simulation
		int totalDemand = 0;
		int maxCount = 0;
		int stockExpiredCount = 0;
		int supplierExpiredCount =0;
		
//		System.out.println(uniqueExpiryDays.size());
		
//		Step 4 : Simulate the usage of creamers day by day
		for(Integer expiryDays : uniqueExpiryDays) {
			
			stockExpiredCount += stockMap.getOrDefault(expiryDays, 0);
			
			supplierExpiredCount += supplierMap.getOrDefault(expiryDays, 0);
			
			totalDemand = (expiryDays + 1) * demand ;
			
//			Step 5 : Check if we have enough creamers for the day
			if(stockExpiredCount > totalDemand) {
				return -1;		// Waste is Guaranteed.
			}
			
			maxCount = Math.max(maxCount, supplierExpiredCount + stockExpiredCount - totalDemand);
			
		}
		
//		Step 6 : Return the maximum creamers that can be ordered without waste
		return supplierCount - maxCount;
    }

    public static void main(String[] args) {
//      int[] onHand = {1, 0, 1};
//		int[] supplier = {2, 0, 2, 0, 0, 2};
    	int demand = 2;
    	
    	List<Integer> onHand = new ArrayList<Integer>(List.of(1, 0, 1));
    	List<Integer> supplier = new ArrayList<Integer>(Arrays.asList(2,0,2,0,0,2));

        int maxOrder = stockLounge(onHand, supplier, demand);
        System.out.println("Maximum orderable units: " + maxOrder); // Output: 3
    }
}