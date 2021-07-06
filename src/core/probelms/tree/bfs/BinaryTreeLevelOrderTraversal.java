package core.probelms.tree.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import core.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.setLeft(two);
		one.setRight(three);
		traverse(one);
	}
	
	public static void traverse(TreeNode head) {
		Queue<TreeNode> q = new ConcurrentLinkedQueue<TreeNode>();
		q.add(head);
		int repeat=1;
		while(!q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = q.size();
			System.out.println(size);
			for(int i=0;i<repeat;i++) {
				TreeNode temp = q.poll();
				list.add(temp.getValue());
				TreeNode left = temp.getLeft();
				TreeNode right = temp.getRight();
				if(left!=null)
					q.add(left);
				if(right!=null)
					q.add(right);
			}
			System.out.println(list.stream().
				       map(Object::toString).
				       collect(Collectors.joining(",")).toString());
			repeat=repeat*2;
		}
		
	}
}
