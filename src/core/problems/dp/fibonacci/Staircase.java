package core.problems.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Staircase {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();
		System.out.println(countWays(5,map));
	}

	private static int countWays(int i,Map<Integer, Integer> map) {
		if(map.containsKey(i))
			return map.get(i);
		if(i==0)
			return 1;
		if(i==1)
			return 1;
		if(i==2)
			return 2;
		int x = countWays(i-1,map);
		int y = countWays(i-2,map);
		int z = countWays(i-3,map);
		map.put(i, x+y+z);
		System.out.println(i+" - "+(x=y+z));
		return x+y+z;
	}
}
