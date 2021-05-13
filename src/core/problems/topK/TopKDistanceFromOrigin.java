package core.problems.topK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKDistanceFromOrigin {

	
	public static void main(String[] args) {
		PriorityQueue<poin> pq = new PriorityQueue<poin>((p1,p2) -> p1.getDistance()-p2.getDistance());
		List<int[]> l = new ArrayList<int[]>();
		int n=1;
		for(int[] a: l) {
			double distance = Math.sqrt((a[0]*a[0])+(a[1]*a[0]));
			if(pq.size()<=n-1) {
				pq.add(new poin(n, n));
			}
			else if(distance>pq.peek().getDistance()) {
				pq.poll();
				pq.add(new poin(a[0],a[1]));
			}
		}
		System.out.println(pq.peek());
		
		
	}
}
class poin{
	
	int x;
	int y;

	public poin(int x, int y){
		x=x;
		y=y;
	}
	int getDistance(){
		return (x*x)+(y*y);
	}
}
