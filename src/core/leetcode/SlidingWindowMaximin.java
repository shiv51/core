package core.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMaximin {

	public static void main(String[] args) {
		int k=1;
		int[] nums = {1};

		exec(k, nums);
	}

	private static void exec(int k, int[] nums) {
		int start = 0;
		int end = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>((a1,a2)->a2-a1);
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> l = new ArrayList<>();
		while(end<nums.length){
			q.add(nums[end]);
			map.put(nums[end], end);
			if(q.isEmpty() || q.peek()<=nums[end]){
				q.clear();
				map.clear();
				q.add(nums[end]);
				map.put(nums[end], end);
			}
			if(end-start==(k-1)){
				if(map.get(q.peek())<=start){
					int val = q.poll();
					l.add(val);
					map.remove(val);
				}
				else{
					l.add(q.peek());
				}
				while(map!=null && !q.isEmpty()&& map.containsKey(q.peek()) && map.get(q.peek())<start){
					int val = q.poll();
					map.remove(val);
				}
				start++;
			}
			end++;
		}
		int[] output = new int[l.size()];
		for(int i=0;i<l.size();i++){
			output[i]=l.get(i);
		}
		System.out.println(Arrays.toString(output));
	}
	
	
	private static void exec1(int k, int[] nums) {
		int start = 0;
		int end = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>((a1,a2)->a2-a1);
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> l = new ArrayList<>();
		while(end<nums.length){
			q.add(nums[end]);
			map.put(nums[end], end);
			if(q.isEmpty() || q.peek()<=nums[end]){
				q.clear();
				map.clear();
				q.add(nums[end]);
				map.put(nums[end], end);
			}
			if(end-start==(k-1)){
				while(q.peek()>=start){
					
				}
				if(map.get(q.peek())==start){
					int val = q.poll();
					l.add(val);
					map.remove(val);
				}
				else{
					l.add(q.peek());
				}
				
				start++;
			}
			end++;
		}
		int[] output = new int[l.size()];
		for(int i=0;i<l.size();i++){
			output[i]=l.get(i);
		}
		System.out.println(Arrays.toString(output));
	}
	
}
