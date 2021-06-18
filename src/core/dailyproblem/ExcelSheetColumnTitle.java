package core.dailyproblem;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		int x = 52;
		while(x>0){
			if(x==0)
				break;
			int re = x%26;
			System.out.println(re);
			if(re == 0)
				x--;
			System.out.println((char)(re+65));
			x = x/26;
		}
	}
}
