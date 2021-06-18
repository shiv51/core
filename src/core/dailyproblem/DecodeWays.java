package core.dailyproblem;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "2611055971756562";
		char[] c = s.toCharArray();
		int[] a = new int[c.length];
		for(int i=0;i<c.length;i++) {
			a[i] = Integer.valueOf(String.valueOf(c[i]));
		}
		if (a.length == 0 || (a.length == 1 && a[0] == 0))
			System.out.println(0);
		System.out.println(ways(a,a.length));
	}

	public static int ways(int[] a, int n){
		//Maintain count and recursively solve it
		int count = 0;
		
		if(a[0]==0)
			return 0;
		if(n==0 || n==1)
			return 1;
		
		if(a[n-1] > 0){
			count = count+ ways(a,n-1);
		}
		if(a[n-2] > 0 && a[n-2]<=2 && a[n-1]>=0 && a[n-1]<=6) {
			count = count+ ways(a,n-2);
		}
		return count;
		
	}
}
