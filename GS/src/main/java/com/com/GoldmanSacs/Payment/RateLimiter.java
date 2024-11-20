package com.GoldmanSacs.Payment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {

	public int REQUEST_LIMIT = 100;
	
	public Long TIME_LIMIT = 1000L;
	
	public HashMap<String, HitCounter> clientTimestamp = new HashMap<>();
	
	public class HitCounter{
		
		public Queue<Long> queue;
		
		public String api;
		
		public HitCounter() {
			queue = new LinkedList<>();
		}
		
		public boolean hit(Long timestamp) {
			
			while(!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) {
				queue.poll();
			}
			
			if(queue.size() < REQUEST_LIMIT) {
				queue.add(timestamp);
				return true;
			}
			return false;
		}
	}	
	
	public boolean isAllow(String clientId) {
		long currTime = System.currentTimeMillis();
		
		if(!clientTimestamp.containsKey(clientId)) {
			HitCounter h = new HitCounter();
			h.hit(currTime);
			return true;
		}else {
			HitCounter h = clientTimestamp.get(clientId);
			return h.hit(currTime);
		}
			
	}

	
	//	public static void main(String[] args) {
//		
//
//	}

}
