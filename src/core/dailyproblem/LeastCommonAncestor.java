package core.dailyproblem;

import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

import core.tree.TreeNode;

public class LeastCommonAncestor {

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
		List<Integer> output = new ArrayList<Integer>();
		List<List<TreeNode>> output1 = new ArrayList<List<TreeNode>>();
		output.add(4);
		output.add(5);
		get(one,l,output,output1);
		System.out.println(output1);
		int i=0;
		
	}
	
	public static void get(TreeNode root,List<TreeNode> list,List<Integer> input, List<List<TreeNode>> ll ){
		
		if(input.contains(root.getValue())){
			list.add(root);
			ll.add(new ArrayList<TreeNode>(list));
			list.remove(root);
			return;
		}
		list.add(root);
		if(root.getLeft()!=null){
			get(root.getLeft(), list, input,ll);
		}
		if(root.getRight()!=null){
			get(root.getRight(), list, input,ll);
		}
		list.remove(root);
		
	}
}
