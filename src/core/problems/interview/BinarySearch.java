package core.problems.interview;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8};
		int target = 10;
		int low = 0;
		int high = a.length-1;
		boolean found = false;
		// log (n) -> log (n) 
		while(low<=high){
			int dif = (high-low)/3;
			int mid1 = low+dif;
			int mid2 = mid1+dif;
			
			if(a[mid1] == target){
				found = true;
				System.out.println(mid1);
				break;
			}
			if(a[mid2] == target){
				found = true;
				System.out.println(mid2);
				break;
			}
			if(target>a[low] && target <a[mid1]){
				high = mid1-1;
			}
			if(target>a[mid1] && target <a[mid2]){
				high = mid2-1;
				low = mid1+1;
			}
			else{
				low = mid2+1;
			}
			
		}
		if(!found)
			System.out.println("Not found");
	}
}
