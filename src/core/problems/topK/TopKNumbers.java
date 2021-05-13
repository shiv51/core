package core.problems.topK;

import java.util.PriorityQueue;

public class TopKNumbers {

	
	public static void main(String[] args) {
		int[] input = {3, 1, 5, 12, 2, 11 };
		int k = 3;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
		for(int i=0;i<=input.length-1;i++) {
			if(q.size()<=k-1) {
				q.add(input[i]);
			}
			else if(input[i]>q.peek()) {
				q.poll();
				q.add(input[i]);
			}
		}
		System.out.println(q.peek());
	}
}
