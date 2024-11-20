
/**
 * This interface is for a queue that does not allow for duplicates
 * 
 * @author Nick Pieroni
 */
public interface NoDuplicatesQueueInterface<T> extends QueueInterface<T> {
	
	/**
	 * This will add an object to the queue in the front
	 * 
	 * @param newEntry
	 */
	void enqueue(T newEntry);
	
	/**
	 * This will remove the front entry
	 * 
	 * @return	the front entry
	 */
	T dequeue();
	
	/**
	 * This will get the front of the queue
	 * 
	 * @return		object at the front of the queue
	 */
	T getFront();
	
	/**
	 * This will check if the queue is empty
	 * 
	 * @return True		if it is not full
	 * @return False	if it is full
	 */
	boolean isEmpty();
	
	/**
	 * This will get the size of the queue
	 * 
	 * @return size
	 */
	int getSize();
	
	/**
	 * This will clear all entries from the queue
	 */
	void clear();
} // end NoDuplicatesQueueInterface interface
