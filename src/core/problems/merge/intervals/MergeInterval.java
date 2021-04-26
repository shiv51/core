package core.problems.merge.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		Integer[] a= {6,7};
		Integer[] b= {2,4};
		Integer[] c= {5,9};
		
		List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(a);
		list.add(b);
		list.add(c);
		
		list.sort(Comparator.comparingInt(arr -> arr[0]));
		
		int start=-1;
		int end= -1;
		for(Integer[] input:list) {
			if(start==-1) {
				start = input[0];
				end = input[1];
			}
			else if(end>input[0]) {
					end = end>input[1]?end:input[1];
			}
			else {
				System.out.println(start+" - "+end);
				start = input[0];
				end = input[1];
			}
		}
		System.out.println(start+" - "+end);
	}
}
