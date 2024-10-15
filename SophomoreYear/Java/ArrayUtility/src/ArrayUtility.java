
/**
 * Comments here
 * @author Nick Pieroni
 */
public class ArrayUtility implements UtilityInterface<Integer> {
	
	private Integer[] array;
	private int last;
	public static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Constructor to initialize the size
	 * @param capacity
	 */
	public ArrayUtility(int capacity) {
		this.array = new Integer[capacity];
		this.last = 0;
	}
	
	/**
	 * Constructor
	 */
	public ArrayUtility() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Adds an element to the first available location/index of the array
	 * @param anElement
	 * @return true if added and false if not
	 */
	@Override
	public boolean add(Integer anElement) {
		
		if (array.length <= DEFAULT_CAPACITY) {
			
			for (int i = 0; i < array.length; i++) {
				
				if (array[i] == null) {
					array[i] = anElement;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Adds an element to the specified location/index of the array.
	 * @param anElement
	 * @param index
	 * @return true if added and false if not
	 */
	@Override
	public boolean add(Integer anElement, int index) {
		
		if (array.length <= DEFAULT_CAPACITY) {
			array[index] = anElement;
			return true;
		}
		return false;
	}

	/**
	 * Removes all the elements from the array
	 */
	@Override
	public void clear() {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] != null) {
				array[i] = null;
			}
		}
	}

	/**
	 * Checks whether the array has the specified element
	 * @param anElement
	 * @return true if contains element and false if not
	 */
	@Override
	public boolean contains(Integer anElement) {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == anElement) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the object at the specified index
	 * @param index
	 * @return return integer at the index
	 */
	@Override
	public Integer get(int index) {
		return array[index];
	}

	/**
	 * Gets the current number of elements in the array
	 * @return size of the array
	 */
	@Override
	public int getCurrentSize() {
		int size = 0;
		
		for (int i = array.length - 1; i > 0; i--) {
		
			if (array[i] != null) {
				size++;
			}
		}
		return size;
	}

	/**
	 * Finds the frequency of a given element
	 * @param anElement
	 * @return count, instances of element
	 */
	@Override
	public int getFrequencyOf(Integer anElement) {
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == anElement) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Gets the index of first occurrence of the specified element in the array
	 * @param anElement
	 * @return the index if element found and -1 if element not found
	 */
	@Override
	public int indexOf(Integer anElement) {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == anElement) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Checks whether the array is empty
	 * @return true if empty and false if not
	 */
	@Override
	public boolean isEmpty() {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Removes the first occurrence of the specified element.
	 * @param anElement
	 * @return true if element removed successfully and false if not
	 */
	@Override
	public boolean remove(Integer anElement) {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == anElement) {
				array[i] = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the first element from the array if there is any.
	 * @return true if first element was removed and false if not
	 */
	@Override
	public boolean removeFirst() {
		
		if (array[0] != null) {
			array[0] = null;
			return true;
		}
		return false;
	}

	/**
	 * Removes the last element from the array if there is any.
	 * @return true if last element was removed and false if not
	 */
	@Override
	public boolean removeLast() {
		
		if (array[array.length - 1] != null) {
			array[array.length - 1] = null;
			return true;
		}
		return false;
	}

	/**
	 * Removes the middle element from the array if there is any.
	 * @return true if middle element removed and false if not
	 */
	@Override
	public boolean removeMiddle() {
		
		if (array[array.length / 2] != null) {
			array[array.length / 2] = null;
			return true;
		}
		return false;
	}

	/**
	 * Reverses the current order of the elements in the array
	 */
	@Override
	public void reverse() {
		int first = 0;
		last = array.length - 1;
		
		while (first < last) {
			Integer temp = array[first];
			array[first] = array[last];
			array[last] = temp;
			
			first++;
			last--;
		}
	}
}
