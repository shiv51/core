
/**
 * 
 * single linked ist -> loop 
 * @author smettu
 *
 */
public class LoopDetection {

	public static void main(String[] args) {
		node a1 = new node(1);
		node a2 = new node(2);
		node a3 = new node(3);
		node a4= new node(4);
		node a5 = new node(5);
		a1.setNext(a2);
		a2.setNext(a3);
		a3.setNext(a4);
		a4.setNext(a5);
		
		detect(a1);
	}
	
	public static node detect(node head) {
		
		node x = head;
		node y = head;
		int count = 0;
		while(x!=null && y!=null) {
			
			if(x.equals(y) && count!=0) {
				System.out.println("Found a loop! "+y.getValue());
				return x;
			}
			if(null == y.next || y.next.next==null|| x.next==null) {
				break;
			}
			x = x.next;
			y = y.next.next;
			count++;
		}
		System.out.println("No loop!!");
		return null;
	}
}

class node{
	
	public node(Integer value) {
		this.value = value;
		this.next = null;
	}
	Integer value;
	node next;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public node getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		node other = (node) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}