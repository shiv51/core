package core.problems.tree.dfs;

import core.tree.TreeNode;

public class TreeDiameter_edu {
	
	private static int treeDiameter = 0;

	private static int calculateHeight(TreeNode currentNode) {
	    if (currentNode == null)
	      return 0;

	    int leftTreeHeight = calculateHeight(currentNode.getLeft());
	    int rightTreeHeight = calculateHeight(currentNode.getRight());

	    // if the current node doesn't have a left or right subtree, we can't have
	    // a path passing through it, since we need a leaf node on each side
	    if (leftTreeHeight != 0 && rightTreeHeight != 0) {

	      // diameter at the current node will be equal to the height of left subtree +
	      // the height of right sub-trees + '1' for the current node
	      int diameter = leftTreeHeight + rightTreeHeight + 1;

	      // update the global tree diameter
	      treeDiameter = Math.max(treeDiameter, diameter);
	    }

	    // height of the current node will be equal to the maximum of the heights of
	    // left or right subtrees plus '1' for the current node
	    return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	  }
	
	public static int findDiameter(TreeNode root) {
	    calculateHeight(root);
	    return treeDiameter;
	  }
	
	
}
