package core.dailyproblem;

import java.util.HashSet;
import java.util.Set;

public class RectangleOverlap {

	public static void main(String[] args) {
		int[] rec1= {7,8,13,15};
		int[] rec2 = {10,8,12,20};
		overlap();
		/*int minX = Math.min(rec2[0],rec2[2]);
		int minY = Math.min(rec2[1], rec2[3]);
		int maxX = Math.max(rec2[0],rec2[2]);
		int maxY = Math.max(rec2[1], rec2[3]);
		int[][] vertices= {{rec1[0],rec1[1]},{rec1[2],rec1[3]},{rec1[0],rec1[3]},{rec1[2],rec1[1]}};
		boolean found = false;
		for(int i=0;i<4;i++){
			if(vertices[i][0]>minX && vertices[i][0]<maxX && vertices[i][1]>minY && vertices[i][1]<maxY){
				found = true;
				break;
			}
			else if ( ){
				
			}
		}
		if(found)
			System.out.println("Found");
		else
			System.out.println("Not found");*/
	}
	
	public static void overlap(){
		int[] rec1= {0,0,1,1};
		int[] rec2 = {1,0,2,1};
		
		Set<String> m = new HashSet<>();
		for(int i = Math.min(rec1[1],rec1[3]);i<=Math.max(rec1[1],rec1[3]);i++){
			for(int j = Math.min(rec1[0],rec1[2]);j<=Math.max(rec1[0],rec1[2]);j++){
				m.add(j+"-"+i);
			}
		}
		boolean found = false;
		for(int i = Math.min(rec2[1],rec2[3]);i<=Math.max(rec2[1],rec2[3]);i++){
			for(int j = Math.min(rec2[0],rec2[2]);j<=Math.max(rec2[0],rec2[2]);j++){
				if(m.contains(j+"-"+i)){
					found = true;
					break;
				}
				if(found)
					break;
				
			}
		}
		
		if(found)
			System.out.println("Overlap");
		else
			System.out.println("No overlap");
		
	}
}

