package core.problems.dp.fibonacci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class PrintDecodeWays {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(1);
		l.add(1);
		l.add(1);
		for(int i=0;i<l.size();i++){
			if(l.get(i)==0){
				int temp = l.get(i-1);
				l.remove(i);
				l.remove(i-1);
				l.add(i-1,temp*10);
			}
		}
		Queue<List<Integer>> ll = new LinkedList<>();
		ll.add(l);
		ways(ll, 0, l);
		System.out.println(ll);
	}
	
	public static void ways(Queue<List<Integer>> lc, int index,List<Integer> l){
		System.out.println(l);
		while(!lc.isEmpty()){
			int size = lc.size();
			for(int i=0;i<size;i++) {
				List<Integer> l1 = lc.poll();
				for(int j=l1.size()-1;j>=1;j--){
					if(l1.get(j)<=6 && l1.get(j-1)>=0 && l1.get(j-1) <=2){
						List<Integer> a = new ArrayList<>();
						if(j>1)
							a.addAll(l1.subList(0, j-1));
						Integer k = (l1.get(j-1)*10) +  l1.get(j);
						a.add(k);
						if(j<l1.size()-1)
							a.addAll(l1.subList(j+1, l1.size()));
						lc.add(a);
						System.out.println(a);
					}
				}
				
			}
		}
	}
}
