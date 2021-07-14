package core.problems.interview;

public class Test2 {

	public static float getFloat(String input){
	    char[] c = input.toCharArray();
	    float decimalVal = 0;
	    float val = 0;
	    int unit = 1;
	    boolean flag = false;
	    int count = 0;
	    for(int i=c.length-1;i>=0;i--){
	    	if(c[i]=='.'){
	    		if(flag)
	    			throw new NumberFormatException("More than one precision!");
		        decimalVal = (float) (val/Math.pow(10, count));
		        val = decimalVal;
		        unit =1;
		        flag = true;
		        continue;
		    }
	    	else if(c[i]<'0' || c[i]>'9'){
		    		throw new NumberFormatException("Un parsable character found!");
	    	}
	    	count++;
	        val = val+(((int)c[i]-48)*unit);
	        unit = unit*10;
	       
	    }
	        return val;
	}
	public static void main(String[] args) {
		System.out.println(getFloat("3.2"));
	}

}
