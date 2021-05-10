package core.problems.binarysearch;

public class OrderAgnosticBinarySearch {

	public static void main(String[] args) {
		int[] input = {5,4,3,2,1};
		int mid = input.length/2;
		int low = 0;
		int high = input.length-1;
		int t = 3;
		 boolean found = false;
		 boolean asc = true;
		 if(input[0]>input[1]) {
			 asc = false;
		 }
		
		while(low<=high && (high-low)>1) {
			if(input[high] == t || input[low] == t) {
				System.out.println("Found");
				found = true;
				break;
			}
			
			if(input[mid]==t) {
				System.out.println("Found");
				found = true;
				break;
			}
			else if(asc && t>input[mid]){
				low = mid;
				mid = (high+low)/2;
			}
			else {
				high= mid;
				mid = (high+low)/2;
			}
		}
		if(!found)
			System.out.println("Nope!");
		
		
	}
}
