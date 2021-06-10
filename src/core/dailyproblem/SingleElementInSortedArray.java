package core.dailyproblem;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(getUnique());
		
		
	}

	private static int getUnique() {
		int[] nums = {3,3,7,7,10,11,11};
		
		if(nums.length==0 || nums.length%2==0){
			System.out.println("Nothing found");
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int low = 0;
		int high = nums.length-1;
		
		while(low<=high){
			int mid = low+(high-low)/2;
			
			if(mid==nums.length-1 && nums[mid]!=nums[mid-1]){
				return nums[mid];
			}
			else if(mid==0 && nums[mid]!=nums[mid+1]){
				return nums[mid];
			}
			
			if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
				return nums[mid];
			}
			
			else if(nums[mid] == nums[mid-1]){
				if((mid)%2==0){
					high=mid-1;
				}
				else{
					low=mid+1;
				}
			}
			else if(nums[mid] ==  nums[mid+1]){
				if(((nums.length-1)-mid)%2==0){
					low=mid+1;
				}
				else{
					high=mid-1;
				}
			}
			
		}
		return 0;
	}
}
