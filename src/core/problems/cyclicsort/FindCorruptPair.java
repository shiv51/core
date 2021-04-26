package core.problems.cyclicsort;

import java.util.Arrays;

public class FindCorruptPair {

	public static void main(String[] args) {
		
		int[] input = {3, 1, 2, 3, 6, 4};
		int i=0;
		while(i<input.length) {
			if((i+1)==input[i]) {
				i++;
			}
			else {
				swap(input, i, input[i]-1);
				if((i+1)>input[i]) {
					System.out.println("FOund");
					break;
				}
			}
		}
		System.out.println(Arrays.toString(input));
	}
	
	public static int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
}
