package core.problems.subsets;

import java.util.ArrayList;
import java.util.List;

public class PermutationChangingCase {

	public static void main(String[] args) {
		String s = "c";
		List<String> strs = new ArrayList<String>();
		strs.add(s);
		perm(s, 0, s.length(),strs );
		
		System.out.println(strs);
	}
	
	
	public static void perm(String input, int n, int max,List<String> strs) {
		
		if(n==max) {
			return;
		}
		for(int i = n; i< input.length(); i++) {
			char[] x = input.toCharArray();
			if (Character.isAlphabetic(x[i])) {
				x[i] = Character.isUpperCase(x[i]) ? Character.toLowerCase(x[i]) : Character.toUpperCase(x[i]);
				strs.add(new String(x));
				System.out.println(new String(x));
				perm(new String(x), i+1, max,strs);
			}
			
		}
	}
}
