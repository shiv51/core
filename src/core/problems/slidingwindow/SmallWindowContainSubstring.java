package core.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallWindowContainSubstring {


	 public static boolean findPermutation(String str, String pattern) {
		    
		 	Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
		 	for(int i=0;i<pattern.length();i++) {
		 		patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i),0)+1);
		 	}
		 	
		 	Map<Character, Integer> map = new HashMap<Character, Integer>();
		 	int j=0;
		 	int matched=0;
		 	int min = 0;
		 	for(int i=0;i<str.length();i++) {
		 		map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
		 	
				if(patternMap.containsKey(str.charAt(i))) {
		 			matched++;
		 		}
				
				
		 		while(matched>=pattern.length()) {
			 			if(patternMap.containsKey(str.charAt(j))) {
			 				matched--;
			 			}
			 			System.out.println(str.substring(j, i));
			 			j++;
			 			min = Math.min(min, i-j+1);
		 		}
		 		

		 	}
		    
		    return false;
	}
	 
	 public static void main(String[] args) {
		 System.out.println(findPermutation("abcde", "abc"));
	}
}
