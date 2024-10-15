
/**
 * This class will use the SetInterface to interact with a book object to perform functions on it.
 * @author Nick Pieroni
 */
import java.util.Arrays;

public class ResizableArraySet implements SetInterface {
	
	private Book[] array;
	public int size;

	/**
	 * Constructor for the object
	 */
	public ResizableArraySet() {
		this.array = new Book[10];
		this.size = 0;
	}
	
	/**
	 * Constructor with the specified size of array
	 * @param size		this will be the desired size
	 */
	public ResizableArraySet(int size) {
		this.array = new Book[size];
		this.size = 0;
	}
	
	/**
	 * This will get the size of the array
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * This will return if the array is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Add a new book
	 * @param newBook
	 * @return true		if successful
	 * @return false	if unsuccessful
	 */
	@Override
	public boolean add(Book newBook) {
		
		if (!contains(newBook)) {
			
			if (array.length < size || size == 0) {
				
				for (int i = 0; i < array.length; i++) {
					
					if (array[i] == null) {
						array[i] = newBook;
						size++;
						
						return true;
					}
				}
			}
			
			// handle if array too big
			else if (array.length >= size) {
				Book[] tempArray = new Book[size * 2];
				
				for (int i = 0; i < array.length; i++) {
					tempArray[i] = array[i];
					
					if (tempArray[i] == null) {
						tempArray[i] = newBook;
						size++;
						
						return true;
					}
				}
				array = tempArray;
			}
		}
		
		return false;
	}

	/**
	 * removes the book specified in the parameter
	 * @param newBook		
	 * @return true			if the book entry was successfully removed
	 * @return false		if the remove book fails
	 */
	@Override
	public boolean remove(Book aBook) {
		
		if (size != 0) {
			
			for (int i = 0; i < array.length; i++) {
				
				if (array[i] == aBook) {
					array[i] = null;
					size--;
					
					return true;
				}
			}
			
			// handle shrinking array
			if (array.length <= (size / 3)) {
				Book[] tempArray = new Book[size / 2];
				
				for (int i = 0; i < array.length; i++) {
					tempArray[i] = array[i];
					
					if (tempArray[i] == aBook) {
						tempArray[i] = null;
						size--;
						
						return true;
					}
				}
				array = tempArray;
			}
		}
		
		return false;
	}

	/**
	 * This will remove the first book
	 * @return Book		return the book that was removed
	 * @return null		if the book was unable to be removed
	 */
	@Override
	public Book remove() {
		
		if (size > 0) {
			Book[] tempArray2 = new Book[1];
			
			for (int i = 0; i < array.length; i++) {
				
				if (array[i] != null) {
					tempArray2[0] = array[i];
					array[i] = null;
					size--;
					
					return tempArray2[0];
				}
			}
			
			// handle shrinking array
			if (array.length <= (size / 3)) {
				Book[] tempArray = new Book[size / 2];
				
				for (int i = 0; i < array.length; i++) {
					tempArray[i] = array[i];
					
					if (tempArray[i] != null) {
						tempArray[i] = null;
						size--;
						
						break;
					}
				}
				array = tempArray;
			}
		}
		
		return null;
	}

	/**
	 * this will clear the array of all elements
	 */
	@Override
	public void clear() {
		
		if (size != 0) {
			
			for (int i = 0; i < array.length; i++) {
				
				if (array[i] != null) {
					array[i] = null;
				}
			}
			size = 0;
		}
	}

	/**
	 * will check if the book is in the array
	 * @param aBook			the book of the user's choice
	 * @return true			if the book is in the array
	 * @return false		if the book is not in the array
	 */
	@Override
	public boolean contains(Book aBook) {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == aBook) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Computes the union of this set with a given set
	 * 
	 * @param anotherSet
	 *            another set
	 * @return the union of this set with anotherSet
	 */
	@Override
	public SetInterface union(SetInterface anotherSet) {
		ResizableArraySet arraySet = new ResizableArraySet();
		Book[] bookArray = arraySet.toArray();
		Book[] bookArray2 = anotherSet.toArray();
		
		for (int i = 0; i < bookArray.length; i++) {
			arraySet.add(bookArray[i]);
		}
		
		for (int i = 0; i < bookArray2.length; i++) {
			
			if (!arraySet.contains(bookArray2[i])) {
				arraySet.add(bookArray2[i]);
			}
		}
		
		return arraySet;
	}

	/**
	 * Computes the intersection of this set with a given set
	 * 
	 * @param anotherSet
	 *            another set
	 * @return the intersection of this set with anotherSet
	 */
	@Override
	public SetInterface intersection(SetInterface anotherSet) {
		ResizableArraySet arraySet = new ResizableArraySet();
		Book[] bookArray = arraySet.toArray();
		
		for (int i = 0; i < bookArray.length; i++) {
			
			if (arraySet.contains(bookArray[i])) {
				arraySet.add(bookArray[i]);
			}
		}
		
		return arraySet;
	}

	/**
	* Computes the elements in this set except for those that are also in anotherSet
    *
	* @param anotherSet
	*            another set
	* @return the result of removing all elements of this set that are in anotherSet
	*/
	@Override
	public SetInterface difference(SetInterface anotherSet) {
		ResizableArraySet arraySet = new ResizableArraySet();
		Book[] bookArray = arraySet.toArray();
		
		for (int i = 0; i < bookArray.length; i++) {
			
			if (!arraySet.contains(bookArray[i])) {
				arraySet.add(bookArray[i]);
			}
		}
		
		return arraySet;
	}

	/**
	 * this will the array and turn it into an array with the correct size
	 * @return Book[]		turns the string entry into an array
	 * @return null			returns null if there is nothing to copy
	 */
	@Override
	public Book[] toArray() {
		
		if (size != 0) {
			return Arrays.copyOf(array, size);
		}
		return null;
	}
}
