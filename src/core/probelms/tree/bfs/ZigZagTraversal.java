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
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		doIt(one);
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
	
	private static void doIt(TreeNode one) {
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(one);
		boolean flag = true;
		while(!q.isEmpty()){
			int x = q.size();
			List<TreeNode> l = new ArrayList<>();
			for(int i=0;i<x;i++){
				TreeNode temp = q.poll();
				if(flag)
					l.add(temp);
				else {
					l.add(0,temp);
				}
				if(temp.getLeft()!=null){
					q.add(temp.getLeft());
				}
				if(temp.getRight()!=null){
					q.add(temp.getRight());
				}
			}
			flag = !flag;
			System.out.println(l);
		}
	}
}
