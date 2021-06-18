package core.probelms.tree.traversal;

import java.util.Stack;

import core.tree.TreeNode;

public class IterativeTraversals {

	public static void inOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		while (root != null || s.size() > 0) {
			while (root != null) {
				s.push(root);
				root = root.getLeft();
			}
			TreeNode temp = s.pop();
			System.out.print(temp.getValue());
			root = temp.getRight();
		}
	}

	public static void preOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode temp = s.pop();
			System.out.print(temp.getValue());
			if (temp.getRight() != null)
				s.push(temp.getRight());
			if (temp.getLeft() != null)
				s.push(temp.getLeft());
		}
	}

	public static void postOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		while (true) {
			while (root != null) {
				s.push(root);
				s.push(root);
				root = root.getLeft();
			}
			if (s.empty())
				return;
			root = s.pop();
			if (!s.empty() && s.peek() == root)
				root = root.getRight();
			else {
				System.out.print(root.getValue());
				root=null;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setRight(six);
		System.out.println();
		System.out.println("In order =====");
		inOrder(one);
		System.out.println();
		System.out.println();
		System.out.println("pre order =====");
		preOrder(one);
		
		System.out.println();
		System.out.println();
		System.out.println("pre order =====");
		postOrder(one);
	}
}
