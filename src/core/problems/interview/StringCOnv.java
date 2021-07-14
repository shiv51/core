package core.problems.interview;

import java.util.ArrayList;
import java.util.List;

public class StringCOnv {

	public static void main(String[] args) {
		
		getString(get("AZ"));
	}
	// 28/26 = 1 , 2
	//2/26 = 
	public static int get(String s){
		char[] a = s.toCharArray();
		List<Integer> l = new ArrayList<>();
		int val = 0;
		int temp = 1;
		for(int i=0;i<a.length;i++){
			l.add(((int)a[i])-64);
		}
		//[1,2] = 2+1*26
		for(int i=l.size()-1;i>=0;i--){
			val= val+(l.get(i))*temp;
			temp = temp*26;
		}
		return val;
	}
	
	public static String getString(int val){
		StringBuilder s = new StringBuilder();
		while(val>0){
			int x = val%26;
			val = val/26;
			if(x==0){
				x=26;
				val = val-1;
			}
			s.append((char)((int)x+64));
		}
		System.out.println(s.reverse());
		return null;
	}
}
