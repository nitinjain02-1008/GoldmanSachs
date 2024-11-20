package com.GS.Marcus;

import java.util.HashMap;
import java.util.Map;

public class MinimumcardPickUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] cards = {3,4,2,3,4,7};
		
		System.out.println("number of min card picked up = " + minCardPickUp(cards));

	}
	
	public static int minCardPickUp(int[] cards) {
		
		int minCount = cards.length + 1;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < cards.length; i++) {
			
			if(map.containsKey(cards[i])) {
				minCount = Math.min(minCount, i - map.get(cards[i]) + 1);
				
			}
			
			map.put(cards[i], i);
			
		}
		
		return minCount == cards.length+1 ? -1 : minCount;
	}

}
