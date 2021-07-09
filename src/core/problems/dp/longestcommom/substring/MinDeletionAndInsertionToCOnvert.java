package core.problems.dp.longestcommom.substring;

import java.util.Arrays;

public class MinDeletionAndInsertionToCOnvert {

	public static void main(String[] args) {
		String s1 = "abdca";
		String s2 = "cbda";
		int[][] a = new int [s1.length()][s2.length()]; 
		for(int i=0;i<s1.length();i++){
			for(int j = 0;j<s2.length();j++){
				if(s1.charAt(i) == s2.charAt(j)){
					a[i][j] =1;
				}
			}
		}
		int low=0;
		int high=0;
		while(low<s1.length()&& high<s2.length()){
			if(a[low][high]==1){
				low++;
				high++;
			}
		}
		for(int i =0;i<a.length;i++){
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
