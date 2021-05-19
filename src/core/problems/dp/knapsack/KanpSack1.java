package core.problems.dp.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KanpSack1 {

	public static void main(String[] args) {
		KanpSack1 ks = new KanpSack1();
	    int[] profits = {4, 5, 3, 7};
	    int[] weights = {2, 3, 1, 4 };
	    int capacity = 5;
	    int maxProfit = ks.solveKnapsack(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = ks.solveKnapsack(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	}

	private int solveKnapsack(int[] profits, int[] weights, int K) {
		PriorityQueue<Item> pq = new PriorityQueue<Item>((i1,i2) -> i2.getProfit()-i1.getProfit());
		List<Item> l = null;
		l.sort((i1,i2) -> i2.getProfit()-i1.getProfit());
		for(int i=0;i<=profits.length-1;i++) {
			pq.add(new Item(profits[i], weights[i]));
		}
		
		
		return K;
		
	}
}
class Item{
	int profit;
	int weight;
	public Item(int profit, int weight) {
		super();
		this.profit = profit;
		this.weight = weight;
	}

	public int getProfit() {
		return profit;
	}
}
