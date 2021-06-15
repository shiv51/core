package core.dailyproblem;

public class fIndNumber {

	public static void main(String[] args) {
		int[] a = {1 ,6 ,3 ,3 ,2, 11};
		System.out.println(findElement(a, a.length));
	}
	
	public static int findElement(int arr[], int n){
        int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minIndex = 0,maxIndex =0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i] >= max){
				max = arr[i];
				maxIndex =  i;
			}
			if(arr[i] <= min){
				min = arr[i];
				minIndex = i;
			}
		}
		if(minIndex>=maxIndex){
			return -1;
		}
		for(int i=(minIndex==0?1:minIndex);i<maxIndex;i++){
			boolean found = true;
			int k = 0,l = arr.length-1;
			
			while(k<i || l>i){
				if((k<i && arr[k]>arr[i]) || (l>i && arr[l]<arr[i])){
					found = false;
					break;
				}
				k++;
				l--;
			}
			
			if(found){
				return arr[i];
			}
			
		}
		return -1;
    }
}
