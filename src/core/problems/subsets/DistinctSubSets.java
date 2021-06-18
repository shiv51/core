package core.problems.subsets;

import java.util.ArrayList;
import java.util.List;

import sun.security.util.ArrayUtil;

public class DistinctSubSets {

	public static void main(String[] args) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		int[] input = {1,2,3};
		for(int i=0;i<input.length;i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int j=i;j<input.length;j++) {
				list.add(input[j]);
				ll.add(new ArrayList<Integer>(list));
			}
		}
		
		System.out.println(ll);
		System.out.println(findSubsets(input));
		System.out.println("--------------");
		getSubsets(input);
	}
	
	public static List<List<Integer>> findSubsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    // start by adding the empty subset
	    subsets.add(new ArrayList<>());
	    for (int currentNumber : nums) {
	      // we will take all existing subsets and insert the current number in them to create new subsets
	      int n = subsets.size();
	      for (int i = 0; i < n; i++) {
	        // create a new subset from the existing subset and insert the current element to it
	        List<Integer> set = new ArrayList<>(subsets.get(i));
	        set.add(currentNumber);
	        subsets.add(set);
	      }
	    }
	    return subsets;
	  }
	
	public static List<List<Integer>> getSubsets(int[] nums){
		
		List<List<Integer>> sets = new ArrayList<>();
		List<Integer> x = new ArrayList<>();
		sets.add(x);
		for(int i=0;i<nums.length;i++){
			int n = sets.size();
			for(int j = 0;j<n;j++){
				List<Integer> l = new ArrayList<>(sets.get(j));
				l.add(nums[i]);
				sets.add(l);
			}
			
		}
		System.out.println(sets);
		return null;
		
	}
}
