package core.problems.binarysearch;

public class NextNumber {

	public static void main(String[] args) {
		int[] input = {1};
		int target =1;
		int[] index = extracted(input, target);
		System.out.println(index[0]+" , "+index[1]);
		
	}

	private static int[] extracted(int[] nums, int target) {
		
		int low=0,high=nums.length-1,mid=0;
		int index = 0;
		int[] output = {-1,-1};
		while(low<=high) {
			mid = low+(high-low)/2;
			if(nums[mid] == target) {
				
				int i=mid,j=mid;
				while((i<=nums.length-1 && nums[i] == target) || (j>=0 && nums[j]==target)) {
					if(i<=nums.length-1 && nums[i] == target) {
						output[1] = i;
						i++;
						
					}
					if(j>=0 && nums[j] == target) {
						output[0] = j;
						j--;
						
					}
				}
				
				return output;
			}
			else if(target>nums[mid] ) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		return output;
	}
}
