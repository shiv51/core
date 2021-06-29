package core.probelms.dynamicprogramming;

public class KnapSack01 {

	public static void main(String[] args) {
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	   // System.out.println(solveKnapsack(profits, weights, 7, 0, 0,0,0));
	    bottomUp();
	}
	
	public static int solveKnapsack(int[] profits, int[] weights,int capacity, int output, int ow, int i,int y){
		if(i>profits.length-1){
			return output;
		}
		if(ow>capacity){
			return output;
		}
		int p1 = 0;
		if(ow+weights[i]<=capacity){
			 p1 = solveKnapsack(profits, weights, capacity, output+ profits[i], ow+weights[i],i+1,y);
		}
		int p2 = 0;
		if(ow<=capacity){
			 p2 = solveKnapsack(profits, weights, capacity, output,ow, i+1,y);
			
		}
		y = Math.max(p1, p2);
		return y;
	}
	
	public static void bottomUp(){
		int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int capacity = 7;
	    int[][] a = new int[profits.length][capacity+1];
	    for(int i=0;i<profits.length;i++){
	    	a[i][0] = 0;
	    }
	    
	    print(a);
	    
	    System.out.println("starts");
	    for(int i=0;i<profits.length;i++){
	    	for(int j=1;j<capacity+1;j++){
	    		
	    		/* if(weights[i] <= j)
	    	          profit1 = profits[i] + dp[i-1][c-weights[i]];
	    	        // exclude the item
	    	        profit2 = dp[i-1][c];
	    	        // take maximum
	    	        dp[i][c] = Math.max(profit1, profit2);*/
	    	        
	    	        
	    		
	    		if(i>0 && j<weights[i]){
	    			a[i][j] = a[i-1][j];
	    		}
	    		else if(i>0 && j>weights[i]){
	    			a[i][j] = profits[i]+a[i-1][capacity-weights[i]];
	    		}
	    		else if(j==weights[i]){
	    			a[i][j] = profits[i];
	    		}
	    		else{
	    			a[i][j] = a[i][j-1];
	    		}
	    		
	    		print(a);
	    	}
	    }
	    
	    print(a);
		
	}

	private static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) { //this equals to the row in our matrix.
	         for (int j = 0; j < a[i].length; j++) { //this equals to the column in each row.
	            System.out.print(a[i][j] + " ");
	         }
	         System.out.println(); //change line on console as row comes to end in the matrix.
	      }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
