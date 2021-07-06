package core.probelms.dp.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class MinimumJumps {

	public static void main(String[] args) {
		int[] a = {2,1,1,1,4};
		List<Integer> l = new ArrayList<>();
		jump(a, 0, 0,l);
		System.out.println(l);
	}
	
	public static void jump(int[] a, int index, int count,List<Integer> list){
		if(index>=a.length-1){
			list.add(count);
			return;
		}
		/*if(a[index]==0){
			index--;
			if(prev==1)
				count--;
			else
				count++;
		}
		else{
			count++;
		}*/
		int j = 0;
		for(int i= index;i<=index+a[index];i++){
			if(index==a.length-1){
				continue;
			}
			i = i+1;
			j = count+1;
			System.out.println("Now calling with [index = "+i+", count = "+j+" ]");
			jump(a, i, j,list);
		}
	}
}
