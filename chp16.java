import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for Chapter 16
 */

public class chp16 {
private ListNode front;  // first value in the list

	public static void main(String [] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		list.stutter();
		System.out.println(list);
		
	
	}
	/** constructs an empty list */
	public chp16() {
		front = null;
	}
		
	public void stutter() {
    if(front == null){
        return;
	}
        
    ListNode current = front;
    
    while(current != null) {
        ListNode n = new ListNode(current.getData());
        n.getNext().equals(current.getNext());
        current.getNext().equals(n);
        current = n.getNext();
    }
}
	public boolean equals(chp16 second) {
    ListNode n1 = front;
    ListNode n2 = second.front;
    
    while(n1 != null || n2 != null) {
        if(n1 == null)
            return false;
            
        if(n2 == null)
            return false;
            
        if(n1.getData() != n2.getData())
            return false;
            
        n1 = n1.getNext();
        n2 = n2.getNext();
    }
    
    return true;
}
	public void doubleList() {
    if(front == null)
        return;
        
    ListNode current = front;
    ListNode prev = front;
    ListNode copy = null;
    ListNode last = null;
    
    while(current != null) {
        ListNode n = new ListNode(current.getData());
        
        if(copy == null) {
            copy = n;
            last = n;
        } else {
            last.getNext().equals(n);
            last = n;
        }
        
        prev = current;
        current = prev.getNext();
    }
    
    prev.getNext().equals(copy);
}

}

