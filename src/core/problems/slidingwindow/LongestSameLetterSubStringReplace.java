package core.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSameLetterSubStringReplace {

	public static void main(String[] args) {
		String s = "abbcb";
		Map<Character, Integer> map  = new HashMap<Character, Integer>();
		int j=0;
		int max=0;
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
			while(map.entrySet().size()>2 || (map.entrySet().stream().filter(prop -> (prop.getValue()>1)).count()>1 )) {
				map.put(s.charAt(j), map.get(s.charAt(j))-1);
				if( map.get(s.charAt(j))==0) {
					map.remove(s.charAt(j));
				}
				j++;
			}
			max = Math.max(max, i-j+1);
		}
		System.out.println(max);
	}
}
