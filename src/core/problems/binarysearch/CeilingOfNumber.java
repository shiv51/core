package core.problems.binarysearch;

public class CeilingOfNumber {

	public static void main(String[] args) {
		int[] input = {1,2,5,6,9};
		System.out.println(searchCeilingOfANumber(input, 4));
	}
	
	public static int searchCeilingOfANumber(int[] arr, int key) {
	    if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
	      return -1;

	    int start = 0, end = arr.length - 1;
	    while (start <= end) {
	      int mid = start + (end - start) / 2;
	      if (key < arr[mid]) {
	        end = mid - 1;
	      } else if (key > arr[mid]) {
	        start = mid + 1;
	      } else { // found the key
	        return mid;
	      }
	    }
	    // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
	    // we are not able to find the element in the given array, so the next big number will be arr[start]
	    return start;
	  }

	private static void sequencialSolution() {
		
		int[] input = {4, 6, 10};
		int target =-1;
		Integer diff = null;
		int index = -1;
		for(int i=0;i<input.length;i++) {
			int tempDiff= input[i]- target;
			if(tempDiff == 0) {
				index = i;
				break;
			}
			else if(tempDiff>0 && (diff ==null || tempDiff < diff)){
				index = i;
				diff = tempDiff;
			}
		}
		System.out.println(index);
		if(index>=0)
		System.out.println(input[index]);
		else
			System.out.println("Not found the element");
		
	}
}
