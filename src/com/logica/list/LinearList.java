package com.logica.list;

public class LinearList {
	
	private Node root;
	
	private Node current;
	
	public LinearList() {
		current = root;
	}
	
	private class Node {
		Object data;
		Node next;
	}
	
	private void add(Object data) {
		if (current == null) {
			current = new Node();
			if(root == null){
				root = current;
			}
		} else {
			current.next = new Node();
			current = current.next;
		}
		current.data = data;
	}
	
	/**
	 * Initiate recursion from root.
	 * @param index
	 * 			index
	 */
	private void getNthFromLastObject(int index) {
		getNthFromLastObject(root, index);
	}
	
	/**
	 * Display nth from last object.
	 * @param index
	 * 			index
	 */
	private int getNthFromLastObject(Node temp, int i) {
		if((temp = temp.next) != null)
			i = getNthFromLastObject(temp, i);
		if (i == 0)
			System.out.println(temp.data);
		return --i;
	}
	
	/**
	 * Much faster traversal. No recursion.
	 * @param start
	 * @param n
	 * @return
	 * 		{@link Node}
	 */
	private Node nthFromLast(Node start, int n) {
		Node slow, fast;
		slow = fast = start;
		for(int i = 1; i < n; i++)
			fast = fast.next; // Advance the fast ptr by the reqd offset (n - 1)
		
		// now start traversing both together
		// When fast reaches end slow will be point to nth from last
		// as the difference between them is 'n'
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		Node temp = root;
		while(temp != null) {
			ret.append(temp.data);
			ret.append(",");
			temp = temp.next;
		}
		return ret.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinearList ll = new LinearList();
		ll.add(Integer.valueOf(1));
		ll.add(Integer.valueOf(2));
		ll.add(Integer.valueOf(3));
		ll.add(Integer.valueOf(4));
//		ll.getNthFromLastObject(3);
		System.out.println(ll.nthFromLast(ll.root, 3).data);
	}


}
