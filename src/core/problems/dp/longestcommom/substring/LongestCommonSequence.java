package core.problems.dp.longestcommom.substring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSequence {

	public static int loop = 0;
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		Map<String, Integer> map = new HashMap<>();
		int[] nums1 = {0,1,1,1,1};
		int[] nums2 = {1,0,1,0,1};
		dp2(s1, s2);
		System.out.println(loop);
	}

	public static void dp2(String s1, String s2){
		int[][] cache = new int[s1.length()][s2.length()];
		int maxLength = 0;
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					if(j>0 && i>0){
						cache[i][j] = cache[i-1][j-1]+1;
					}
					else{
						cache[i][j] = 1;
					}
					maxLength = Math.max(maxLength, cache[i][j]);
				}
				else{
					if(i>0 && j>0)
						cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
					else if (i==0 && j>0)
						cache[i][j] = cache[i][j-1];
					else if(j==0 && i>0)
						cache[i][j] = cache[i-1][j];
				}
			}
		}
		for(int i =0;i<cache.length;i++){
			System.out.println(Arrays.toString(cache[i]));
		}
		System.out.println(maxLength);
	}
}
