package core.problems.merge.intervals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MergeIntervals_test {

	public static void main(String[] args) {
		List<int[]> l = new ArrayList<>();
		List<int[]> l1 = new ArrayList<>();
		l.sort((a,b)->a[0]-b[0]);
		int end = -1;
		int start = -1;
		int[] a= {2,3};
		int[] b= {10,11};
		int[] c= {5,9};
		
		l.add(a);
		l.add(b);
		l.add(c);
		l.sort((x,y)->x[0]-y[0]);
		
		for(int i=0;i<l.size();i++){
			if(end ==-1){
				end = l.get(i)[1];
				start = l.get(i)[0];
			}
			if(i==l.size()-1){
				int[] a1 = {start,end};
				l1.add(a1);
				break;
			}
			if(end>=l.get(i+1)[0]){
				end = Math.max(end, l.get(i+1)[1]); 
				start = Math.min(start, l.get(i+1)[0]);
			}
			else{
				int[] a1 = {start,end};
				l1.add(a1);
				start = l.get(i+1)[0];
				end =  l.get(i+1)[1];
			}
		}
		System.out.println(l1);
		
	}
}
class meeting{
	
	int start;
	int end;
	
}