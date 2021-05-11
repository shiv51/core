package core.problems.binarysearch;

public class BitonicArraySearch {

	public static void main(String[] args) {
		int[] a = {10,9,8};
		int k = 8;
		int low = 0, high =a.length-1;
		int x = search(a,k,low,high);
		if(x>=0)
			System.out.println("Found at - "+x+" - "+a[x]);
		else
			System.out.println("Not found");
	}

	private static int  search(int[] a, int k, int low , int high) {
		
		
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(a[mid] == k) {
				return mid;
			}
			if(k>a[mid]) {
				if((mid+1<=(a.length-1 )) && a[mid+1]>a[mid]) {
					low= mid+1;
				}
				else {
					high = mid-1;
				}
			}
			else {
				
				if(mid>1 && a[mid-1]<a[mid]) {
					int x = search(a, k,low,mid-1);
					return x;
				}
				if((mid+1<=(a.length-1 )) && a[mid+1]>a[mid]) {
					high = mid-1;
					
				}
				else {
					low= mid+1;
				}
			}

		}
		
		return -1;
		
	}
}