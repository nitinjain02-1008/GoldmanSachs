package main.java.com.puzzles;

import java.util.PriorityQueue;

public class IPO {

	/* You are given n projects where the ith project has a pure profit profits[i] 
	 * and a minimum capital of capital[i] is needed to start it.
	 * Initially, you have w capital. When you finish a project, 
	 * you will obtain its pure profit and the profit will be added to your total capital.
	 * Pick a list of at most k distinct projects from given projects to maximize your final capital, 
	 * and return the final maximized capital.
	 * 
	 * The answer is guaranteed to fit in a 32-bit signed integer.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		int c = 0;
		int[] profits = {1,2,3,4};
		int[] capitals = {0,1,2,3};
		
		System.out.println("Profit = " + findMaxCapital(k, c, profits, capitals));
	}
	
	static int findMaxCapital(int k, int c, int[] profits, int[] capital) {
		int n = capital.length;
		
		PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
		PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a,b) -> b - a);
		
		for(int i = 0; i < n; i++) { //O(N)
			minCapitalHeap.offer(new int[] {capital[i],profits[i]}); // O(logN)
		}

		while(k-- > 0) { // O(K)
			
			while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= c) {
				maxProfitHeap.offer(minCapitalHeap.poll()[1]); // O(logN)
			}
			c += maxProfitHeap.poll();
		}		
		return c;
	}
}
