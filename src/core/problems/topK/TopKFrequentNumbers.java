package core.problems.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	public static void main(String[] args) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n2.getFreq()-n1.getFreq());
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] nums = {1, 3, 5, 12, 11, 12, 11};
		int k=3;
		for(int a: nums) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		for(int a: nums) {
			pq.add(new Node(a,map.get(a)));
		}
		
		for(int i=0;i<k;i++) {
			System.out.println(pq.poll());
		}
		
	}
}

class Node{
	
	int x;
	int frequency;
	
	
	
	public Node(int x,int fre){
		this.x = x;
		frequency =fre;
	}
	
	public void incr() {
		frequency++;
	}
	
	public int getFreq() {
		return frequency;
	}
	
	public int equals(Node y) {
		return x-y.x;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + "]";
	}
	
}
