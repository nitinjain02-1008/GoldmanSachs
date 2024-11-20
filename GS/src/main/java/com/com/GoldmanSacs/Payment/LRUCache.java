package com.GoldmanSacs.Payment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	
	int capacity ;
	
	Map<Integer, String> map = new HashMap<>();
	
	List<Integer> list = new LinkedList<>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public void put(int key, String value) {
		
		if(list.size() >= capacity) {
		//	list.removeL
		}
	}

	public static void main(String[] args) {
		

	}

}
