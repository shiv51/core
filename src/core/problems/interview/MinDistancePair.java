package core.problems.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinDistancePair {

	public static void main(String[] args) {
		int[] a = {3,2,1,2,3};
		List<Integer> l = new ArrayList<Integer>();
		l.add(7);
		l.add(1);
		l.add(3);
		l.add(4);
		l.add(1);
		l.add(7);
		minimumDistance(l);
	}

	private static void minimumDistance(List<Integer> a) {
		Map<Integer, Integer> map = new HashMap<>();
		int output = Integer.MAX_VALUE;
		boolean flag = false;
		for(int i=0;i<a.size();i++){
			if(map.containsKey(a.get(i))){
				flag = true;
				output = Math.min(output, i-map.get(a.get(i)));
			}
			map.put(a.get(i), i);
		}
		System.out.println(output);
	}
}
