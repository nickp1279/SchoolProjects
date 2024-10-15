import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This JUnit will test all the methods implemented in the ResizableArraySet class
 * @author Nick Pieroni
 */

public class TesterProject2 {

	//Test default constructor
	@Test
	public void testDefaultConstructor() {
	    ResizableArraySet set = new ResizableArraySet();
	    assertEquals(0, set.getSize());
	    assertTrue(set.isEmpty());
	}
	
	//Test constructor with initial capacity
	@Test
	public void testCapacity() {
	    ResizableArraySet set = new ResizableArraySet(20);
	    assertEquals(0, set.getSize());
	    assertTrue(set.isEmpty());
	}
	
	// Test get size
	@Test
	public void testGetSize() {
		ResizableArraySet set = new ResizableArraySet(20);
		Book book1 = new Book("The Book of Why", "Judea Pearl");
		
		set.add(book1);
		assertEquals(1, set.getSize());
		
		Book book2 = new Book("The Book of When", "Nick Pieroni");
		
		set.add(book2);
		assertEquals(2, set.getSize());
	}
	
	// Test is empty
	@Test
	public void testIsEmpty() {
		ResizableArraySet set = new ResizableArraySet(20);
		
		assertTrue(set.isEmpty());
		
		Book book1 = new Book("The Book of Why", "Judea Pearl");
		
		set.add(book1);
		assertFalse(set.isEmpty());
	}
	
	//Test Add Method
	@Test
	public void testAdd() {
	    ResizableArraySet set = new ResizableArraySet();
	    Book book1 = new Book("The Book of Why", "Judea Pearl");
	    assertTrue(set.add(book1));
	    assertEquals(1, set.getSize());
	    assertTrue(set.contains(book1));
	}
	
	// Test Duplicate Add
	@Test
	public void testAddDuplicate() {
	    ResizableArraySet set = new ResizableArraySet();
	    Book book = new Book("The Book of Why", "Judea Pearl");
	    set.add(book);
	    assertFalse(set.add(book));  // Adding duplicate should return false
	}
	
	//Test Remove method
	@Test
	public void testRemove() {
	    ResizableArraySet set = new ResizableArraySet();
	    Book book = new Book("The Book of Why", "Judea Pearl");
	    
	    set.add(book);
	    assertTrue(set.remove(book));
	    assertFalse(set.contains(book));
	    assertEquals(0, set.getSize());
	}
	
	
	//Test remove non-existent item
	@Test
	public void testRemoveNonExistent() {
	    ResizableArraySet set = new ResizableArraySet();
	    Book book = new Book("The Book of Why", "Judea Pearl");
	    assertFalse(set.remove(book));
	}
	
	
	//Test clear method
	@Test
	public void testClear() {
	    ResizableArraySet set = new ResizableArraySet();
	    set.add(new Book("The Book of Why", "Judea Pearl"));
	    set.clear();
	    assertTrue(set.isEmpty());
	    assertEquals(0, set.getSize());
	}
	
	
	//Test resize grow array
	@Test
	public void testResizeGrow() {
	    ResizableArraySet set = new ResizableArraySet(2);
	    set.add(new Book("Book 1", "Author 1"));
	    set.add(new Book("Book 2", "Author 2"));
	    assertEquals(2, set.getSize());
	    set.add(new Book("Book 3", "Author 3"));  // Should trigger array resize
	    assertEquals(3, set.getSize());
	}
	
	
	// Test resize shrink array
	@Test
	public void testResizeShrink() {
	    ResizableArraySet set = new ResizableArraySet(6);
	    set.add(new Book("Book 1", "Author 1"));
	    set.add(new Book("Book 2", "Author 2"));
	    set.add(new Book("Book 3", "Author 3"));
	    set.remove(new Book("Book 2", "Author 2"));
	    set.remove(new Book("Book 3", "Author 3"));  // Should trigger shrink
	    assertEquals(1, set.getSize());
	}
	
	
	//Test contains method
	@Test
	public void testContains() {
	    ResizableArraySet set = new ResizableArraySet();
	    Book book = new Book("The Book of Why", "Judea Pearl");
	    set.add(book);
	    assertTrue(set.contains(book));
	}
}

