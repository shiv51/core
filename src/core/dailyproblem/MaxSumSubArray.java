package core.dailyproblem;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSubArray {
	
	public static void main(String[] args) {
		//int[] a = {28883, 42091 ,25888, 24248, 37948, 19578 ,39501, 35420, 13832 ,26152 ,34898, 26215,10716 ,33808 ,36518,20097, 11915, 13392, 25414, 16325 ,12180 ,19445, 32855 ,40914 ,16364 ,34483 ,38157, 31262 ,12797, 20186 ,32203 ,10126, 28910 ,16773, 34700 ,37956, 32549, 17172, 33409, 38841 ,15882 ,14301, 26619 ,37643 ,25358 ,13599,38796, 18840 ,15853, 15927 ,28521 ,10187, 13359, 25111 ,17427, 27702, 38389 ,19699 ,31543, 26337, 12274, 41533, 19922 ,17122 ,16056, 13012 ,30104 ,36398 ,10037 ,25465 ,18839, 29615, 39037 ,22402 ,36376, 23447 ,31434 ,13266 ,31686 ,26099, 20416, 36360};
		int[] a = {-1,2};
		int low = 0;
		int high = 0;
		int sum = 0;
		int[] result = {1,2};
		int max = Integer.MIN_VALUE;
		
		while(high <a.length){
			if(a[high] < 0){
				sum = 0;
				high++;
				low = high;
			}
			else{
				sum = sum+a[high];
				if(sum>max || (sum==max && (high-low)>(result[1]-result[0]))){
					max = sum;
					result[0] = low;
					result[1] = high;
				}
				high++;
			}
			
		}
		
		
		System.out.println(result[0] +" - "+result[1]);
		List<Integer> l = new ArrayList<>();
		if(max<0)
			l.add(-1);
		else{
			
		for(int i=result[0];i<=result[1];i++){
			l.add(a[i]);
		}
		}
		System.out.println(l);
	}

}
