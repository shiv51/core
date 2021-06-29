package core.dailyproblem;

public class StringCompression {

	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c'};
		int i=0;
		int j=0;
		int count =0;
		int index=0;
		while(j<chars.length){
			if(chars[i]==chars[j]){
				count++;
				j++;
			}
			else{
				System.out.println(chars[i]+" - "+count);
				index = update(chars, count, index,i);
				i=j;
				count=0;
			}
		}
		System.out.println(chars[i]+" - "+count);
		index = update(chars, count, index,i);
		System.out.println(chars);
		System.out.println(index+1);
	}

	private static int update(char[] chars, int count, int index,int i) {
		chars[index]= chars[i];
		index++;
		if(count>1){
			String val = String.valueOf(count);
			for(int k=0;k<String.valueOf(count).length();k++){
				chars[index] = val.charAt(k);
				index++;
			}
		}
		return index;
	}
}
