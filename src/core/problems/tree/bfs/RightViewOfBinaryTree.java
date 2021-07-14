package core.problems.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import core.tree.TreeNode;

public class RightViewOfBinaryTree {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		rightView(one);
	}
	
	public static void rightView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int h =1;
		while(!q.isEmpty()) {
			TreeNode temp = null;
			for(int i=0;i<h;i++) {
				temp = q.poll();
				if(temp==null)
					break;
				q.add(temp.getLeft());
				q.add(temp.getRight());
			}
			h=h*2;
			if(temp!=null)
				System.out.println(temp.getValue());
			
		}
	}
}
