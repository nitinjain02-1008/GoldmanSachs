package com.GS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionTraversal {

	public static void main(String[] args) {
		
		List<String> countriesList = Arrays.asList("India", "US", "UK", "Russia", "France", "China");
		
		List<String> countryList = List.of("India", "US", "UK", "Russia", "France", "China");
		
		System.out.println("1. Using traditional loop ");
		
		for(int i = 0 ; i < countriesList.size(); i++) {
			System.out.println("Country = " + countriesList.get(i));
		}
		
		System.out.println("\n 2. Using For Each Loop");
		
		for (String country : countryList) {
			System.out.println("country = " + country);
		}
		
		System.out.println("\n 3. Using Iterator ");
		
		Iterator<String> itr = countriesList.iterator();
		
		while(itr.hasNext()) {
			String country = itr.next();
			System.out.println("country = " + country);
		}
		
		System.out.println("\n 4. Using List Iterator");
		
		ListIterator<String> listItr = countriesList.listIterator();
		while(listItr.hasNext()) {
			String country = listItr.next();
			System.out.println("county = " + country);
		}
		
		System.out.println("\n 5. Using Lambda Syntax of Java 8");
		
		countriesList.stream().forEach(c -> System.out.println("Country = " + c));
		
		System.out.println("\n 6. Using Method Reference of Java 8");
		
		countriesList.forEach(System.out :: println);
	}

}
