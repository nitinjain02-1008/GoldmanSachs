package com.Interview.PublicisSapient;

public class LengthOfLongestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String testString1 = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + LengthOfLongestString.lengthOfLongestSubstring(testString1)); // Output: 3
        
        String testString2 = "bbbbb";
        System.out.println("Length of longest substring without repeating characters: " + LengthOfLongestString.lengthOfLongestSubstring(testString2)); // Output: 1
        

	}

	public static int lengthOfLongestSubstring(String s) {
	       // Implement logic here
		
	       int minLength = 0;
	       int i = 0;

	       for(int j = 1 ; j<=s.length()-1; j++ ){// n times TC O(n)
	            String subStr = s.substring(i, j);
	            char c = s.charAt(j);
	            
	            if(subStr.indexOf(c)>=0) {
	            	minLength = Math.max(minLength, subStr.length());
	            	i = j;
	            	
	            }
	            
	       }
	       
	       return minLength;
	    }
}
