package core.problems.binarysearch;

public class BitonicArrayMax {

	public static void main(String[] args) {
		int[] a = {10, 9, 8};
		int low = 0, high =a.length-1;
		int max = 0;
		while(low<=high) {
			int mid = low+(high-low)/2;
			max = Math.max(max, a[mid]);
			if((mid+1<=(a.length-1 )) && a[mid+1]>a[mid]) {
				low= mid+1;
			}
			else {
				high = mid-1;
			}
		}
		
		System.out.println(max);
	}
}