import java.util.Stack;

public class BinaryTree {

	public void preOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.println(root.getValue());
		if(root.getLeft()!=null) {
			preOrder(root.getLeft());
		}
		if(root.getRight()!=null) {
			preOrder(root.getRight());
		}
	}
	
	public void iterativePreorder(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		
		while(!s.empty()) {
			TreeNode node = s.pop();
			System.out.println(node.value);
			
			if(node.getRight()!=null)
				s.push(node.getRight());
			if(node.getLeft()!=null)
				s.push(node.getLeft());
		}
		
	}
	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		
		t1.setLeft(t2);
		t1.setRight(t3);
		
		t2.setLeft(t4);
		t2.setRight(t5);
		
		t3.setRight(t6);
		new BinaryTree().preOrder(t1);
		System.out.println("-----");
		new BinaryTree().iterativePreorder(t1);
		
	}
}
