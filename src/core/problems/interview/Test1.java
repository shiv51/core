package core.problems.interview;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		String s = "121";
		System.out.println(numWays(s));
	}
	
	public static List<List<Character>> subsets(char[] c){
		List<List<Character>> ll = new ArrayList<List<Character>>();
		List<Character> list = new ArrayList<>();
		ll.add(list);
		
		for(int i=0;i<c.length;i++){
			int n = ll.size();
			for(int j=0;j<n;j++){
				List<Character> l = new ArrayList<>(ll.get(j));
				l.add(c[i]);
				ll.add(l);
			}
		}
		return ll;
		
	}
	
	public int numDecodings(String s) {
	    return numWays(s);
	}

	private static int numWays(String s) {
	    if(s.length() == 0) { 
	        return 1;
	    }
	    
	    int slen = s.length();
	    int oneDigitExt = 0;
	    int twoDigitExt = 0;
	    // Take off 1 digit
	    if(Character.getNumericValue(s.charAt(slen-1)) > 0 ) {
	        oneDigitExt = numWays(s.substring(0,slen-1));
	    }
	    
	    int twoDigitSub;
	    if(s.length() >= 2) {
	        twoDigitSub = Integer.parseInt(s.substring(slen-2));
	        if(twoDigitSub >= 10 && twoDigitSub <= 26) {
	            twoDigitExt = numWays(s.substring(0,slen-2));
	        }
	    }
	    int result = oneDigitExt + twoDigitExt;
	    
	    return result;
	}
	
	
}
