/**
 * This JUnit test file will test all the methods implemented by
 * the interface ArrayUtility
 * @author Nick Pieroni
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestArrayUtility {
	
	@Test
	void testAdd() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.add(6), true);
	}
	
	@Test
	void testAddAtIndex() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.add(78, 0), true);
		
		assertEquals(arrayUtility.add(9, 9), true);
	}
	
	@Test
	void testClear() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		arrayUtility.add(10);
		
		arrayUtility.add(9);
		
		arrayUtility.clear();
		
		assertEquals(arrayUtility.isEmpty(), true);
	}
	
	@Test
	void testContains() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		arrayUtility.add(11);
		
		assertEquals(arrayUtility.contains(11), true);
		
		assertEquals(arrayUtility.contains(0), false);
	}
	
	@Test
	void testGet() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		arrayUtility.add(7, 9);
		
		arrayUtility.add(6, 0);
		
		assertEquals(arrayUtility.get(0), 6);
		
		assertEquals(arrayUtility.get(9), 7);
	}
	
	@Test
	void testGetCurrentSize() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.getCurrentSize(), 0);
		
		arrayUtility.add(98);
		
		arrayUtility.add(99);
		
		arrayUtility.add(100);
		
		assertEquals(arrayUtility.getCurrentSize(), 3);		
	}
	
	@Test
	void testGetFrequencyOf() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.getFrequencyOf(98), 0);

		arrayUtility.add(98);
		
		arrayUtility.add(98);
		
		assertEquals(arrayUtility.getFrequencyOf(98), 2);
	}
	
	@Test
	void testIndexOf() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.indexOf(98), -1);
		
		arrayUtility.add(98, 3);
		
		assertEquals(arrayUtility.indexOf(98), 3);
	}
	
	@Test
	void testIsEmpty() {
		ArrayUtility arrayUtility = new ArrayUtility();

		assertEquals(arrayUtility.isEmpty(), true);
		
		arrayUtility.add(98);
		
		assertEquals(arrayUtility.isEmpty(), false);
	}
	
	@Test 
	void testRemove() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		arrayUtility.add(98);
		
		assertEquals(arrayUtility.remove(98), true);
	}
	
	@Test
	void testRemoveFirst() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.removeFirst(), false);
		
		arrayUtility.add(98);
		
		assertEquals(arrayUtility.removeFirst(), true);
		
		assertEquals(arrayUtility.removeFirst(), false);
	}
	
	@Test
	void testRemoveLast() {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		assertEquals(arrayUtility.removeLast(), false);
		
		arrayUtility.add(98, 9);
		
		assertEquals(arrayUtility.removeLast(), true);
	}
	
	@Test
	void testRemoveMiddle() {
		
	}
	
	@Test
	void testReverse() {
		ArrayUtility arrayUtility = new ArrayUtility(10);
		
		for (int i = 0; i < arrayUtility.DEFAULT_CAPACITY; i++) {
			arrayUtility.add(i + 1, i);
		}
		
		assertEquals(arrayUtility.get(0), 1);
		
		assertEquals(arrayUtility.get(4), 5);
		
		assertEquals(arrayUtility.get(9), 10);
		
		arrayUtility.reverse();
		
		assertEquals(arrayUtility.get(0), 10);
		
		assertEquals(arrayUtility.get(4), 6);
		
		assertEquals(arrayUtility.get(9), 1);
		
	}
}
