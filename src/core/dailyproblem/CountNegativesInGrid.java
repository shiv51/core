package core.dailyproblem;

public class CountNegativesInGrid {

	public static void main(String[] args) {
		int[][] a= {{4,2,-3,-1},{3,2,-1,-1}};
		int count = 0;
		for(int i=a.length-1;i>=0;i--){
			for(int j = a[0].length-1;j>=0;j--){
				if(a[i][j]<0){
					count++;
				}
				else{
					break;
				}
			}
		}
		System.out.println(count);
	}
}
