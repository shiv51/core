package core.problems.cyclicsort;

import java.util.Arrays;

public class FindMissingSmallerNumber {

public static void main(String[] args) {
		
		int[] input = {-3, 1, 5, 4, 2};
		int i=0;
		while(i<input.length) {
			if((i+1)==input[i] || input[i]<=0 || input[i] >=input.length) {
				i++;
			}
			else {
				swap(input, i, input[i]-1);
			}
		}
		System.out.println(Arrays.toString(input));
		for(int j=0;j<input.length;j++) {
			if(input[j]!=(j+1)) {
				System.out.println("Missing postive number is " +(j+1));
				break;
			}
		}
	}
	
	public static int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
}
