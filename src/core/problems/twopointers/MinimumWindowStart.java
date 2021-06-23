package core.problems.twopointers;

public class MinimumWindowStart {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		boolean found = false;
		if(a.length==1){
			System.out.println();
		}
		for(int i=0;i<a.length;i++){
			max = Math.max(max, a[i]);
			if(a[i]<max){
				found= true;
				end = Math.max(end, i);
			}
		}
		
		for(int i=a.length-1;i>=0;i--){
			min = Math.min(min, a[i]);
			if(a[i]>min){
				start = Math.min(start,i);
			}
		}
		System.out.println("start = "+start+" End = "+end+" - ");
		System.out.println(end-start+1);
	}
}
