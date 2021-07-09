package core.problems.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {

	public static void main(String[] args) {
		int[] w = {2,3,1,4};
		int[] p = {4,5,3,7};
		int c = 5;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<w.length;i++){
			map.put(w[i], p[i]);
		}
		int max = 0;
		for(java.util.Map.Entry<Integer, Integer> e:map.entrySet()){
			if(map.get(c-e.getValue())!=null)
			max= Math.max(e.getValue()+map.get(c-e.getKey()), max);
		}
		System.out.println(max);
		
		System.out.println(recursive(w, p, c, 0));
		System.out.println("Recursive TD");
		int[][] x = new int[w.length][c+1];
		
		for(int i=0;i<w.length;i++){
			for(int j=0;j<c+1;j++){
				x[i][j]=0;
			}
			
		}
		System.out.println(recursiveTD(w, p, c, 0, x));
	}
	
	public static int recursive(int[] w, int[] p,int c, int index){
		
		if(index>p.length-1 || w[index]>c  ){
			return 0;
		}
		int p1 = p[index] + recursive(w, p, c-w[index], index+1);;
		
		int p2 = recursive(w, p, c, index+1);
		int max = Math.max(p1, p2); 
		System.out.println("Max as of now = "+max+" ->p1 = "+p1+" -> p2 = "+p2);
		return max;
		
	}
	
	public static int recursiveTD(int[] w, int[] p,int c, int index,int[][] x){
		
		if(index>p.length-1 || w[index]>c  ){
			return 0;
		}
		if(x[index][c]!=0)
			return x[index][c];
		int p1 = p[index] + recursive(w, p, c-w[index], index+1);;
		
		int p2 = recursive(w, p, c, index+1);
		int max = Math.max(p1, p2); 
		System.out.println("Max as of now = "+max+" ->p1 = "+p1+" -> p2 = "+p2);
		x[index][c] = max;
		return x[index][c];
		
	}
}
