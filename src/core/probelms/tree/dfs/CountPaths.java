package core.probelms.tree.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import core.tree.TreeNode;

public class CountPaths {

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
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		List<List<TreeNode>> output = new ArrayList<List<TreeNode>>();
		
		countPaths(one, 0, 8, l, output);
		System.out.println(output);
	}
	public static void countPaths(TreeNode root,int x, int sum,List<TreeNode> l,List<List<TreeNode>> ll){
		x = x+root.getValue();
		l.add(root);
		if(sum == x){
			List<TreeNode> l1 = new ArrayList<TreeNode>(l);
			ll.add(l1);
		}
		else{
			
			if(root.getLeft()!=null){
				countPaths(root.getLeft(), x, sum, l, ll);
			}
			if(root.getRight()!=null)
				countPaths(root.getRight(), x, sum, l, ll);
			x = x-root.getValue();
		}
		l.remove(root);
		
	}
}
