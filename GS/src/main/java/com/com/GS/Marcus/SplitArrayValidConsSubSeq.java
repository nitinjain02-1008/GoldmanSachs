package com.GS.Marcus;

import java.util.HashMap;

public class SplitArrayValidConsSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isPossible(int[] arr) {
		
		return false;
	}

}

//class Solution {
//    public boolean isPossible(int[] nums) {
//        
//        // greedy approach - greedly search for a existing group or create new group
//
//        // FM
//        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
//        for(int i:nums){
//            countMap.put(i,countMap.getOrDefault(i,0)+1);
//        }
//
//        //HM - Existing Groups
//        HashMap<Integer,Integer> hm = new HashMap<>();
//
//        for(int i:nums){
//
//            if(countMap.get(i)==0) continue;
//
//            // if any body want i
//           int need= hm.getOrDefault(i,0);
//           if(need>0){ // if need is > 0, join the group
//            hm.put(i,hm.get(i)-1); // i took one so reduce it
//            hm.put(i+1,hm.getOrDefault(i+1,0)+1); // increase the demand for next
//            countMap.put(i,countMap.getOrDefault(i,0)-1);//reduce count
//
//           }else // create a new group
//           if(countMap.getOrDefault(i,0)>0 && countMap.getOrDefault(i+1,0)>0 && countMap.getOrDefault(i+2,0)>0)
//           {
//            countMap.put(i,countMap.getOrDefault(i,0)-1);
//            countMap.put(i+1,countMap.getOrDefault(i+1,0)-1);
//            countMap.put(i+2,countMap.getOrDefault(i+2,0)-1);
//            hm.put(i+3,hm.getOrDefault(i+3,0)+1); 
//           }else{
//            return false; // if a number cannot a join a group or not elligble to form a group
//           }
//        }
//        return true; // successfully crossed all
//    }
//}
