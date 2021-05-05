package core.probelms.tree.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import core.tree.TreeNode;

public class CountPathsForASum {
	
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
		find(one, l, 0, output, 7);
		System.out.println(output);
		
	}

	public static void find(TreeNode root, LinkedList<TreeNode> list,int count, List<List<TreeNode>> output, int expected) {
		if(root!=null) {
			count = count+root.getValue();
			list.add(root);
		}
		if(count>expected) {
			TreeNode head = list.peek();
			count = count - head.getValue();
			if(count == expected) {
				List<TreeNode> list1 = new ArrayList<TreeNode> (list);
				list1.remove(head);
				output.add(list1);
			}
		}
		else if(count == expected) {
			List<TreeNode> list1 = new ArrayList<TreeNode> (list);
			output.add(list1);
		}
		if(root!=null && root.getLeft()==null && root.getRight()==null) {
			//List<TreeNode> list1 = new ArrayList<TreeNode> (list);
			list.remove(root);
			count = count-root.getValue();
		}
		else {
			if(root.getLeft()!=null)
			find(root.getLeft(),  list,count, output,expected);
			if(root.getRight()!=null)
			find(root.getRight(), list, count, output,expected);
			list.remove(root);
			count = count - root.getValue();
		}
	}
}
