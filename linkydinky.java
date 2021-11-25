public class linkydinky {
	private ListNode top = null;
	private ListNode bottom = null; 
	/**
	 * Above ^ that is the top and bottom of the list
	 * Below is where we test the code
	 */
	public static void main(String[] args){
		linkydinky list = new linkydinky();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		System.out.println("This list has now been reversed!");
		list.reverse(list.top);
	}
	/** Adds the data input to the end of the list
	 *  data is the parameter, the integer input
	 */
	public void add(int data){
		if (top == null) {
			top = new ListNode(data);
		} else {
			ListNode current = top;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new ListNode(data));
		}
	}
	/**
	 * Reverse method
	 * First we check to see if the list is empty
	 * Then we check to see if there is a next node,
	 * if the next node does not exist then it is printed
	 * Finally, we reucrusivly called the function with the next value
	 * and print it. 
	 */
	public void reverse(ListNode value){
		if (top == null){
			System.out.println("This list is empty!!");
			return;
		}else {
			if (value.getNext() == null){
				System.out.print(value.getData());
				System.out.print(" ");
				return;
			}
			reverse(value.getNext());
			System.out.print(value.getData());
			System.out.print(" ");
		}
	}

}


//LinkedIntList list = new LinkedIntList();
		//list.add(1);
		//list.add(2);
		//list.add(3);
		//list.add(4);
		//System.out.println(list);
		//list.stutter();
		////System.out.println(list);
