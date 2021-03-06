package core.problems.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import core.tree.TreeNode;

public class MinimumDepthOfBinaryTree {
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		find(one);
	}
	
	
	public static void find(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count=0;
		int h=1;
		while(!q.isEmpty()) {
			for(int i=0; i<h;i++) {
				TreeNode temp = q.poll();
				
				if(temp.getLeft()==null && temp.getRight()==null) {
					System.out.println("Leaf node is at - "+temp.getValue());
					System.out.println(count+1);
					return;
				}
				q.add(temp.getLeft());
				q.add(temp.getRight());
			}
			h=h*2;
			count++;
		}
	}

}
