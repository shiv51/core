package core.problems.tree.BST;

import java.util.Queue;

import core.tree.TreeNode;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		TreeNode root = convert(a, 0, a.length-1);
		print(root);
		isBalance(root);

	}

	public static TreeNode convert(int[] a, int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high-low) / 2;
		TreeNode root = new TreeNode(a[mid]);
		root.left = convert(a, low, mid - 1);
		root.right = convert(a, mid + 1, high);
		return root;
	}
	
	
	public static void print(TreeNode root) {
		if(root==null)
			return;
		print(root.getLeft());
		System.out.println(root.getValue());
		print(root.getRight());
		
	}
	
	
	public static void isBalance(TreeNode root) {
		Integer x = -1;
		Integer y = 0;
		int count=0;
		Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			count++;
			for(int i =0;i<q.size();i++) {
				TreeNode temp = q.poll();
				if(temp.getLeft()==null && temp.getRight()==null) {
					x =(x==-1)?count:x;
					y = Math.max(count, y);
					if((x-y)>1) {
						System.out.println("Un balanced");
						break;
					}
				}
				q.add(temp.getLeft());
				q.add(temp.getRight());
			}
			
		}
		
		System.out.println("Its a balanced one");
	}
}
