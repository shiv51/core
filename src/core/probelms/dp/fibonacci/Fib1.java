package core.probelms.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fib1 {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println(fib(7,map));
	}

	private static int fib(int i, Map<Integer, Integer> map) {
		if(map.containsKey(i)){
			return map.get(i);
		}
		if(i==1){
			return 0;
		}
		if(i==2){
			return 1;
		}
		int val = fib(i-1,map)+fib(i-2,map);
		map.put(i, val);
		return val;
	}
	
	
}

