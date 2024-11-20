
/**
 * This class will hold the implementations of the code for the interface NoDuplicatesPriotiyQueue
 * 
 * @author Nick Pieroni
 */
public final class NoDuplicatesPriorityQueueLinkedNodes<T extends Comparable<? super T>> implements NoDuplicatesPriorityQueueInterface<T> {
	private Node<T> head; // first node/starting node
	private int size;
	
	/**
	 * Constructor
	 */
	public NoDuplicatesPriorityQueueLinkedNodes() {
		head = null;
		size = 0;
	} // end constructor

	/**
	 * This will check if the queue already contains the object and if it doesnt,
	 *  then it will add it, but if it does contain it, then it won't be added
	 * 
	 * @param newEntry
	 */
	@Override
	public void add(T newEntry) {
		if (contains(newEntry)) { // if object already exists
			return; // return nothing (break)
		}
		
		Node<T> newNode = new Node<>(newEntry);
		
		if (head == null || head.data.compareTo(newEntry) < 0) { // check if the priority is the highest and there is an entry
			newNode.next = head;
			head = newNode;
		}
		else {
			Node<T> current = head;
			
			while ((current.next != null) && (current.next.data.compareTo(newEntry) > 0)) { // insert in sorted order (descending)
				current = current.next;
			}
			
			newNode.next = current.next;
			current.next = newNode;
		}
		
		size++;
	} // end add
	
	/**
	 * This method will remove an entry from the queue, should be the first entry
	 * 
	 * @return data
	 */
	@Override
	public T remove() {
		if (head == null) { // queue is empty
			return null;
		}
		
		T data = head.data;
		head = head.next;
		
		size--;
		return data;
	} // end remove
	
	@Override
	public T peek() {
		if (head == null) { // queue is empty
			return null;
		}
		
		return head.data;
	} // end peek
	
	/**
	 * This method will check if size is equal to 0
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	} // end isEmpty
	
	/**
	 * This method will clear the queue by setting the head to null and size
	 * back to 0
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	} // end clear
	
	/**
	 * helper method will return the value of size
	 */
	@Override
	public int getSize() {
		return size;
	} // end getSie
	
	/**
	 * Helper method will iterate through the all the Nodes and check if the entry is
	 * in the queue.
	 * 
	 * @param entry
	 * @return
	 */
	private boolean contains(T entry) {
		Node<T> current = head;
		
		while (current != null) { // iterate over the queue
			if (current.data.equals(entry)) { // if the current data equals the the current entry
				return true; // if object is found
			}
			
			current = current.next;
		}
		
		return false;
	} // end contains
	
	/**
	 * This class will allow the implementation of a single linked
	 * node queue
	 * 
	 * @param <T>
	 */
	private static class Node<T> {
		private T data; // store data 
		private Node<T> next; // store reference for next node
		
		/**
		 * Constructor
		 * 
		 * @param data
		 */
		private Node(T data) {
			this.data = data;
			this.next = null;
		} // end constructor
	} // end class Node
} // end class NoDuplicatesPriorityQueueLinkedNodes
