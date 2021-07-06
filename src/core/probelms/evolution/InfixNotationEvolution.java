package core.probelms.evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixNotationEvolution {

	public static void main(String[] args) {
		String exp = "";
		char[] a = exp.toCharArray();
		List<Character> l = new ArrayList<>();
		Stack<Integer> vals = new Stack<>();
		Stack<Character> ops = new Stack<>();
		int i=0;
		
		while(i<exp.length()){
			if(a[i] >= '0' && a[i]<='9'){
				vals.push(Integer.valueOf(a[i]));
			}
			else if (a[i] == '('){
				ops.push(a[i]);
			}
			else if(l.contains(a[i])){
				if(ops.isEmpty()){
					ops.push(a[i]);
				}
				else if(checkPrecedence(ops.peek(),a[i])){
					int valTemp = operation(ops.pop(),vals.pop(),vals.pop());
					vals.push(valTemp);
				}
			}
		}
			
	}
	
	public static int operation(char op, int val1, int val2){
		return 1;
	}
	
	public static boolean checkPrecedence(char op1, char op2){
		if(op2=='(' || op2==')'){
			return false;
		}
		if((op1 == '+' || op1 == '-' ) && (op2 == '*' || op2 == '/') ){
			return false;
		}
		return true;
	}
}
