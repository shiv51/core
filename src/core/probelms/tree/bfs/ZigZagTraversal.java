package core.probelms.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import core.tree.TreeNode;

public class ZigZagTraversal {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.setLeft(two);
		one.setRight(three);
		traverse(one);
	}

	private static void traverse(TreeNode one) {
		Queue<TreeNode> q= new LinkedList<TreeNode>();
		q.add(one);
		int h = 1;
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		int r =0;
 		while(!q.isEmpty()) {
 			List<Integer> l= new ArrayList<Integer>();
 			Stack<Integer> s = new Stack();
 			for(int i=0;i<h;i++){
 				TreeNode temp = q.poll();
 				if(temp==null)
 					break;
 				q.add(temp.getLeft());
 				q.add(temp.getRight());
 				l.add(temp.getValue());
 				if(r%2!=0) {
 					s.push(temp.getValue());
 				}
 			}
 			h= h*2;
 			r++;
 			if(!l.isEmpty())
 				ll.add(l);
		}
 		System.out.println(ll);
	}
}
