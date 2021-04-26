package core.problems.fastandslow.pointers;

public class RearrangeLinkidList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		Node1 slow = list.head;
		Node1 fast = list.head;
		int mid = 0;
		while(fast!=null) {
			if(fast.next==null)
				break;
			if(fast.next.next==null) {
				fast =fast.next;
				break;
			}
			slow = slow.next;
			fast=fast.next.next;
		}
		mid=slow.value;
		list = reverse(list,2);
		list.print();
		
	}
	
	
	public static LinkedList reverse(LinkedList list, int from) {
		Node1 temp = list.head;
		Node1 prev = null;
		while(temp.value!=from) {
			prev = temp;
			temp=temp.next;
		}
		Node1 current = temp;
		while(temp!=null) {
			current = temp;
			temp=temp.next;
			current.next = prev;
			prev=current;
		}
		list.head = current;
		return list;
		
	}
}
