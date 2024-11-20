package com.GS.Marcus;

import java.util.HashMap;
import java.util.Map;

/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
Find the number of boomerangs. 
You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]
Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/

public class NumberOfBoomerangs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] p = {{0,0}, {1,0}, {2,0}};
		
		System.out.println("Number of Boomerangs = " + numberOfBoomerang(p));
	}
	
	public static int numberOfBoomerang(int[][] p) {
		int count = 0;
		
		for(int[] p1 : p) {
			
			Map<Integer, Integer> distanceCounter = new HashMap<>();
			
			for(int[] p2 : p) {
				
				// Calculate squared Euclidean distance to avoid floating point operations
				int distanceSquared = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
				
				distanceCounter.put(distanceSquared, distanceCounter.getOrDefault(distanceSquared, 0) + 1);
				
			}
			
			for (int v : distanceCounter.values()) {
				count += v * (v-1);
			}
			
		}
		
		return count;
	}

}
