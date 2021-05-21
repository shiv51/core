package core.problems.interview;

public class MaxContigiousSubArray {

	public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
        		getMax());
    }
 
    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
    
    
    public static int getMax() {
    	int[]  a = {-2, -3, 4, -10, -2, 1, 5, -3};
    	int max = 0;
    	int count = 0;
    	int output = Integer.MIN_VALUE;
    	for(int i=0;i<a.length-1;i++) {
    		count = count+a[i];
    		if(count<0) {
    			count=0;
    		}
    		output = Math.max(count, output);
    	}
    	
		return output;
    	
    }
}
