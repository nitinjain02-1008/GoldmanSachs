package com.test.Altimetrik;

import java.util.*;

public class DicountPrice {

	/*
	 * 
	 	An e-commerce company is currently celebrating ten years in business. 
	 	They are having a sale to honor their privileged members, those who have been using their services for the past five years. 
	 	They receive the best discounts indicated by any discount tags attached to the product. 
	 	Determine the minimum cost to purchase all products listed. 
	 	As each potential price is calculated, round it to the nearest integer before adding it to the total. 
	 	Return the cost to purchase all items as an integer. 
	 	
	 	There are three types of discount tags: 
		• Type O: discounted price, the item is sold for a given price. 
		• Type 1: percentage discount, the customer is given a fixed percentage discount from the retail price. 
		• Type 2: fixed discount, the customer is given a fixed amount off from the retail price. 
		Example 
			products = [['10', 'do', 'd1'], ['15', 'EMPTY', 'EMPTY'], ['20', 'd1', 'EMPTY"]] 
			discounts = [['d0','1','27'], ['d0','0','4'],['d0','2','4'], ['d1', '2', '5']] 
		Output --> 35
	
	Explanation:

		Product 1: Minimum price is 5 (after applying discount d1).
		Product 2: No discounts, so the price is 15.
		Product 3: Minimum price is 15 (after applying discount d1).
		Total cost = 
		5 + 15 + 15 = 35
		
		The products array elements are in the form ['price', 'tag 1', 'tag 2',. , 'tag m-1']. There may be zero or more discount codes associated with a product.
		Discount tags in the products array may be 'EMPTY' which is the same as a null value. 
		The discounts array elements are in the form ['tag, 'type', 'amount'].

*/
	public static int calculatedPrice(int retailPrice, String tag, List<List<String>> discounts) {
		
		if(tag.equals("EMPTY"))
			return retailPrice;
		
		int minDiscountedPrice = retailPrice;
		
		for(List<String> d : discounts) {
			
			if(!d.get(0).equalsIgnoreCase(tag))
				continue;
			
			String type = d.get(1);
			
			switch (type) {
			case "0":
				minDiscountedPrice = Math.min(minDiscountedPrice, Integer.parseInt(d.get(2)));
				break;
			case "1":
				System.out.println(Math.floor((retailPrice * Integer.parseInt(d.get(2)))/100));
				minDiscountedPrice = Math.min(minDiscountedPrice, retailPrice - Math.round((retailPrice * Integer.parseInt(d.get(2)))/100));
				break;
			case "2" :
				minDiscountedPrice = Math.min(minDiscountedPrice, retailPrice - Integer.parseInt(d.get(2)));
				break;
			
			}
		}
		
		return minDiscountedPrice;
	}
	
	
	public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        // WRITE YOUR BRILLIANT CODE HERE
		
		int price = 0;
		
		for(List<String> p : products) {
			
			int retailPrice = Integer.parseInt(p.get(0));
			int minCalculatedPrice = retailPrice;
			
			for(int i = 1; i < p.size(); i++) {
				
				String tag = p.get(i);
				
				int calculatedPrice = calculatedPrice(retailPrice, tag, discounts);
				
//				System.out.println(" Cal price by tag for product = " + calculatedPrice);
				minCalculatedPrice = Math.min(minCalculatedPrice, calculatedPrice);
			}
//			System.out.println(" min cal Price for the product = " + minCalculatedPrice);
			price += minCalculatedPrice;
		}
        
		return price;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> products = List.of(
										List.of("10", "d0", "d1"),
										List.of("15", "EMPTY", "EMPTY"),
										List.of("20", "d1", "EMPTY")
									);
		
		List<List<String>> discounts = List.of(List.of("d0", "1", "27"), List.of("d1", "2", "5"));
		
		System.out.println("Lowest price = " + findLowestPrice(products, discounts));
		
		
	}

}
