
/**
 * This JUnit tester will test all the methods, including the constructors,
 * to see that they work properly.
 * @author Nick Pieroni
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SetTester {

	@Test
	public void testDefaultConstructor() {
		ResizableArraySet set = new ResizableArraySet();
		
		// check if size is 0, should be true
		assertEquals(0, set.getSize());
	}
	
	@Test
	public void testConstructor() {
		ResizableArraySet set = new ResizableArraySet(30);
		
		// check if size is 0, should be true
		assertEquals(0, set.getSize());
	}
	
	@Test
	public void testGetSize() {
		ResizableArraySet set = new ResizableArraySet();
		Book book = new Book("The Will The Way", "Nick Pieroni");
		
		// check size is 0, should be true
		assertEquals(0, set.getSize());
		
		// add book then check to see it got added
		set.add(book);
		
		// should be true
		assertEquals(1, set.getSize());
		
		// remove the book then check to see it got removed from size
		set.remove();
		
		// should be true
		assertEquals(0, set.getSize());
	}
	
	@Test
	public void testIsEmpty() {
		ResizableArraySet set = new ResizableArraySet();
		
		// check if empty, should be true
		assertTrue(set.isEmpty());
		
		// create and add new book
		Book book = new Book("The Will The Way", "Nick Pieroni");
		set.add(book);
		
		// check if the set is empty, should be False
		assertFalse(set.isEmpty());
	}
	
	@Test
	public void testAdd() {
		
		// create new set with size of 2
		ResizableArraySet set = new ResizableArraySet(2);
		Book book = new Book("The Will The Way", "Nick Pieroni");
		assertTrue(set.add(book));
		
		// test edge cases
		
		// test add the same book, should be false
		assertFalse(set.add(book));
		
		// test array resizing
		Book book2 = new Book("The Why", "Nick Pieroni");
		assertTrue(set.add(book2));
		Book book3 = new Book("The When", "Nick Pieroni");
		assertTrue(set.add(book3));
		
		// check the size of the array and print array, should be true
		assertEquals(3, set.getSize());
	}
	
	@Test
	public void testRemoveObject() {
		ResizableArraySet set = new ResizableArraySet();
		Book book = new Book("The Will The Way", "Nick Pieroni");
		
		// add book then remove book, all should be true
		assertTrue(set.add(book));
		assertEquals(1, set.getSize());
		assertTrue(set.remove(book));
		assertEquals(0, set.getSize());
		
		// test edge cases
		
		// test remove when size = 0
		assertFalse(set.remove(book));
		assertTrue(set.isEmpty());
		
		// test resize array
		ResizableArraySet set2 = new ResizableArraySet(10);
		assertTrue(set2.add(book));
		assertTrue(set2.remove(book));
	}
	
	@Test
	public void testRemove() {
		ResizableArraySet set = new ResizableArraySet();
		Book book = new Book("The Will The Way", "Nick Pieroni");
		
		// add book should be true
		assertTrue(set.add(book));
		Book book2 = new Book("The Why", "Nick Pieroni");
		
		// check that removed book equals book supposed to be removed
		assertTrue(set.add(book2));
		assertEquals(set.remove(), book);
		
		// test edge cases
		
		// if the set is empty, it should return null
		set.clear();
		assertTrue(set.isEmpty());
		assertEquals(set.remove(), null);
	}
	
	@Test
	public void testClear() {
		ResizableArraySet set = new ResizableArraySet();
		Book book = new Book("The Will The Way", "Nick Pieroni");
		
		// add book then check if empty, should be false
		assertTrue(set.add(book));
		assertFalse(set.isEmpty());
		
		// clear then check if empty again, should be true
		set.clear();
		assertTrue(set.isEmpty());
		
		// test edge cases
		
		// when array is empty
		assertTrue(set.isEmpty());
		set.clear();
	}
	
	@Test
	public void testContains() {
		ResizableArraySet set = new ResizableArraySet();
		Book book = new Book("The Will The Way", "Nick Pieroni");
		
		// add book then check if the set contains the book, should all be true but the last one
		assertTrue(set.add(book));
		assertTrue(set.contains(book));
		assertTrue(set.remove(book));
		assertFalse(set.contains(book));
	}
	
	@Test
	public void testToArray() {
		ResizableArraySet set = new ResizableArraySet(10);
		Book book = new Book("The Will The Way", "Nick Pieroni");
		
		// add book then create temp array to store the array created by the function
		assertTrue(set.add(book));
		Book[] tempArray = set.toArray();

		// check if the array returned to temp array contains the same element that was added
		assertEquals(tempArray[0], book);
		
		// edge cases
		
		// test empty set, should return null
		set.clear();
		assertEquals(set.toArray(), null);
	}
}
