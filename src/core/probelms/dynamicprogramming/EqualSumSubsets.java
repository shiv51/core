package core.probelms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EqualSumSubsets {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		Map<Integer, Set<List<Integer>>> map = new HashMap();
		List<Integer> l = new ArrayList<>();
		//subsets(a, 0, map, 0, l);
		System.out.println(map);
		canPartition(a);
	}

	public static void subsets(int[] a, int index, Map<Integer, Set<List<Integer>>> map, int sum, List<Integer> l1) {
		if (map.containsKey(sum)) {
			map.get(sum).add(l1);
		} else {
			Set<List<Integer>> x = new HashSet<>();
			x.add(l1);
			map.put(sum, x);
		}
		if (index > a.length - 1) {
			return;
		}
		List<Integer> l = new ArrayList<>(l1);
		l.add(a[index]);
		System.out.println(map);
		System.out.println();
		subsets(a, index + 1, map, sum + a[index], l);
		subsets(a, index + 1, map, sum, l1);
	}
	
	public static boolean subsets1(int[] a, int index, int sum) {
		if (index > a.length - 1) {
			return false;
		}
		if(a[index]<=sum){
			if(subsets1(a, index + 1, sum-a[index])){
				return true;
			}
		}
		return subsets1(a, index + 1, sum);
	
	}
	

	public static boolean canPartition(int[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];

		// if 'sum' is a an odd number, we can't have two subsets with equal sum
		if (sum % 2 != 0)
			return false;

		return canPartitionRecursive(num, sum / 2, 0);
	}

	private static boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
		// base check
		if (sum == 0)
			return true;

		if (num.length == 0 || currentIndex >= num.length)
			return false;

		// recursive call after choosing the number at the currentIndex
		// if the number at currentIndex exceeds the sum, we shouldn't process
		// this
		if (num[currentIndex] <= sum) {
			if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
				return true;
		}

		// recursive call after excluding the number at the currentIndex
		return canPartitionRecursive(num, sum, currentIndex + 1);
	}
}
