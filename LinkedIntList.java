/**
 * Class LinkedIntList can be used to store a list of integers.
 */
import java.util.NoSuchElementException;
public class LinkedIntList {
	private ListNode front;  // first value in the list
	/** constructs an empty list */
	public LinkedIntList() {
		front = null;
	}
	
	/** 
	 * @return the current number of elements in the list 
	 */
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.getNext();
			count++;
		}
		return count;
	}

	/**
	 * Give the element at an index
	 * @param index assumes 0 &lt;= index &lt; size()
	 * @return the integer at the given index in the list 
	 * @throws IllegalArgumentException if index is not valid
	 */
	public int get(int index) {
		if(index < 0 || index > size()){
			throw new IllegalArgumentException();
		}
		return nodeAt(index).getData();
	}

	/**
	 * Create a logical representation of the list
	 * 
	 * @return a comma-separated, bracketed version of the list
	 */
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.getData();
			ListNode current = front.getNext();
			while (current != null) {
				result += ", " + current.getData();
				current = current.getNext();
			}
			result += "]";
			return result;
		}
	}
	
	/**
	 * Search the list for a value.
	 * 
	 * @param value the value to find
	 * @return the position of the first occurrence of the given value (-1 if not found)
	 */
	public int indexOf(int value) {
		int index = 0;
		ListNode current = front;
		while (current !=  null) {
			if (current.getData() == value) {
				return index;
			}
			index++;
			current = current.getNext();
		}
		return -1;
	}

	/** 
	 * Appends the given value to the end of the list
	 * @param value the value to be added
	 */
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new ListNode(value));
		}
	}

	/**
	 * Inserts the given value at the given index
	 * assumes 0 &lt;= index &lt;= size()
	 * @param index the index to insert at
	 * @param value the value to insert
	 * @throws IllegalArgumentException if index is not valid
	 */
	public void add(int index, int value) {
		if(index < 0 || index > size()){
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.setNext(new ListNode(value, current.getNext()));
		}
	}

	/**
	 * Removes value at the given index
	 * @param index the index to remove assuming 0 &lt;= index &lt; size()
	 * @throws IllegalArgumentException if index is not valid
	 */
	public void remove(int index) {
		if(index < 0 || index > size()){
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			front = front.getNext();
		} else {
			ListNode current = nodeAt(index - 1);
			current.setNext(current.getNext().getNext());
		}
	}

	// pre : 0 <= i < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}
	/**
	 * This is method push
	 * @param value
	 * First we create the temperary node
	 * Then we set that node equal to the front
	 * then front equals our temp value
	 */
	public void push(int value){
		ListNode temp = new ListNode(value);            
        temp.setNext(front);
        front = temp;
	}
	/**
	 * First we check to see if the front of the stack is null
	 * if it is, then we throw an exception
	 * We create a new int called result and set it to the front
	 * Then we set front equal to the next node
	 * Finally we return our result
	 */
	public int pop(){
		if (front == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int result = front.getData();
        front = front.getNext();
        return result;
	}
	/**
	 * First we check to see if the front of the stack is equal to null
	 * Then we set the node current equal to the front of the list
	 * Then while current is not null we create a new list node equal to 
	 * the current data. Then we set the next new node equal to next current data
	 * We then set the next current data equal to the newnode. Finally, we set the 
	 * current data equal to the next new node. 
	 */
	public void stutter() {
		if(front == null)
			return;
			
		ListNode current = front;
		
		while(current != null) {
        ListNode newnode = new ListNode(current.getData());
        newnode.setNext(current.getNext());
        current.setNext(newnode);
        current = newnode.getNext();
		}
	}
	
	/**
	 * This is the method equals it has a
	 * @param list which is an object. We first start off
	 * by creating two lists. The first one is set to the front
	 * and the second one is set to the front of the second list
	 * Then while list one or two is not null we check to see if the first
	 * list is null, if it is we return false. Then we check to see if 
	 * list two is equal null if it is, we return false. If list 1 does not 
	 * equal list two then we return false, then we set each list equal to the
	 * next node in the list. If they do equal each other, we return true.
	 */
	public boolean equals(Object list) {
		ListNode list1 = front;
		ListNode list2 = ((LinkedIntList)list).front;
		
		while(list1 != null || list2 != null) {
			if(list1 == null)
				return false;
				
			if(list2 == null)
				return false;
				
			if(list1.getData() != list2.getData())
				return false;
				
			list1 = list1.getNext();
			list2 = list2.getNext();
		}
		
		return true;
	}
	
	/**
	 * This is the method double list. First we check to see
	 * if the front is equal to null. Then we create four new list nodes.
	 * Two of which are equal to the front, the other two are set to null.
	 * Then while the current node is not equal to null, we create a new 
	 * list node equall to the current data. If the temp is equal to null then 
	 * temp and end are set to the new node. If it does not, then we set the next 
	 * node after end equal to the new node, and we set the end equal to the new node.
	 * Then, we set the previous node equal to the current node and the current node
	 * is set the next node of current2(previous). Finally, we set the previous node equal
	 * to the temp node
	 */
	public void doubleList() {
    if(front == null)
        return;
        
    ListNode current = front;
    ListNode current2 = front;
    ListNode temp = null;
    ListNode end = null;
    
    while(current != null) {
        ListNode newnode = new ListNode(current.getData());
        
        if(temp == null) {
            temp = newnode;
            end = newnode;
        } else {
            end.setNext(newnode);
            end = newnode;
        }
        
        current2 = current;
        current = current2.getNext();
    }
    
    current2.setNext(temp);
}
}
