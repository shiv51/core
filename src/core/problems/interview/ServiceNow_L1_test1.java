package core.problems.interview;

import java.util.HashMap;
import java.util.Map;

public class ServiceNow_L1_test1 {

	/*Given an array of integers nums and an integer target,
	 *  return indices of the two numbers such that they add up to target.
			Input: nums = [2,7,11,15], target = 9
			Output: [0,1]
			<2,0 (7,1) 11,2 15,3>
			[2]
			(9-2)
			0,1
			*/
	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		Map<Integer, Integer> map = new HashMap<>();
		int target = 9;
		//O(n)
		for(int i=0;i<a.length;i++){
			map.put(a[i], i);
		}
		//O(n)
		//2 -> 50 , 100%10 -> (hashcode, 2->1->3) 
		for(int i=0;i<a.length;i++){
			//O(1)
			if(map.containsKey(target-a[i])){
				System.out.println(i +" - "+map.get(target-a[i]));
			}
		}
	}
}
