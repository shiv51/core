package core.problems.interview;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayEqZero {

	public static void main(String[] args) {
		
		int[] a = {-1 , 1 ,-1 ,1};
 		Map<Integer, Integer> map = new HashMap<>();
		int high = 0;
		int max = Integer.MIN_VALUE;
		int sum =0;
		while(high<a.length) {
			sum = sum+a[high];
			if(map.containsKey(sum)){
				max = Math.max(max, (high - map.get(sum)));
			}
			if(sum==0){
				max = Math.max(max, high+1);
			}
			if(!map.containsKey(sum)){
				map.put(sum, high);
			}
			
			high++;
		}
		System.out.println(max);
	
	}
}
