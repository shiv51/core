package core.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubString {

	//Given a string, find the length of the longest substring in it with no more than K distinct characters.
	public static void main(String[] args) {
		int k=2;
		String s = "aaarciiiiiiiiiiiaaaadddddddddsssssssssssssssssssssssssssssssssssss";
		char[] ar= s.toCharArray();
		int maxLength = 0;
		char[] temparr = new char[ar.length];
		int removalIndex = 0;
		List<Integer> maxs = new ArrayList<Integer>();
		int topV = 0;
		for(int i=0;i<ar.length;i++) {
			temparr[i] = ar[i];
			System.out.println(new String(temparr)+" - "+removalIndex +" unique size is  = "+getLengthOfDistinct(temparr,removalIndex));
			if(getLengthOfDistinct(temparr,removalIndex)<=k) {
				maxLength++;
				System.out.println("Increase length to "+maxLength);
				if(i==ar.length-1) {
					maxs.add(maxLength);
					if(topV==0) {
						topV = maxLength;
					}
					else if(topV<maxLength) {
						topV = maxLength;
					}
				}
			}
			else {
				maxs.add(maxLength);
				if(topV==0) {
					topV = maxLength;
				}
				else if(topV<maxLength) {
					topV = maxLength;
				}
				removalIndex++;
				System.out.println("In else block when array is "+new String(temparr));
				System.out.println(new String(temparr)+" - "+removalIndex +" unique size is  = "+getLengthOfDistinct(temparr,removalIndex));
				while(getLengthOfDistinct(temparr,removalIndex)>k) {
					System.out.println(" increased removal to - "+removalIndex +" unique size is  = "+getLengthOfDistinct(temparr,removalIndex));
					removalIndex++;
				}
				System.out.println("exiting else block with removalIndex = "+removalIndex);
				maxLength=i-removalIndex+1;
			}
			
		}
		System.out.println("Maximum length = "+topV);
		System.out.println(maxs);
	}
	
	
	public static int findLength(String str, int k) {
		String s = str;
		char[] ar= s.toCharArray();
		int maxLength = 0;
		char[] temparr = new char[ar.length];
		int removalIndex = 0;
		List<Integer> maxs = new ArrayList<Integer>();
		int topV = 0;
		for(int i=0;i<ar.length;i++) {
			temparr[i] = ar[i];
			if(getLengthOfDistinct(temparr,removalIndex)<=k) {
				maxLength++;
				if(i==ar.length-1) {
					maxs.add(maxLength);
					if(topV==0) {
						topV = maxLength;
					}
					else if(topV<maxLength) {
						topV = maxLength;
					}
				}
			}
			else {
				maxs.add(maxLength);
				if(topV==0) {
					topV = maxLength;
				}
				else if(topV<maxLength) {
					topV = maxLength;
				}
				removalIndex++;
				while(getLengthOfDistinct(temparr,removalIndex)>k) {
					removalIndex++;
				}
				maxLength=i-removalIndex+1;
			}
			
		}
	      return topV;
	  }
	
	public static int getLengthOfDistinct(char[] input, int start) {

		String inputSting = new String(input);
		String str = inputSting.substring(start);
		Set<String> set = new HashSet<String>();
		for(char c:str.trim().toCharArray()) {
			String ci = Character.toString(c);
			set.add(ci);
		}
		return set.size();
		
	}
}
