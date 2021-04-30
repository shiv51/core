package core.probelms.tree.dfs;

import java.util.Stack;

import core.tree.TreeNode;

public class BinaryTreePathSum {
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		System.out.println(sum1(one,41));
	}

	public static void sum(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			int h = s.size();
			for(int i=0;i<h;i++) {
				TreeNode temp = s.pop();
				System.out.println(temp.getValue());
				if(temp.getRight()!=null)
					s.push(temp.getRight());
				if(temp.getLeft()!=null)
					s.push(temp.getLeft());
				
			}
		}
	}
	
	public static boolean sum1(TreeNode root, int sum) {
		
		
		if(root.getValue() == sum) {
			return true;
		}
		else if(root.getLeft()==null && root.getRight()==null) {
			return false;
		}
		else {
			return sum1(root.getRight(),sum-root.getValue()) || sum1(root.getLeft(),sum-root.getValue());
			
		}
		
		
	}
}
