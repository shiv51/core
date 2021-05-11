package core.problems.binarysearch;

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int[] a = {};
		int target = 0;
		int low=0,high=a.length-1;
		
		
		while(low<=high) {
			int mid = low+ (high-low)/2;
			if(a[mid] == target) {
				System.out.println("Found");
				break;
			}
			
			
		}
	}

	
}
