package core.problems.tree.dfs;

import java.util.ArrayList;
import java.util.List;

import core.tree.TreeNode;

public class PathWithGivenSequnce {

	public static boolean find(TreeNode root, List<Integer> list, List<Integer> output) {
		
		if(root!=null && root.getLeft()==null && root.getRight()==null) {
			list.add(root.getValue());
			if(list.containsAll(output)) {
				return true;
			}
			else {
				list.remove(new Integer(root.getValue()));
			}
		}
		else {
			list.add(root.getValue());
			boolean x = false , y = false;
			if(root.getLeft()!=null)
				 x = find(root.getLeft(), list, output) ;
			if(root.getRight()!=null)
				 y =  find(root.getRight(), list, output);
			list.remove(new Integer(root.getValue()));
			return x||y;
			
		}
		return false;
	}
	
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
		List<Integer> l = new ArrayList<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		output.add(1);
		output.add(3);
		output.add(9);
		System.out.println(find(one,l,output));
	}
}
