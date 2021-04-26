package core.problems.merge.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsRequired {

	public static void main(String[] args) {
		Integer[] a= {6,7};
		Integer[] b= {2,4};
		Integer[] c= {8,12};
		Integer[] d= {3,5};
		
		List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(a);
		list.add(b);
		list.add(c);
		//list.add(d);
		
		list.sort(Comparator.comparingInt(arr -> arr[0]));
		
		int n=0;
		int s = 0,h=0;
		List<Integer> ends = new ArrayList<Integer>();
		for(Integer[] input:list) {
			if(s==0) {
				ends.add(input[1]);
				n++;
			}
			else if(h>=input[0] && !(anyMeetingOver(ends,input[0]))) {
				ends.add(input[1]);
				n++;
			}
			s=input[0];
			h=input[1];
			
		}
		System.out.println("Meeting rooms required = "+n);
	}
	
	public static boolean anyMeetingOver(List<Integer> ends, int i) {
		Integer found = null;
		boolean x = false;
		for(int f:ends) {
			if(f<=i) {
				found = f;
				x=true;
			}
		}
		if(found!=null)
		ends.remove(found);
		return x;
	}
}
