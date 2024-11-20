
/**
 * Implementation of queue with no duplicates using an array
 * 
 * @author Nick Pieroni
 */
public final class NoDuplicatesQueueArray<T> implements NoDuplicatesQueueInterface<T> {
	private T[] queue;
	private int front;	// index for the front of the queue
	private int back;	// index for the back of queue
	private int size;
	private static final int DEFAULT_CAPACITY = 10; // default capacity for the Array
	
	/**
	 * Default constructor
	 */
	public NoDuplicatesQueueArray() {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	/**
	 * param constructor
	 * 
	 * @param capacity
	 */
	public NoDuplicatesQueueArray(int capacity) {
		queue = (T[]) new Object[capacity];
		
		front = 0;
		back = -1;
		size = 0;
	} // end param constructor
	
	/**
	 * This will add an object to the queue
	 * 
	 * @param newEntry
	 */
	@Override
	public void enqueue(T newEntry) {
		if (!contains(newEntry)) { // make sure the queue does not contain the object
			if (getSize() == queue.length) { // handle resize if needed
				resize();
			}
			
			back = (back + 1) % queue.length;
			queue[back] = newEntry;
			
			size++;
		}
	} // end enqueue
	
	/**
	 * This method will remove an entry from the queue. (Removes from the front)
	 */
	@Override
	public T dequeue() {
		if (isEmpty()) { // if empty throw exception
			throw new EmptyQueueException();
		}
		
		T removedObj = queue[front];
		
		queue[front] = null; // remove the entry
		front = (front + 1) % queue.length;
		
		size--;
		return removedObj; // return the removedObj (at the front of the queue)
	} // end dequeue
	
	/**
	 * This method will get the object at the front of the queue
	 */
	@Override
	public T getFront() {
		if (isEmpty()) { // if empty throw exception
			throw new EmptyQueueException();
		}
		
		return queue[front];
	} // end getFront
	
	/**
	 * This method will check if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	} // end isEmpty
	
	/**
	 * This method will get the size of the queue
	 */
	@Override
	public int getSize() {
		return size;
	} // end getSize
	
	/**
	 * This method will clear the queue
	 */
	@Override
	public void clear() {
		for (int i = 0; i < getSize(); i++) { // iterate through and set each element to null
			queue[i] = null;
		}
		
		front = 0;
		back = -1; // set back index to -1
		size = 0;
	} // end clear
	
	/**
	 * This method will handle if the array exceeds the maximum size
	 * of the array.
	 */
	private void resize() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[queue.length * 2]; // double the size of the array
		
		for (int i = 0; i < getSize(); i++) { // iterate through the queue and set temp to the old queue element
			temp[i] = queue[(front + i) % queue.length];
		}
		queue = temp;
		
		front = 0;
		back = getSize() - 1; // set the back to 1 less that the total size
	} // end resize
	
	/**
	 * This method will check if an object is in the array
	 * 
	 * @param entry
	 * @return 
	 */
	private boolean contains(T entry) {
		for (int i = 0; i < getSize(); i++) {
			if (queue[(front + i) % queue.length] == null) { // if it is not found
				return false;
			}
			else if (queue[(front + i) % queue.length].equals(entry)) { // if is found
				return true;
			}
		}
		
		return false;
	} // end contains
} // end NoDuplicatesQueueArray class
