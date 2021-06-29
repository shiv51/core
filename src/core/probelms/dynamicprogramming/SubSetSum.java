package core.probelms.dynamicprogramming;

public class SubSetSum {

	public static void main(String[] args) {
		int[] a = {1,2,3,7};
		System.out.println(sum(a, 0, 9));
	}
	
	public static boolean sum(int[] a, int index, int sum){
		if(sum!=0 && index>a.length-1)
			return false;
		if(sum==0 && index>a.length-1)
			return true;
		if(a[index]<=sum){
			if(sum(a,index+1,sum-a[index])){
				return true;
			}
		}
		return sum(a, index+1, sum);
	}
}
