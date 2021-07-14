package core.problems.tree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import core.tree.TreeNode;

public class TreeDiameter {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setRight(four);
		List<TreeNode> l = new ArrayList<TreeNode>();
		Map<List<TreeNode>, Integer> output = new HashMap<List<TreeNode>, Integer>();
		find(one, l, output);
		System.out.println(output);
		List<TreeNode> l1 = new ArrayList<TreeNode>();
		List<TreeNode> l2 = new ArrayList<TreeNode>();
		for(List<TreeNode> entry:output.keySet()) {
			if(l1.isEmpty()) {
				l1 = entry;
			}
			else if(l1.size() >= entry.size()) {
				l2 = l1;
				l1 = entry;
			}
			
			if(l2.isEmpty()) {
				l2 = entry;
			}
		}
		System.out.println(l1);
		System.out.println(l2);
		int index = 0;
		for(int i=0;i<(l1.size()>l2.size()?l1.size():l2.size());i++) {
			if(l1.get(i) == l2.get(i)) {
				index=i;
				continue;
			}
			else {
				break;
			}
		}
		System.out.println((l1.size()-index)+(l2.size()-index)-1);
	}
	
	
	public static void find(TreeNode root, List<TreeNode> list, Map<List<TreeNode>, Integer> map) {
		
		list.add(root);
		if(root!=null && root.getLeft()==null && root.getRight()==null) {
			ArrayList<TreeNode> key = new ArrayList<TreeNode>(list);
			map.put(key, list.size());
		}
		else {
			if(root.getLeft()!=null)
				find(root.getLeft(), list, map);
			if(root.getRight()!=null) {
				find(root.getRight(), list, map);
			}
		}
		list.remove(root);
	}
}
