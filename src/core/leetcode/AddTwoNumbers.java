package core.leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4,l3);
		ListNode l1 = new ListNode(2,l4);
		
		ListNode l41 = new ListNode(4);
		ListNode l6 = new ListNode(6,l41);
		ListNode l2 = new ListNode(5,l6);
		
		ListNode output = null;
		ListNode outputReturn = null;
		int rem =0;
		boolean first = true;
		while(l1!=null || l2!=null || rem>0){
			if(l1==null && l2==null ){
				int temp = rem;
				update1(temp, rem, output);
			}
			else if(l1!=null && l2!=null){
				int temp = l2.val+l1.val+rem;
				update1(temp, rem, output);
				
			}
			else if(l2!=null){
				int temp = l2.val+rem;
				update1(temp, rem, output);
			}
			else {
				int temp = l1.val+rem;
				update1(temp, rem, output);
			}
			
			if(first){
				outputReturn = output;
				first =  false;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
	}

	private static ListNode update(ListNode output, int temp) {
		if(output==null){
			output = new ListNode(temp);
		}
		else{
			ListNode tempNode = new ListNode(temp);
			output.next=tempNode;
			output = tempNode;
			
		}
		return output;
	}
	
	private static void update1(int temp,int rem,ListNode output ){
		if(temp<10){
			output = update( output, temp);
			rem =0;
		}
		else{
			output = update( output, temp-10);
			rem =1;
		}
	}
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
