package core.probelms.dynamicprogramming;

public class MinimumSubsetsSumDif {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int min = Integer.MAX_VALUE;
		System.out.println(sumDiff(a,0,3,min));
		System.out.println(min);
	}

	private static boolean sumDiff(int[] a,int index,int sum, int min) {
		
		if(sum==0 && index>a.length-1){
			return true;
		}
		if(sum!=0 && index>a.length-1){
			return false;
		}
		min = Math.min(min, sum-a[index]);
		if(a[index] <= sum){
			if(sumDiff(a, index+1, sum-a[index], min)){
				return true;
			}
		}
		return sumDiff(a, index+1, sum, min);
	}
}
