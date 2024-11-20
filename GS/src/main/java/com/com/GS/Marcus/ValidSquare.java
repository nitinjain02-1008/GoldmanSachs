package com.GS.Marcus;

public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {0,0};
		int[] p2 = {1,0};
		int[] p3 = {0,1};
		int[] p4 = {1,1};	
		
		
		System.out.println("Point are valid square = " + isValidSquare(p1, p2, p3, p4));
	}
	
	public static boolean isValidSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		
		return isRightAngle(p1, p2, p3) && isRightAngle(p4, p2, p3) && isRightAngle(p1, p4, p3) && isRightAngle(p1, p2, p4);
	}
	
	public static boolean isRightAngle(int[] p1, int[] p2, int[] p3) {
		
		int d1 = distance(p1, p2);
		int d2 = distance(p2, p3);
		int d3 = distance(p3, p1);
		
		return (d1 == d2 && d1+d2 == d3 && d1 > 0) || (d1 == d3 && d1+d3 == d2 && d1 > 0) || (d3 == d2 && d3+d2 == d1 && d3 > 0);
	}
	
	public static int distance(int[] p1, int[]p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}

}
