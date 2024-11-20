package com.Interview.Problem;

public class P2_OptimalPath {

	public static void main(String[] args) {
		
		int[][] grid = {	{2,0,0,0,5},
							{0,1,1,1,0},
							{0,1,1,1,0},
							{2,0,0,0,0}
	 			 		};
		
		for(int i = grid.length-1; i >=0; i--) {
			for(int j = 0; j < grid[i].length; j++) {
			//	System.out.println("grid["+i+"]["+j+"] = " + grid[i][j]);
				if(i == grid.length-1 && j == 0)
					continue;
				if(i == grid.length-1) {
					grid[i][j] = grid[i][j] + grid[i][j-1]; 
				}else if(j == 0) {
				//	System.out.println("grid["+i+"]["+j+"] " );
					grid[i][j] = grid[i][j] + grid[i+1][j];
				}else {
					//System.out.println("grid["+i+"]["+j+"] " );
					grid[i][j] += Math.max(grid[i][j-1], grid[i+1][j]);
				}
				
		//		System.out.println("grid["+i+"]["+j+"] = " + grid[i][j]);
				
			}
		}
		
		int maxRocks = grid[0][grid[0].length-1];
		System.out.println("max Rock = " + maxRocks);
	}

}
