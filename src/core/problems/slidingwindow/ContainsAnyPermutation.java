package core.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsAnyPermutation {
	
	public static void main(String[] args) {
		System.out.println(findPermutation("oidbcaf", "abc"));
	}

	 public static boolean findPermutation(String str, String pattern) {
		    
		 	Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
		 	List<Integer> list = new ArrayList<Integer>();
		 	for(int i=0;i<pattern.length();i++) {
		 		patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i),0)+1);
		 	}
		 	
		 	Map<Character, Integer> map = new HashMap<Character, Integer>();
		 	int j=0;
		 	for(int i=0;i<str.length();i++) {
		 		map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
		 		if(pattern.length()==(i-j)+1){
		 			if(patternMap.equals(map)) {
		 				list.add(j);
		 				
		 			}
		 			map.put(str.charAt(j), map.getOrDefault(str.charAt(j),0)-1);
		 			if(map.get(str.charAt(j))==0) {
		 				map.remove(str.charAt(j));
		 			}
		 			j++;
		 		}
		 		
		 	}
		    
		    return false;
	}
	 
}
