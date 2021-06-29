package core.dailyproblem;

public class Collections1 {

	public static void main(String[] args) {
		int[] a  = {1,3,8,10};
		int start = 0;
		int end = a.length-1;
		int target = 12;
		int mid = 12;
		while(start<=end){
			mid = start+(end-start)/2;
			if(a[mid] == target){
				System.out.println("Found");
				break;
			}
			else if(a[mid]<target){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		System.out.println(start);
	}
}
