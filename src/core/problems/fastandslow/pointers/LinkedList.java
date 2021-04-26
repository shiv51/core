package core.problems.fastandslow.pointers;

public class LinkedList {

	Node1 head;
	
	
	public void add (int value) {
		if(head==null)
			head = new Node1(value);
		else {
			Node1 temp = head;
			while(true) {
				if(temp.next==null) {
					temp.next = new Node1(value);
					break;
				}
				temp = temp.next;
			}
		}
	}
	
	public void print() {
		Node1 temp = head;
		while(temp!=null) {
		System.out.println(temp.value);
		temp = temp.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.print();
	}
	
	public void reverse() {
		Node1 temp = head;
		Node1 prev = null;
		Node1 current = temp;
		while(temp!=null) {
			current = temp;
			temp=temp.next;
			current.next = prev;
			prev=current;
		}
		head = current;
	}
	
}

class Node1{
	int value;
	Node1 next;
	
	Node1(int value){
		this.value= value;
	}
}