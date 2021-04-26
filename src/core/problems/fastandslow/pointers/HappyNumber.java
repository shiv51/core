package core.problems.fastandslow.pointers;

public class HappyNumber {

	public static void main(String[] args) {
		int x = 23;
		int s1= x;
		int s2= x;
		
		do {
			 s1 = extracted(s1, 0);
			 s2 = extracted(extracted(s2, 0), 0);
		}while(s1!=s2);
		
		//find(x);
		//extracted(0, 20);
	}
	
	public static void find(int x) {
		int total = 0;
		total = extracted(x, total);
		if(total==0)
			System.out.println("Happy number found");
		else
			find(total);
		System.out.println(total);
	}

	public static int extracted(int x, int total) {
		while(x>0) {
			int y = x%10;
			total=total+(y*y);
			x=x/10;
		}
		return total;
	}
}
