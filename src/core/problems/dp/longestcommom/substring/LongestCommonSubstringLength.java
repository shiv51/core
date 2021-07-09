package core.problems.dp.longestcommom.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubstringLength {

	public static void main(String[] args) {
		int[] nums1 = {70,39,25,40,7};
		int[] nums2 ={52,20,67,5,31};
		System.out.println(findLength(nums1,nums2));
	}

	private static int findLength(int[] nums1, int[] nums2) {
		Map<Integer, List<Integer>> indexMap = new HashMap<>();
		for(int i = 0;i<nums1.length;i++){
			List<Integer> l = new ArrayList<>();
			if(indexMap.containsKey(nums1[i])){
				indexMap.get(nums1[i]).add(i);
			}
			else{
				l.add(i);
				indexMap.put(nums1[i], l);
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums2.length;i++){
			if(indexMap.containsKey(nums2[i])){
				List<Integer> l = indexMap.get(nums2[i]);
				for(Integer j:l){
					int temp = j;
					for(int k = i;k<nums2.length && temp<nums1.length;k++){
						if(nums1[temp] == nums2[k]){
							temp++;
						}
						else{
							break;
						}
					}
					max = Math.max(max, temp-j);
				}
			}
		}
		return max<=0?0:max;
	}
}
