package core.probelms.dp.fibonacci;

import java.util.Arrays;

public class MinFeeRequired {

	public static void main(String[] args) {
		int[] a = {1,2,5,2,1,2};
		int[] dp = new int[a.length];
		
		for(int i=0;i<a.length;i++){
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0]=0;
		for(int i = 0; i<a.length;i++){
			for(int j=i+1;j<=i+3 && j<a.length;j++){
					dp[j] = Math.min(dp[j], a[i]+dp[i]);
			}
		}
		System.out.println(Arrays.toString(dp));
	}
}
