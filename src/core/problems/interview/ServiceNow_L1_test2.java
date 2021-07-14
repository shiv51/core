package core.problems.interview;

import java.util.ArrayList;
import java.util.List;

public class ServiceNow_L1_test2 {

	// Given the root of a binary search tree, and an integer k, return the kth
	// smallest element in the tree
	//Input: root = [5,3,6,2,4,null,null,1], k = 3
	
		//	Output: 3
	public static int count =0;
	public static void main(String[] args) {
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode one = new TreeNode(1);
		
		five.setLeft(three);
		five.setRight(six);
		three.setLeft(two);
		three.setRight(four);
		
		two.setLeft(one);
		List<Integer> l = new ArrayList<>();
		inOrder(five, l);
		System.out.println(l);
		int k=3;
		System.out.println(l.get(k-1));
		
		inOrder(five, 3);
	}
	
	public static void inOrder(TreeNode root, List<Integer> list){
		if(root==null)
			return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}
	
	public static void inOrder(TreeNode root, int target){
		if(root==null)
			return ;
		inOrder(root.left,target);
		count++;
		if(count == target)
			System.out.println();
		System.err.println(root.val+" -> "+count);
		inOrder(root.right, target);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	
}