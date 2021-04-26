package core.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsAnyPermutation_edu {
	
	public static void main(String[] args) {
		System.out.println(findPermutation("oidbcxzaf", "xyz"));
	}

	 public static boolean findPermutation(String str, String pattern) {
		    
		 	Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
		 	for(int i=0;i<pattern.length();i++) {
		 		patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i),0)+1);
		 	}
		 	
		 	Map<Character, Integer> map = new HashMap<Character, Integer>();
		 	int j=0;
		 	int matched = 0;
		 	for(int i=0;i<str.length();i++) {
		 		
		 		if(patternMap.containsKey(str.charAt(i))) {
		 			matched++;
		 		}
		 		if(matched==pattern.length()) {
		 			return true;
		 		}
		 		
		 		if(pattern.length()==i-j+1) {
		 			if(patternMap.containsKey(str.charAt(j))) {
		 				matched--;
		 			}
		 			j++;
		 		}
		 		
		 	}
		    
		    return false;
	}
	 
}
