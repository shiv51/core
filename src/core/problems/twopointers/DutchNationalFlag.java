package core.problems.twopointers;

import java.util.Arrays;

public class DutchNationalFlag {

	
	public static void main(String[] args) {
		int[] input = {1,2,0,1,0,1,2,1};
		int low = 0;
		int i=0;
		int high = input.length-1;
		while(low<high && i<=high) {
			if(input[i]==0) {
				swap(input, low, i);
				low++;i++;
			}
			else if(input[i]==1) {
				i++;
			}
			else {
				swap(input, i, high);
				high--;
			}
			System.out.println(Arrays.toString(input)+"i="+i+"low = "+low+"high = "+high);
		}
		System.out.println("----");
		System.out.println(Arrays.toString(input));
		
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
