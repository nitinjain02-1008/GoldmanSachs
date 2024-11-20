package com.GS.Marcus;

import java.util.*;

/*
		There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
		
		The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
		
		The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
		
		Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
		
		Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
		
		Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
		
		Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
		[0,4]: [0,4] -> Pacific Ocean 
		       [0,4] -> Atlantic Ocean
		[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
		       [1,3] -> [1,4] -> Atlantic Ocean
		[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
		       [1,4] -> Atlantic Ocean
		[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
		       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
		[3,0]: [3,0] -> Pacific Ocean 
		       [3,0] -> [4,0] -> Atlantic Ocean
		[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
		       [3,1] -> [4,1] -> Atlantic Ocean
		[4,0]: [4,0] -> Pacific Ocean 
		       [4,0] -> Atlantic Ocean
		Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
*/

public class PacificAtlanticWaterFlow {

	private static int height;
	private static int width;
	private static int[][] heightsMatrix;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] M = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		
		System.out.println("Water flow = " + PacificAtlantic(M));
		
	}
	
	private static void bfs(Deque<int[]> queue, Set<Integer> visitedOcean) {
		
		int[] d = {-1, 0, 1, 0, -1}; // representational array for traversing neighbors
		
		while(!queue.isEmpty()) {
			
			for(int k = queue.size(); k > 0; --k) {
				int[] cell = queue.poll();
				
				for(int i = 0; i < 4; i++) {
					
					int newRow = cell[0] + d[i];
					int newCol = cell[1] + d[i + 1];
					
					if(newRow >= 0 && newCol >= 0 && newRow < height && newCol < width
						&& !visitedOcean.contains(newRow * width + newCol)
						&& heightsMatrix[newRow][newCol] >= heightsMatrix[cell[0]][cell[1]]) {
							visitedOcean.add(newRow * width + newCol);
							queue.offer(new int[] {newRow, newCol});
					}
				}
			}
		}
	}
	
	public static List<List<Integer>> PacificAtlantic(int[][] heights){
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		height = heights.length;
		width = heights[0].length;
		heightsMatrix = heights;
		
		Deque<int[]> pacificQueue = new LinkedList<int[]>();
		Deque<int[]> atlanticQueue = new LinkedList<int[]>();
		
		Set<Integer> pacificVisited = new HashSet<Integer>();
		Set<Integer> atlanticVisited = new HashSet<Integer>();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(i == 0 || j == 0) {
					pacificVisited.add(i * width + j);
					pacificQueue.offer(new int[] {i,j});
				}
				
				if(i == height - 1 || j == width - 1) {
					atlanticVisited.add(i * width + j);
					atlanticQueue.offer(new int[] {i, j});
				}
			}
		}
		
		// bfs for pacific
		bfs(pacificQueue, pacificVisited);
		// bfs for atlantic
		bfs(atlanticQueue, atlanticVisited);
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				int cellIndex = i *width + j;
				
				if(pacificVisited.contains(cellIndex) && atlanticVisited.contains(cellIndex)) {
					results.add(Arrays.asList(i, j));
				}
			}
		}
		
		return results;
	}

}

class Solution {
	
    static void dfs(int row, int col, int w, int h, int[][] M, byte[] dp, List<List<Integer>> ans) {
    	
        int cell = row * M[0].length + col;
        if ((dp[cell] & w) > 0 || M[row][col] < h) return;
        dp[cell] += w;
        h = M[row][col];
        if (dp[cell] == 3) 
        	ans.add(Arrays.asList(row,col));
        
        if (row + 1 < M.length) 
        	dfs(row+1, col, w, h, M, dp, ans);
        
        if (row > 0) 
        	dfs(row-1, col, w, h, M, dp, ans);
        
        if (col + 1 < M[0].length) 
        	dfs(row, col+1, w, h, M, dp, ans);
        
        if (col > 0) 
        	dfs(row, col-1, w, h, M, dp, ans);
    }
   
    public List<List<Integer>> pacificAtlantic(int[][] M) {
    	
        List<List<Integer>> ans = new ArrayList<>();
        if (M.length == 0) return ans;
        int rowLen = M.length, colLen = M[0].length;
        
        byte[] dp = new byte[colLen * rowLen];
        
        for (int colNo = 0; colNo < colLen; colNo++) {
            dfs(0, colNo, 1, M[0][colNo], M, dp, ans);
            dfs(rowLen-1, colNo, 2, M[rowLen-1][colNo], M, dp, ans);
        }   
        
        for (int rowNo = 0; rowNo < rowLen; rowNo++) {
            dfs(rowNo, 0, 1, M[rowNo][0], M, dp, ans);
            dfs(rowNo, colLen-1, 2, M[rowNo][colLen-1], M, dp, ans);
        }
        
        return ans;
    }
}
