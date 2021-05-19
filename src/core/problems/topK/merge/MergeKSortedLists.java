package core.problems.topK.merge;

import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		int[] x= {2, 6, 8};
		int[] y= {3, 6, 7};
		int[] z= {1,3,4};
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i:x) {
			q.add(i);
		}
		for(int i:y) {
			q.add(i);
		}
		for(int i:z) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
	}
}
