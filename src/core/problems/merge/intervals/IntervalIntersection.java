package core.problems.merge.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

	public static void main(String[] args) {
		Integer[] a= {1,3};
		Integer[] b= {5,6};
		Integer[] c= {7,9};
		
		//Integer[] x= {6,7};
		Integer[] y= {2,3};
		Integer[] z= {5,7};
		
		
		List<Integer[]> list1 = new ArrayList<Integer[]>();
		list1.add(a);
		list1.add(b);
		list1.add(c);
		
		List<Integer[]> list2 = new ArrayList<Integer[]>();
		//list2.add(x);
		list2.add(y);
		list2.add(z);
		
		
		for(Integer[] j:list1) {
			for(Integer[] k:list2) {
				if((j[0]>=k[0] && j[0]<=k[1]) || (j[1]>=k[0] && j[1]<=k[1])) {
					int s = j[0]>k[0]?j[0]:k[0];
					int h = j[1]<k[1]?j[1]:k[1];
					System.out.println(s+" - "+h);
					break;
				}
			}
		}
	}
}
