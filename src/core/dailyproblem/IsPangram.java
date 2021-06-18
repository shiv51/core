package core.dailyproblem;

public class IsPangram {

	public static void main(String[] args) {
		System.out.println(find("thequickbrownfoxjumpsoverthelazydog"));
		System.out.println((int)('z'-97));
	}
	
	public static boolean find(String s){
		int[] a = new int[26];
		if(s.length()<26){
			return false;
		}
		for(int i = 0;i<s.length();i++){
			a[(int)(s.charAt(i)-97)]++;
		}
		
		for(int i = 0;i<a.length;i++){
			if(a[i]==0){
				return false;
			}
		}
		return false;
	}
}
