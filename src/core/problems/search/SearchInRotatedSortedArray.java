package core.problems.search;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {5,1,3};
		int target = 5;
		
		int low = 0;
		int high = nums.length-1;
		while(low<=high){
			int mid  = low+(high-low)/2;
			
			if(nums[mid] == target){
				System.out.println(mid);
				break;
			}
			
			if(nums[low]<=nums[mid]){ //Sorted
				
				if(target>= nums[low] && target<=nums[mid]){
					high = mid-1;
				}
				else{
					low = mid+1;
				}
			}
			
			else{
				if(target>=nums[mid] && target <=nums[high] ){
					low = mid+1;
				}
				else{
					high = mid-1;
				}
			}
			
			
		}
		System.out.println("Not found");
	}
}
