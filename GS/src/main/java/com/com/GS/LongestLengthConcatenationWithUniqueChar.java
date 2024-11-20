package com.GS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestLengthConcatenationWithUniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s1 = {"coo", "dili","ityi"}; // 5
		String[] s2 = {"co", "dil", "ity"};
		String[] s3 = {"abc", "def", "sv"};
		String[] s4 = {"eva", "jqw", "tin", "jan"};
		System.out.println("Length s1 = " + solution(s1)); // 0
		System.out.println("Length s2 = " + solution(s2)); // 5
		System.out.println("Length s3 = " + solution(s3)); // 8
		System.out.println("Length s4 = " + solution(s4)); // 9
	}
	
	public static int solution(String[] S) {
		
		int max = 0;
		
		List<Set<Character>> list = new ArrayList<>(Arrays.asList(new HashSet<>()));
		
		for(String s : S) {
			
			Set<Character> s1 = new HashSet<>();
			
			for(char c : s.toCharArray()) {
				s1.add(c);
			}
			
			if(s1.size() < s.length()) 
				continue;
			
			for(int i = list.size()-1 ; i >= 0; i-- ) {
				
				Set<Character> s2 = new HashSet<>(list.get(i));
				
				if(!Collections.disjoint(s1, s2))
					continue;
				
				list.add(new HashSet<>(s2));
				
				list.get(list.size()-1).addAll(s1);
				
				max = Math.max(max, s1.size()+s2.size());
			}
			
		}
		
		return max;
	}

//	private static boolean valid(String s) {
//		// TODO Auto-generated method stub
//		Set<Character> set = new HashSet<>();
//		
//		for(int i = 0; i < s.length(); i++) {
//			if(set.contains(s.charAt(i))) {
//				return false;
//			}
//			set.add(s.charAt(i));
//		}
//		return true;
//	}

}
