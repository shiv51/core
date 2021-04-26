package core.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithReplace0 {

	public static void main(String[] args) {
		int[] a = {0,1,1,1,0,0};
		int k=2;
		Map<Integer, Integer> map  = new HashMap<Integer, Integer>();
		int j=0;
		int max=0;
		for(int i=0;i<a.length;i++) {
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
			while(map.entrySet().size()==2 && (map.get(0)>k)) {
				map.put(a[j], map.get(a[j])-1);
				if( map.get(a[j])==0) {
					map.remove(a[j]);
				}
				j++;
			}
			max = Math.max(max, i-j+1);
		}
		System.out.println(max);
	}
}
