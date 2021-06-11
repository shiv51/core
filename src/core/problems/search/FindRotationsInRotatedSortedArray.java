package core.problems.search;

public class FindRotationsInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {5,1,2,3,4};
		
		int low = 0;
		int high = nums.length-1;
		int pivot = -1;
		while(low<=high){
			int mid  = low+(high-low)/2;
			
			if(((mid-1)>=0 && nums[mid]<nums[mid-1]) || (mid<nums.length-2 && nums[mid]>nums[mid+1])){
				pivot = mid;
				System.out.println(mid);
				break;
			}
			
			if(nums[low]<=nums[mid]){ //Sorted
					low = mid+1;
			}
			else{
					high = mid-1;
			}
			
		}
		
		if(pivot!=-1){
			swap(nums, 0, pivot);
			swap(nums, pivot+1, nums.length-1);
			swap(nums, 0, nums.length-1);
			
		}
		
		
		System.out.println(nums);
	}
	
	public static void swap(int[] a, int x, int y){
		
		while(x<y){
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
			x++;
			y--;
		}
		
	}
}
