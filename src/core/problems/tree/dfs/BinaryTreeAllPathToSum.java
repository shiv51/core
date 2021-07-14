package core.problems.tree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import core.tree.TreeNode;

public class BinaryTreeAllPathToSum {
	
	private static List<List<TreeNode>> ll = new ArrayList<List<TreeNode>>();
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
		three.setRight(four);
		List<TreeNode> l = new ArrayList<TreeNode>();
		System.out.println();
		sum1(one,8,l);
		List<List<TreeNode>> output = new ArrayList<List<TreeNode>>();
		System.out.println(output);
		System.out.println(ll);
		
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
	
	public static void sum1(TreeNode root, int sum, List<TreeNode> list) {
		if(root == null)
			return;
		if(root.getValue() == sum && root.getLeft()==null && root.getRight()==null) {
			 List<TreeNode> add = new ArrayList<TreeNode>(list);
			 add.add(root);
			 ll.add(add);
		}
		else if(root.getLeft()==null && root.getRight()==null) {
		}
		else {
			list.add(root);
			sum1(root.getRight(),sum-root.getValue(),list);
			sum1(root.getLeft(),sum-root.getValue(),list);
			list.remove(root);
		}
		
		
	}
	
	public static void sum1(TreeNode root, int sum, List<TreeNode> list,List<List<TreeNode>> output) {
		if(root == null)
			return ;
		if(root.getValue() == sum && root.getLeft()==null && root.getRight()==null) {
			 List<TreeNode> add = new ArrayList<TreeNode>(list);
			 add.add(root);
			 output.add(add);
		}
		else if(root.getLeft()==null && root.getRight()==null) {
			//return;
		}
		else {
			list.add(root);
			sum1(root.getRight(),sum-root.getValue(),list);
			sum1(root.getLeft(),sum-root.getValue(),list);
			list.remove(root);
		}
	}
}
