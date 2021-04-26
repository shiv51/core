package core.problems.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TripletWithSmallerSum {

	public static void main(String[] args) {
		int target = 0;
		int[] a  = {-3, 0, 1, 2, -1, 1, -2};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int x:a) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		int count = 0;
		
		for(int i=0;i<=a.length-1;i++) {
			int x = a[i];
			int tempTarget = target-x;
			map.put(x, map.getOrDefault(x, -1)-1);
			if(map.get(x)==0) {
				map.remove(x);
			}
			count = pairToEqualSum(a,tempTarget,map,count,i);
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		System.out.println(count); 
	}
	
	
	private static void triplesWithSum() {
		int[] a  = {1,3,4,1,5,0};
		Arrays.sort(a);
		for(int i=0;i<a.length-1;i++) {
			
		}
		
		
	}

	private static int pairToEqualSum(int[] a,int target,Map<Integer, Integer> map, int count , int k) {
		for(int i=0;i<=a.length-1;i++) {
			
			if(i==k)
				continue;
			map.put(a[i], map.getOrDefault(a[i], -1)-1);
			if(map.get(a[i])==0) {
				map.remove(a[i]);
			}
			if(map.containsKey(target-a[i])) {
				count++;
				System.out.println("["+a[k]+","+a[i]+","+(target-a[i])+"]");
			}
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
		}
		return count;
	}
}
