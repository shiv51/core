package core.problems.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumJumps {

	public static void main(String[] args) {
		//int[] a = { 5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		int[] a = {2,1,1};
		Queue<Integer> l = new PriorityQueue<Integer>();
		Map<Integer,Integer> map = new HashMap<>();
		int dp[] = new int[a.length];
		
		System.out.println(jump(a));
		
	   // countMinJumpsRecursive(dp, a, 0);
	    
		//jump1(a, 0, 0, l,map);
		System.out.println(map);
		System.out.println(l);
	}

	public static void jump(int[] a, int index, int count, Queue<Integer> l) {
		if (index >= a.length - 1) {
			System.out.println("Index = "+index+" and count = "+count);
			l.add(count);
		} else {
			for (int i = 1; i <=a[index]; i++) {
				count++;
				index = index + i;
				jump(a, index, count, l);
				index = index - i;
				count--;
			}
			
		}
	}
	
	public static void jump1(int[] a, int index, int count, Queue<Integer> l,Map<Integer,Integer> map) {
		System.out.println("Index = " +index);
		if (index >= a.length - 1) {
			map.put(index, count);
			l.add(count);
		} else {
			for (int i = 1; i <=a[index]; i++) {
				count++;
				index = index + i;
				jump1(a, index, count, l, map);
				index = index - i;
				count--;
			}
			System.out.println("Index = "+index+" and count = "+count);
		}
	}
	 private static int countMinJumpsRecursive(int[] dp, int[] jumps, int currentIndex) {
		    // if we have reached the last index, we don't need any more jumps
		    if( currentIndex == jumps.length - 1)
		      return 0;

		    // If an element is 0, then we cannot move through that element
		    if (jumps[currentIndex] == 0)
		      return Integer.MAX_VALUE;

		    // if we have already solved this problem, return the result
		    if(dp[currentIndex] != 0)
		      return dp[currentIndex];

		    int totalJumps = Integer.MAX_VALUE;
		    int start = currentIndex + 1;
		    int end = currentIndex + jumps[currentIndex];
		    while(start < jumps.length && start <= end) {
		      // jump one step and recurse for the remaining array
		      int minJumps = countMinJumpsRecursive(dp, jumps, start++);
		      if(minJumps != Integer.MAX_VALUE)
		        totalJumps = Math.min(totalJumps, minJumps + 1);
		    }
		    dp[currentIndex] = totalJumps;
		    return dp[currentIndex];
		  }
	 public static int jump(int[] jumps){
		 int[]  dp = new int[jumps.length];
		 for(int i=1;i<jumps.length;i++){
			 dp[i] =  Integer.MAX_VALUE;
		 }
		 dp[0] = 0;
		 for(int start = 0; start<jumps.length-1;start++){
			 for(int end = start+1;end<=start+(jumps[start]);end++){
				 dp[end] = Math.min(dp[end], dp[start]+1);
			 }
		 }
		 return dp[jumps.length-1];
	 }
	 
	
}
