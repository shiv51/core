package core.dailyproblem;

import java.util.Stack;

public class NextGraterElement {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,3};
		nextGrater(a);
		System.out.println();
	}
	public static int[] nextGrater(int[] nums){
		  	int n = nums.length;
	        
	        Stack<Integer> max = new Stack<>();
	        
	        //traverse from back and push in stack so that we can check in reverse order
	        for(int i=n-1 ; i >= 0 ; i--) max.push(nums[i]);
	    
	        int ans[] = new int[nums.length];
	        
	        int i=n-1;
	        
	        //Traverse From back
	        while(i >= 0){
	            
	            //Is stack is empty..ans is -1 and push the current element
	            if(max.isEmpty()) {
	                max.push(nums[i]);
	                ans[i] = -1;
	                i--;
	            }
	            else{
	                //Pop the element out of the stack if it is >= curr
	                if(max.peek() <= nums[i]) max.pop();
	                else{
	                    
	                    //store the ans and push the curr element in the stack
	                    ans[i] = max.peek();
	                    max.push(nums[i]);
	                    i--;
	                }
	            }
	        }
	        
	        return ans;
	}
}
