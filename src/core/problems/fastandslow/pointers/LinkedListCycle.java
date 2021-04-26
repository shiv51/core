package core.problems.fastandslow.pointers;

public class LinkedListCycle {

	Node head;
	
	
	public void add (int value) {
		if(head==null)
			head = new Node(value);
		else {
			
			Node temp = head;
			while(true) {
				if(temp.next==null) {
					temp.next = new Node(value);
					break;
				}
				temp = temp.next;
				
			}
			
		}
		
	}
	
	public void print() {
		Node temp = head;
		while(temp!=null) {
		System.out.println(temp.value);
		temp = temp.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedListCycle list = new LinkedListCycle();
		list.add(0);
		list.add(1);
		list.add(2);
		list.print();
	}
}

class Node{
	int value;
	Node next;
	
	Node(int value){
		this.value= value;
	}
}