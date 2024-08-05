package main.java.com.puzzles;

/**
 * You are an avid rock collector who lives in southern California. Some rare and desirable rocks just became
 * available in New York, so you are planning a cross-country road trip. There are several other rare rocks that you
 * could pick up along the way.
 * 
 * You have been given a grid filled with numbers, representing the number of rare rocks available in various cities across
 * the country. Your objective is to find the optimal path from So_Cal to New_York that would allow you to accumulate the most rocks
 * along the way.
 * 
 * Note: You can only travel either north (up) or east (right).
 * 
 * Example: 
 * 
 * { {0,0,0,0,5}, (New York)
 *   {0,1,1,1,0},
 *   {2,0,0,0,0}  (So_Cal)
 *   }
 *   
 * So total for the optimal path here would be: 2 + 0 + 1 + 1 + 1 + 0 + 5 = 10
 * 
 *
 */

public class OptimalPath {

	public static void main(String[] args) {
			int[][] grid = {	{0,0,0,0,5},
								{0,1,1,1,0},
								{2,0,0,0,0}
			 				};	
			
			System.out.println("max Rock = " + calculateOptimalPath(grid));
	}
	
	// T.C. O(m*n) where m = no or rows and n = no of columns
	public static int calculateOptimalPath(int[][] grid) {
		
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
		
		return maxRocks;
	}

}
