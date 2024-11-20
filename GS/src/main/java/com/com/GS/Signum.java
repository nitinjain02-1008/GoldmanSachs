package com.GS;

public class Signum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {1,0,-3,-5};
		
		System.out.println("Signum = " + solution(A));
	}

	static int solution(int[] A) {
		
		boolean flag = true;
		for(int n : A) {
			if(n == 0)
				return 0;
			if(n < 0) {
				flag = !flag;
			}
		}
		
		return flag ? 1 : -1 ;
	}
}
