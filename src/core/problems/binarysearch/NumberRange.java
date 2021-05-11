package core.problems.binarysearch;

public class NumberRange {

	public static void main(String[] args) {
		char[] input = {'e','e','e','e','e','e','e', 'n', 'n','n','n'};
		char target = 'e';
		int index = extracted(input, target);
		System.out.println(index);
		System.out.println(input[index]);
		
	}

	private static int extracted(char[] input, char target) {
		
		int low=0,high=input.length-1,mid=0;
		int index = 0;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(input[mid] == target) {
				index = (mid==input.length-1)?0:(mid+1);
				if(input[index]==target) {
					low = mid+1;
					continue;
				}
					
				return index;
			}
			else if(target>input[mid] ) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		if(low>input.length-1) {
			return 0;
		}
		if(input[low]<=target)
			return (low==input.length-1)?0:(low+1);
		return low;
	}
}
