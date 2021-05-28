package core.probelms.tree.BST;

import core.tree.TreeNode;

public class IsBST {
	
	public static TreeNode prev = null;
	
	public static void main(String[] args) {
		
		
	}

	public static boolean isBst(TreeNode root) {
		
		if(root!=null) {
			if(!isBst(root.getLeft()))
				return false;
			if(prev!=null &&  prev.getValue()>=root.getValue()) {
				return false;
			}
			prev = root;
			if(!isBst(root.getRight()))
				return false;
			
		}
			return true;
	}
	
	public static boolean isBst1(TreeNode root) {
	
		if(root==null) {
			return true;
		}
		if(!isBst1(root.getLeft())) {
			return false;
			
		}
		if(prev!=null && root.getValue()<=prev.getValue()) {
			return false;
		}
		prev = root;
		if(isBst1(root.getRight())) {
			return false;
		}
		return true;
		
	
}	
}
