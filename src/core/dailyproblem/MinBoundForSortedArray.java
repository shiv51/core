package core.dailyproblem;

public class MinBoundForSortedArray {

	public static void main(String[] args) {
		//int[] a = {3, 7, 5, 6, 9};
		int[] a = {2,6,4,8,10,9,15};
		//int[] a  = {2,1};
		
		findSubarray(a);
		int start = a.length;
		int end = 0;
		
		int low = 0;
		int high = 1;
		boolean notFound= true;
		if(a.length==1)
			System.out.println(0);
		
		while(low<=high && high <= a.length-1){
			
			if(low == high){
				high++;
				continue;
			}
			if(a[low]<a[high]){
				low++;
			}
			else{
				notFound = false;
				start = Math.min(low, start);
				end = Math.max(end, high);
				high++;
			}
		}
		if(notFound)
			System.out.println(0);
		else {
			System.out.println(start+end-1);
		}
		
	}
	
	 public static void findSubarray(int[] A)
	    {
	        int leftIndex = -1, rightIndex = -1;
	 
	        // traverse from left to right and keep track of maximum so far
	        int max_so_far = Integer.MIN_VALUE;
	        for (int i = 0; i < A.length; i++)
	        {
	            if (max_so_far < A[i]) {
	                max_so_far = A[i];
	            }
	 
	            // find the last position that is less than the maximum so far
	            if (A[i] < max_so_far) {
	                rightIndex = i;
	            }
	        }
	 
	        // traverse from right to left and keep track of the minimum so far
	        int min_so_far = Integer.MAX_VALUE;
	        for (int i = A.length - 1; i >= 0; i--)
	        {
	            if (min_so_far > A[i]) {
	                min_so_far = A[i];
	            }
	 
	            // find the last position that is more than the minimum so far
	            if (A[i] > min_so_far) {
	                leftIndex = i;
	            }
	        }
	 
	        System.out.print("Sort array from index " + leftIndex
	                        + " to " + rightIndex);
	    }
}
