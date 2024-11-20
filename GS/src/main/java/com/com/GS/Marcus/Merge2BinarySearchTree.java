package com.GS.Marcus;

import java.util.ArrayList;
import java.util.List;



public class Merge2BinarySearchTree {

/*Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 * Example 1:
	Input: root1 = [2,1,4], root2 = [1,0,3]
	Output: [0,1,1,2,3,4]
 * 
 * Example 2:
 * 
 * 	Input: root1 = [1,null,8], root2 = [8,1]
	Output: [1,1,8,8]

 * */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
		    this.left = left;
		    this.right = right;
		 }
	}
	
	public List<Integer> getAllElements(TreeNode t1, TreeNode t2){
		List<Integer> T1List = new ArrayList<Integer>();
		List<Integer> T2List = new ArrayList<Integer>();
		
		inOrderTraversal(t1, T1List);
		inOrderTraversal(t2, T2List);
		
		return mergeSortedList(T1List, T2List);
	}
	
	private void inOrderTraversal(TreeNode root, List<Integer> list) {
		
		if(root == null)
			return ;
		
		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
		
	}
	
	private List<Integer> mergeSortedList(List<Integer> l1, List<Integer> l2){
		List<Integer> m = new ArrayList<Integer>();
		
		int i = 0, j = 0;
		while(i < l1.size() && j < l2.size()) {
			if(l1.get(i) <= l2.get(j))
				m.add(l1.get(i++));
			else
				m.add(l2.get(j++));
		}
		
		while(i < l1.size())
			m.add(l1.get(i++));
		
		while(j < l2.size())
			m.add(l2.get(j++));
		
		return m;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
