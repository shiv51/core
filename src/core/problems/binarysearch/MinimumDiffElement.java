package core.problems.binarysearch;

public class MinimumDiffElement {

	public static void main(String[] args) {
		int[] input = {4, 6, 10};
		int target =12;
		int index = extracted(input, target);
		System.out.println(index);
		
	}

	private static int extracted(int[] nums, int target) {
		
		int low=0,high=nums.length-1,mid=0;
		int index = 0;
		Integer diff = null;
		while(low<=high) {
			mid = low+(high-low)/2;
			int tempDif = Math.abs(target - nums[mid]);
			
			if(diff==null || tempDif<diff) {
				diff = tempDif;
				index = mid;
			}
			
			if(nums[mid] == target) {
				return mid;
			}
			else if(target>nums[mid] ) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		return index;
	}
}
