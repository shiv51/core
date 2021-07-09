package core.problems.dp.longestcommom.substring;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		int[] a = {-4,10,3,7,15};
		System.out.println(dp(a));
	}
	
	public static int find(int[] a , int i, int count, int max){
		if(i>=a.length){
			return count;
		}
		if(max<a[i]){
			System.out.println(a[i]);
			max = a[i];
			count++;
		}
			int count1 =  find(a, i+1, count,max);
			int count2 =  find(a, i+2, count,max);
			
		return Math.max(count1, count2);
	}
	
	public static int find1(int[] a, int cur, int prev){
		if(cur == a.length){
			return 0;
		}
		int c1=0;
		if(prev==-1 || a[cur]>a[prev]){
			c1= 1+find1(a, cur+1, cur);
		}
		int c2 = find1(a, cur+1, prev);
		return Math.max(c1, c2);
	}
	
	public static int dp(int[] a){
		//{1,3,6,7,9,4,10,5,6};
		int maxLength = Integer.MIN_VALUE;
		int[] cache = new int[a.length];
		for(int i=0;i<a.length;i++){
			cache[i] =1;
		}
		for(int i=0;i<a.length;i++){
			for(int k = 0; k<i;k++){
				if(a[k]<a[i]){
					cache[i] = Math.max(cache[i], cache[k]+1);
				}
				maxLength = Math.max(maxLength, cache[i]);
			}
		}
		
		return maxLength;
	}
}
