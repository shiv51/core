package core.problems.topK;

import java.util.PriorityQueue;

public class TopKClosestNumbersForX {

	public static void main(String[] args) {
		PriorityQueue<Ele> pq = new PriorityQueue<Ele>((e1,e2) -> e2.getY()-e1.getY());
		int[] a= {2, 4, 5, 6, 9};
		int k =3;
		int X = 10;
		for(int i:a) {
			if(pq.size()<=k-1) {
				pq.add(new Ele(i,Math.abs(X-i)));
			}
			else {
				if(pq.peek().getY() > Math.abs(X-i)) {
					pq.poll();
					pq.add(new Ele(i,Math.abs(X-i)));
				}
			}
			
		}
		System.out.println(pq);
		
	}
}

class Ele{
	int x;
	int y;
	
	public Ele(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Ele [x=" + x + ", y=" + y + "]";
	}
}
