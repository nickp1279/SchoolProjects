/**
 * This interface file sets all the methods and parameters to be used
 * in the UtilityInterface
 * @author Nick Pieroni
 */

public interface UtilityInterface<T> {
	
	/**
	 * Adds an element to the first available location/index of the array
	 * @param anElement
	 * @return boolean
	 */
	public boolean add(T anElement);
	
	/**
	 * Adds an element to the specified location/index of the array.
	 * @param anElement
	 * @param index
	 * @return boolean
	 */
	public boolean add(T anElement, int index);
	
	/**
	 * Removes all the elements from the array
	 */
	public void clear();
	
	/**
	 * Checks whether the array has the specified element
	 * @param anElement
	 * @return boolean
	 */
	public boolean contains(T anElement);
	
	/**
	 * Gets the object at the specified index
	 * @param index
	 * @return object
	 */
	public T get(int index);
	
	/**
	 * Gets the current number of elements in the array
	 * @return integer
	 */
	public int getCurrentSize();
	
	/**
	 * Finds the frequency of a given element
	 * @param anElement
	 * @return integer
	 */
	public int getFrequencyOf(T anElement);
	
	/**
	 * Gets the index of first occurrence of the specified element in the array
	 * @param anElement
	 * @return integer
	 */
	public int indexOf(T anElement);
	
	/**
	 * Checks whether the array is empty
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Removes the first occurrence of the specified element.
	 * @param anElement
	 * @return boolean
	 */
	public boolean remove(T anElement);
	
	/**
	 * Removes the first element from the array if there is any.
	 * @return boolean
	 */
	public boolean removeFirst();
	
	/**
	 * Removes the last element from the array if there is any.
	 * @return boolean
	 */
	public boolean removeLast();
	
	/**
	 * Removes the middle element from the array if there is any.
	 * @return boolean
	 */
	public boolean removeMiddle();
	
	/**
	 * Reverses the current order of the elements in the array
	 */
	public void reverse();
}
