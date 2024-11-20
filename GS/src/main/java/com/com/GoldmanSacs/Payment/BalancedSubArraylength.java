package com.GoldmanSacs.Payment;

import java.util.Stack;

public class BalancedSubArraylength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "()(()()(()()()())((((";//4
		//{}{}{()[](){}{}]]{}[] --4 & 6 -->6
		//{}{}{()[]()}
		// {}{}(){}(){()[]()
		// Case-1 --> )(()()(())( --8
		//	()(()()(() --> 2 & 4  & 2--> 4
		// 	(())()()))((()) --> 8 & 4 --> 8
		
		Stack<Integer> st = new Stack<>();
		st.push(-1);
//		int count =0;
		int result =0;
//		Character curly = '{';
//		Character braces = '[';
//		Character curve = '(';
		for(int i =0; i<str.length();i++) {
			char c = str.charAt(i);
			if(c == '{' || c=='[' || c=='(') {
			//	st.push(str.charAt(i));
				st.push(i);
			}
			else {
			//	System.out.println("i = " +i);
				if(st.isEmpty() || !isMatch(str, st.peek(), c) ) {
					st.push(i);
				}else {
					st.pop();
					if(st.isEmpty()) {
						st.push(i);
					}else {
						result = Math.max(result, i-st.peek());
					}
				}
			}
		}
		
		while(st.size()>1) {
			int start = st.pop();
			int end = st.pop();
			result = Math.max(result, end-start);
		}
		
		System.out.println(result);

	}
	
	private static boolean isMatch(String str, int i, char c) {
		if(i==-1) {
			return false;
		}
		char ch = str.charAt(i);
		
		return(ch == '(' && c ==')') || (ch == '{' && c =='}') || (ch == '[' && c ==']');
	}

}
