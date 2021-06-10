package core.dailyproblem;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = { 0,1,0,2,1,0,1,3,2,1,2,1};
		
		if(height.length==0 || height.length==1){
			System.out.println(0);
		}
		int capacity = 0;
		int i = 1;
		int maxLeft = height[0];
		int maxRighIndex = height.length-1;
		while (height.length>0 && i < height.length) {
			if (i == 1 || i >= maxRighIndex) {
				maxRighIndex = getMaxRight(height, i);
			}
			int c = Math.min(height[maxRighIndex], maxLeft) - height[i];
			capacity = capacity+ (c>0?c:0);
			if (height[i] > maxLeft) {
				maxLeft = height[i];
			}
			i++;
		}
	}

	private static int getMaxRight(int[] height, int i) {
		int maxRighIndex;
		maxRighIndex = height.length-1;
		for (int j = height.length - 1; j > i; j--) {
			if (height[j] > height[maxRighIndex]) {
				maxRighIndex = j;
			}
		}
		return maxRighIndex;
	}
}
