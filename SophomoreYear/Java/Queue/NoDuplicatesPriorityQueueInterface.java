
/**
 * This interface will implement a priority queue that does not allow duplicates
 * 
 * @author Nick Pieroni
 */
public interface NoDuplicatesPriorityQueueInterface<T extends Comparable<? super T>> extends PriorityQueueInterface<T> {
	
	/**
	 * This will check if the queue already contains the object and if it doesnt,
	 *  then it will add it, but if it does contain it, then it won't be added
	 * 
	 * @param newEntry
	 */
	public void add(T newEntry);
	
	/**
	 * This method will remove an entry from the queue, should be the first entry
	 * 
	 * @return data
	 */
	public T remove();
	
	/**
	 * This method will check if the head is equal to null
	 */
	public boolean isEmpty();
	
	/**
	 * This method will clear the queue by setting the head to null
	 */
	public void clear();
	
	/**
	 * This method will return the value of size
	 */
	public int getSize();
} // end interface NoDuplicatesPriorityQueueInterface
