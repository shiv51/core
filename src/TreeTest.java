import java.util.ArrayList;
import java.util.List;

public class TreeTest {

	//Provided root node of a tree, iterate over the tree and print all pathways from root to the leaves.
	
	public void printPathways(Node root) {
		List<List<String>> output = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		printPathways_impl(root, list, output);
		System.out.println(output.toString());
		
	}
	
	public void printPathways_impl(Node root, List<String> list, List<List<String>> output ) {
		list.add(root.data);
		
		if(root.left==null && root.right==null) {
			output.add(new ArrayList<String>(list));
		}
		
		if(root.left !=null) {
			printPathways_impl(root.left, list, output);
			
		}
		if(root.right !=null) {
			printPathways_impl(root.right, list, output);
			
		}
		
		list.remove(root.data);
		
		
	}

	
	
	public static void main(String[] args) {
		
	}
//    A
//  /    \
//B      C
//  \   /    \
//  D E     F
}

class Node {
    String data;
    Node left, right;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}

    