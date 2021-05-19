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
}
