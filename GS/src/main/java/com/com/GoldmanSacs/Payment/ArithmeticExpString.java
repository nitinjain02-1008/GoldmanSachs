package com.GoldmanSacs.Payment;

import java.util.Arrays;
import java.util.Stack;

public class ArithmeticExpString {

	public static void main(String[] args) {
		String str = "0 +  0 + 10.23 -		 100 ";
		
		str = str.replaceAll("\\s+", "").trim();
		
		System.out.println(str);
		
		String[] arrStr = str.split("(?<=[-+*/]|(?=[-+*/]))");
		System.out.println(Arrays.toString(arrStr));
		
		Stack<String> st = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		
		String op = "";
		Double a,b;
		double temp = 0;
		String res = "", s="";
		
		for(int i=0; i<arrStr.length; i++) {
			if(!arrStr[i].contentEquals("+") && !arrStr[i].contentEquals("-")) {
				st.push(arrStr[i]);
				if(!operators.isEmpty()) {
					while(!operators.isEmpty()) {
						op = operators.pop();
						
						switch(op) {
						case "+":
							b = Double.parseDouble(st.pop());
							a = Double.parseDouble(st.pop());
							
							temp = a+b;
							res = s+temp;
							System.out.println(res);
							st.push(res);
						
							break;
						
						case "-":
							b = Double.parseDouble(st.pop());
							a = Double.parseDouble(st.pop());
							
							temp = a-b;
							res = s+temp;
							System.out.println(res);
							st.push(res);
							
						default:
							continue;
						}
					}
				}
			}else {
				operators.push(arrStr[i]);
			//	op = arrStr[i];
			}			
		}		
		System.out.println("result = " + st.pop());
	}
}

