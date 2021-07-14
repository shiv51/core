package core.problems.tree.dfs;

import java.util.ArrayList;
import java.util.List;

import core.tree.TreeNode;

public class SumOfPathNumbers {

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
		List<List<TreeNode>> output = new ArrayList<List<TreeNode>>();
		sumOfPathNumbers(one,l,output);
		System.out.println(output);
		int total1 = 0;
		for (List<TreeNode> i : output) { 
			int total = 0;
			for (TreeNode j : i) { 
				total = 10*total + j.getValue();
			}
		    total1 = total+total1;
		}
		System.out.println(total1);
		//System.out.println(ll);
		
	}
	
	public static List<List<TreeNode>> sumOfPathNumbers(TreeNode root, List<TreeNode> list, List<List<TreeNode>> output) {
		
		if(root!=null && root.getLeft()==null & root.getRight()==null) {
			list.add(root);
			output.add(new ArrayList<TreeNode>(list));
			list.remove(root);
		}
		else {
			list.add(root);
			if(root.getLeft()!=null)
			sumOfPathNumbers(root.getLeft(), list, output);
			if(root.getRight()!=null)
			sumOfPathNumbers(root.getRight(), list, output);
			list.remove(root);
		}
		return output;
	}
}
