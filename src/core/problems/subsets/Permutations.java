package core.problems.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
	
	public final static List<String> l1 = new ArrayList<String>();

	public static void main(String[] args) {
		int[] input = {1,2,3};
		Queue<List<Integer>> q = new LinkedList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		q.add(l1);
		for(Integer num:input) {
			int h = q.size();
			for(int x=0;x<h;x++) {
			List<Integer> list = q.poll();
			for(int i =0;i<=list.size();i++) {
				List<Integer> l = new ArrayList<Integer>(list);
				l.add(i,num);
				q.add(l);
				if(l.size()==3)
				{
					System.out.println(l);
				}
			}
			}
		}
		System.out.println("--------------");
		perm(input, 0, new ArrayList<Integer>());
	    
	}
	
	//DSF
	
	public static void perm(int[] nums, int index, List<Integer> list) {
		
		if(list.size() == nums.length) {
			System.out.println(list);
			list.remove(2);
			return;
		}
		
		for(int i=0;i<=list.size();i++) {
			List<Integer> ll = new ArrayList<Integer>(list);
			ll.add(i, nums[index]);
			perm(nums, index+1, ll);
			//list.remove(index);
		}
		
		
	}
	
	
	
	
}
