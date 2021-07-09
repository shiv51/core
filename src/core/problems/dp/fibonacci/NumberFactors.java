package core.problems.dp.fibonacci;

public class NumberFactors {
	
	public static void main(String[] args) {
		System.out.println(factors1(5));
	}

	private static int factors(int i) {
		if(i==0)
			return 1;
		if(i==1)
			return 1;
		if(i==2)
			return 1;
		if(i == 3)
		      return 2;
		int x = factors(i-1);
		int y = factors(i-3);
		int z = factors(i-4);
				return x+y+z;
	}

	private static int factors1(int n) {
		int dp[] = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=1;
		dp[3]=2;
		
		if(n<=3)
			return dp[n];
		for(int i=4;i<=n;i++){
			dp[i] = dp[i-1]+dp[i-3]+dp[i-4];
		}
		return dp[n];
	}
	
	
	
}
