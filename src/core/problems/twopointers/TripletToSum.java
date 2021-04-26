package core.problems.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletToSum {

	public static void main(String[] args) {
		int[] a = {-1,0,1,2,-1,-4};
		new TripletToSum().threeSum1(a);
	}
	
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
			
			int sum = 0;
			Arrays.sort(nums);
			int zeroPos = 0;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]==0) {
					zeroPos = i;
					break;
				}
				
			}
			
			for(int i=0;i<nums.length;i++) {
				int rem = sum-nums[i];
				int x = zeroPos,y=zeroPos+1;
				while(y>=x && x>=0 && y<=nums.length-1) {
					int temp = nums[x]+nums[y];
					if(rem==temp) {
						List<Integer> tempList = new ArrayList<Integer>();
						tempList.add(nums[i]);
						tempList.add(nums[x]);
						tempList.add(nums[y]);
	                    if(!list.contains(tempList))
	                    	list.add(tempList);
						break;
					}
					else if(temp>rem) {
						x--;
					}
					else {
						if(y==nums.length-1) {
							x++;
						}else
							y++;
							
					}
				}
				
			}
			System.out.println(list);
		return list;
	    }
	 
	 
	 public List<List<Integer>> threeSum1(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
			
			int sum = 0;
			int target = 5;
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int i=0;i<nums.length;i++) {
				map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
				
			}
			for(int i=0;i<nums.length;i++) {
				int j=0;
				int rem = sum-nums[i];
				while(j<nums.length-1) {
					
					
					
					
					if(i!=j && map.containsKey(rem-nums[j])) {
						if(rem-nums[j]==nums[j]) {
							if(map.getOrDefault(nums[j], 0)>1) {
								List<Integer> tempList = new ArrayList<Integer>();
								tempList.add(nums[i]);
								tempList.add(nums[j]);
								tempList.add(rem-nums[j]);
								if(!list.contains(tempList))
			                    	list.add(tempList);
							}
							else {
								j++;
								continue;
							}
							
						}
						else {
							List<Integer> tempList = new ArrayList<Integer>();
							tempList.add(nums[i]);
							tempList.add(nums[j]);
							tempList.add(rem-nums[j]);
							if(!list.contains(tempList))
		                    	list.add(tempList);
						}
						
					}
					j++;
				}
				
			}
			System.out.println(list);
		return list;
	    }
	 
	 public List<List<Integer>> threeSumClosest(int[] nums, int targetSum) {
	        List<List<Integer>> list = new ArrayList<>();
			
			int sum = 0;
			int target = 5;
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int i=0;i<nums.length;i++) {
				map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
				
			}
			for(int i=0;i<nums.length;i++) {
				int j=0;
				int rem = sum-nums[i];
				while(j<nums.length-1) {
					
					
					
					
					if(i!=j && map.containsKey(rem-nums[j])) {
						if(rem-nums[j]==nums[j]) {
							if(map.getOrDefault(nums[j], 0)>1) {
								List<Integer> tempList = new ArrayList<Integer>();
								tempList.add(nums[i]);
								tempList.add(nums[j]);
								tempList.add(rem-nums[j]);
								if(!list.contains(tempList))
			                    	list.add(tempList);
							}
							else {
								j++;
								continue;
							}
							
						}
						else {
							List<Integer> tempList = new ArrayList<Integer>();
							tempList.add(nums[i]);
							tempList.add(nums[j]);
							tempList.add(rem-nums[j]);
							if(!list.contains(tempList))
		                    	list.add(tempList);
						}
						
					}
					j++;
				}
				
			}
			System.out.println(list);
		return list;
	    }
	
}
