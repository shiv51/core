package core.problems.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import core.tree.TreeNodeWithNext;

/** left -> right  and last node in level should point to null
 * @author smettu
 *
 */
public class LevelOrderSiblings {
	
	public static void main(String[] args) {
		TreeNodeWithNext one = new TreeNodeWithNext(1);
		TreeNodeWithNext two = new TreeNodeWithNext(2);
		TreeNodeWithNext three = new TreeNodeWithNext(3);
		TreeNodeWithNext four = new TreeNodeWithNext(4);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		connect(one);
		System.out.println(one);
	}

	public static void connect(TreeNodeWithNext root) {
		Queue<TreeNodeWithNext> q = new LinkedList<TreeNodeWithNext>();
		q.add(root);
		int h = 1;
		while(!q.isEmpty()) {
			TreeNodeWithNext temp = null;
			TreeNodeWithNext temp2 = null;
			for(int i=0;i<h;i++) {
				temp = q.poll();
				if(temp==null)
					break;
				q.add(temp.getLeft());
				q.add(temp.getRight());
				if(temp.getLeft()!=null)
					temp.getLeft().setNext(temp.getRight());
				if(temp2!=null) {
					temp2.setNext(temp.getLeft());
				}
				temp2 = temp.getRight();
			}
			h= h*2; 
			if(temp!=null)
				temp.setNext(null);
		}
		
	}
	 
}
