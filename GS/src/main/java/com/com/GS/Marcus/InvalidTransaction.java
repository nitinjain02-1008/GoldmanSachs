package com.GS.Marcus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> transaction = new ArrayList<String>(Arrays.asList("Nitin,10,500,delhi", "Nitin,80,500,blr", "Nitin,60,500,blr", "Nitin,100,1200,delhi"));
		
		InvalidTransaction t = new InvalidTransaction();
		System.out.println("Invalid transaction  are = " + t.invalidTransaction(transaction));

	}
	
	public List<String> invalidTransaction(List<String> t) {
		List<String> invalid = new ArrayList<String>();
		
		Map<String, List<Transaction>> map = new HashMap<>();
		
		for(String transaction : t) { // O(N)
			
			Transaction t1 = new Transaction(transaction);
			
			if(map.containsKey(t1.name)) {
				map.get(t1.name).add(t1);
			}else {
				List<Transaction> list = new ArrayList<InvalidTransaction.Transaction>();
				list.add(t1);
				
				map.put(t1.name, list);
			}
		}	
		
		for(String transaction : t) {
			
			Transaction t1 = new Transaction(transaction);
			
			if(!)
		}
		
		return invalid;
	}
	
	public boolean isValid(List<Transaction> t, Transaction t1 ) {
		
		
		return false;
		
	}
	
	class Transaction{
		String name;
		int time;
		int amount;
		String city;
		
		Transaction(String transaction) {
		//	super();
			String[] t = transaction.split(",");
			this.name = t[0];
			this.time = Integer.parseInt(t[1]);
			this.amount = Integer.parseInt(t[2]);
			this.city = t[3];
		}
		
		private boolean invalidAmount() {
			return this.amount > 1000;
		}
		
		private boolean invalidOtherTransaction(String city, int time) {
			return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
		}
		
		public boolean validTransaction(String city, int time) {
			return invalidAmount() || invalidOtherTransaction(city, time);
		}
		
	}

}
