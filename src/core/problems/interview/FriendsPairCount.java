package core.problems.interview;

public class FriendsPairCount {

	public static void main(String[] args) {
		System.out.println(count(5));
	}
	
	public static int count(int i) {
		
		if(i<=2) {
			return i;
		}
		
		return count(i-1) + ((i-1)*count(i-2));
		
	}
}
