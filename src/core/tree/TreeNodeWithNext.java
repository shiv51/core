package core.tree;

public class TreeNodeWithNext {

	int value;
	TreeNodeWithNext left;
	TreeNodeWithNext right;
	TreeNodeWithNext next;

	public TreeNodeWithNext(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNodeWithNext getLeft() {
		return left;
	}

	public void setLeft(TreeNodeWithNext left) {
		this.left = left;
	}

	public TreeNodeWithNext getRight() {
		return right;
	}

	public void setRight(TreeNodeWithNext right) {
		this.right = right;
	}

	public TreeNodeWithNext getNext() {
		return next;
	}

	public void setNext(TreeNodeWithNext next) {
		this.next = next;
	}

	
}
