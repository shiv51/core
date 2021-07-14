package core.problems.tree.dfs;

import java.util.ArrayList;
import java.util.List;

import core.tree.TreeNode;

public class PrintAllPathToSum_Test {

	public static void main(String[] args) {
		
	}
	
	public static void searchPath(TreeNode root, Integer sum,List<Integer> list)  {
		list.add(root.getValue());
		if(root.getValue()==sum) {
			System.out.println(new ArrayList<Integer>(list));
			return;
		}
		if(root.getLeft()!=null) {
			searchPath( root.getLeft(), sum-root.getValue(), list);
		}
		if(root.getRight()!=null) {
			searchPath( root.getRight(), sum-root.getValue(), list);
		}
		list.remove(root.getValue());
	}
	
	public static void print(TreeNode root,List<Integer> list) {
		
		if(root==null) {
			return;
		}
		if(root.getLeft()==null && root.getRight() ==null) {
			//print;
		}
		
		
	}
}
