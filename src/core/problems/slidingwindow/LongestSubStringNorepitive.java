package core.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringNorepitive {
	
	public static int find(String str){
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int j = 0;
		for(int i = 0;i<str.length();i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
			while(map.entrySet().stream().filter(e -> (e.getValue()>1)).count()>=1) {
				map.put(str.charAt(j), map.get(str.charAt(j))-1);
				j++;
				if(map.get(str.charAt(j))==0) {
					map.remove(str.charAt(j));
				}
			}
			max = Math.max(max, i-j+1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 2);
	//	System.out.println(map.entrySet().stream().filter(e -> (e.getValue()>1)).count());
		System.out.println(LongestSubStringNorepitive.find("aabcdds"));
	}

}
