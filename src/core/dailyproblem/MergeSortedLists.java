package core.dailyproblem;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(5);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		l2.add(6);
		 
		int i=0;
		int j=0;
		List<Integer> l3 = new ArrayList<>();
		
		while(i<l1.size() || j<l2.size()){
			if(i>l1.size()-1 && j<l2.size()){
				l3.add(l2.get(j));
				j++;
			}
			else if(j>l2.size()-1 && i<l1.size()){
				l3.add(l1.get(i));
				i++;
			}
			else if(l1.get(i)<l2.get(j)){
				l3.add(l1.get(i));
				i++;
			}
			else{
				l3.add(l2.get(j));
				j++;
			}
		}
		System.out.println(l3);
	}
}
