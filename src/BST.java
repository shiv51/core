import java.util.ArrayList;
import java.util.List;

public class BST {

	public static void main(String[] args) {
		Node1 root = null;
		List<Integer> list = new ArrayList<Integer>();
		isBST(root, list);
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)>list.get(i+1)) {
				System.out.println("Not BST");
				break;
			}
		}
	}
	
	public  static void isBST(Node1 root, List<Integer> list) {
		
		if(root==null) {
			return;
		}
		if(root.getLeft()!=null) {
			isBST(root.getLeft(), list);
		}
		
		list.add(root.getValue());
		if(root.getRight()!=null) {
			isBST(root.getRight(), list);
		}
	}
	Node1 prev;
    /* Returns true if given search tree is binary
    search tree (efficient version) */
 boolean isBST(Node1 node)
 {
     // traverse the tree in inorder fashion and
     // keep a track of previous node
     if (node != null)
     {
         if (!isBST(node.left))
             return false;

         // allows only distinct values node
         if (prev != null && node.getValue() <= prev.getValue() )
             return false;
         prev = node;
         return isBST(node.right);
     }
     return true;
 }
	
}
class Node1{
	int value;
	Node1 left;
	Node1 right;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node1 getLeft() {
		return left;
	}
	public void setLeft(Node1 left) {
		this.left = left;
	}
	public Node1 getRight() {
		return right;
	}
	public void setRight(Node1 right) {
		this.right = right;
	}
	
	
}