package core.problems.dp.longestcommom.substring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSs {

	public static int loop = 0;
	public static void main(String[] args) {
		String s1 = "passport";
		String s2 = "ppsspt";
		Map<String, Integer> map = new HashMap<>();
		int[] nums1 = {0,1,1,1,1};
		int[] nums2 = {1,0,1,0,1};
		dp2(nums1, nums2);
		System.out.println(loop);
	}
	
	public static int find(String s1, String s2, int i, int j, int count,Map<String, Integer> map) {
		loop++;
	//	if(map.containsKey(String.valueOf(i)+String.valueOf(j))){
	//		return map.get(String.valueOf(i)+String.valueOf(j));
	//	}
		if(i==s1.length() || j==s2.length()){
			return count;
		}
		if(s1.charAt(i)==s2.charAt(j)){
			count = find(s1,s2 , i+1, j+1, count+1,map);
		}
		int count1 = find(s1, s2, i, j+1, 0,map);
		int count2 = find(s1, s2, i+1, j, 0,map);
		int max = Math.max(count, Math.max(count1, count2));
		map.put(String.valueOf(i)+String.valueOf(j), max);
		System.out.println("i - j -> ["+i+" - "+j+"] && max = "+max);
		return max;
	}
	
	public static void dp(String s1, String s2){
		int[][] cache = new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j))
					cache[i][j] = 1;
			}
		}
		int output = Integer.MIN_VALUE;
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(cache[i][j]==1){
					int tempi= i+1;
					int tempj = j+1;
					int count =1;
					while(tempi<s1.length() && tempj<s1.length()){
						if(cache[tempi][tempj]==1){
							count++;
							tempi++;
							tempj++;
						}
						else
							break;
					}
					output = Math.max(output, count);
				}
			}
		}
		System.out.println(output);
	}
	
	public static void dp1(int[] nums1, int[] nums2){
		int[][] cache = new int[nums1.length][nums2.length];
		for(int i=0;i<nums1.length;i++){
			for(int j=0;j<nums2.length;j++){
				if(nums1[i]==nums2[j])
					cache[i][j] = 1;
			}
		}
		int output = Integer.MIN_VALUE;
		for(int i=0;i<nums1.length;i++){
			for(int j=0;j<nums2.length;j++){
				if(cache[i][j]==1){
					int tempi= i+1;
					int tempj = j+1;
					int count =1;
					while(tempi<nums1.length && tempj<nums2.length){
						if(cache[tempi][tempj]==1){
							count++;
							tempi++;
							tempj++;
						}
						else
							break;
					}
					output = Math.max(output, count);
				}
			}
		}
		System.out.println(output);
	}
	
	public static void dp2(int[] nums1, int[] nums2){
		int[][] cache = new int[nums1.length][nums2.length];
		int maxLength = 0;
		for(int i=0;i<nums1.length;i++){
			for(int j=0;j<nums2.length;j++){
				if(nums1[i]==nums2[j]){
					if(j>0 && i>0){
						cache[i][j] = cache[i-1][j-1]+1;
					}
					else{
						cache[i][j] = 1;
					}
					maxLength = Math.max(maxLength, cache[i][j]);
				}
			}
		}
		for(int i =0;i<cache.length;i++){
			System.out.println(Arrays.toString(cache[i]));
		}
		System.out.println(cache[nums1.length-1][nums2.length-1]);
	}
}
