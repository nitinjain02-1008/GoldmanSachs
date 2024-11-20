package com.GS;

public class LexicographicallySmallestStringByRemoveOneChar {
	
	public static void main(String[] args) {
		System.out.println(solution("hot"));
		System.out.println(solution("abc"));
		System.out.println(solution("aaaa"));
		System.out.println(solution("codility"));
		
		System.out.println("s1 = " + solution1("abc"));
	}
	
	public static String solution1(String S) { // O(n-1) + O(n) = O(n)
		
		String s = "";
		
		int index = -1;
		
		for(int i = 0; i < S.length()-1; i++) { // T.C = O(n-1)
			if(S.charAt(i) > S.charAt(i+1)) {
				index = i;
				break;
			}
		}
		
		if(index < 0) {
			return S.substring(0, S.length()-1);
		}else {
			for(int i = 0 ; i < S.length(); i++) { // O(n)
				if(i!=index)
					s += S.charAt(i);
			}
		}
		return s;
	}
	
	public static String solution(String S) {
     // Implement your solution here

     String s = "";
     StringBuilder sb = new StringBuilder();

     for(int i =0; i< S.length()-1; i++){
      
   // 	 System.out.println("S.charAt(i) = " + (int)S.charAt(i) + " S.charAt(i+1) = " + (int)S.charAt(i+1));
         
         char c1 = S.charAt(i);
         char c2 = S.charAt(i+1);
         
 //        System.out.println("c1 = " + c1 + " c2 = " + c2);
   //      System.out.println("Character.compare(S.charAt(i), S.charAt(i+1)) = " + Character.compare(c1, c2));
         
     //    if(Character.compare(S.charAt(i), S.charAt(i+1))>0){
        	 if(c1 > c2) {
     //        System.out.println("true");    
             for(int j =0; j<S.length(); j++){
                 if(i != j){
                     s += S.charAt(j);
                     sb.append(S.charAt(j));
                 }
             }
             return s;
         }
     //    System.out.println("string = " + s + " Sb = " + sb.toString());
         
     }        
     return S.substring(0, S.length()-1);
 }
}
