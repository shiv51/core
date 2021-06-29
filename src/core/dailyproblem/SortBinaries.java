package core.dailyproblem;

import java.util.Arrays;

public class SortBinaries {

	public static void main(String[] args) {
		int[] a = {1,0,1,0,1,0,1,0,0,1};
		int low = 0;
		int high = a.length-1;
		
		while(low<high){
			if(a[low]==1 && a[high]==0){
				//swap theam 
				swap(a, low, high);
				low++;
				high--;
				continue;
			}
			
			if(a[low] != 1){
				low++;
			}
			if(a[high] != 0){
				high--;
			}
			
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
