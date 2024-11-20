
/**
 * This will test the implementation of NoDuplicatesQueueArray class, as well as some edge cases.
 * 
 * @author Nick Pieroni
 */
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

class NoDuplicatesQueueArrayTest {
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testConstructor() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);
		
		assertTrue(queue.isEmpty());
		assertEquals(queue.getSize(), 0);
	} // end testConstructor
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testEnqueue() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);
		
        queue.enqueue(1);
        assertEquals(1, queue.getFront());
        
        queue.enqueue(2);
        
        // Test add duplicate
        queue.enqueue(1);
        assertEquals(2, queue.getSize());
        assertEquals(1, queue.getFront());
	} // end testEnqueue
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testDequeue() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);
		
		// Test dequeue
        queue.enqueue(1);
        queue.enqueue(2);
        
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        
        // Test if empty
        assertThrows(EmptyQueueException.class, queue::dequeue);
	} // end testDequeue
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testGetFront() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);
		
		// Test getFront
		queue.enqueue(1);
		assertEquals(queue.getFront(), 1);
		queue.enqueue(2);
		assertEquals(queue.getFront(), 1);
		queue.dequeue();
		assertEquals(queue.getFront(), 2);
		
		// Test if empty
		queue.clear();
		assertThrows(EmptyQueueException.class, queue::getFront);
	} // end testGetFront
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testIsEmpty() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);
		
		assertTrue(queue.isEmpty());
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
		queue.clear();
		assertTrue(queue.isEmpty());
	} // end testIsEmpty
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testGetSize() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);
		
		assertEquals(queue.getSize(), 0);
		queue.enqueue(1);
		assertEquals(queue.getSize(), 1);
		queue.enqueue(10);
		assertEquals(queue.getSize(), 2);
		queue.enqueue(2);
		assertEquals(queue.getSize(), 3);
	} // end testGetSize
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testClear() {
		NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<Integer>(10);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.clear();
        assertTrue(queue.isEmpty());
	} // end testClear
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testResize() {
        NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<>(2);
        
        queue.enqueue(1);
        queue.enqueue(2);
        
        assertEquals(2, queue.getSize());
        
        // Test resize
        queue.enqueue(3);
        assertEquals(3, queue.getSize());
        assertEquals(1, queue.getFront());
	} // end testResize
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testDequeueUntilEmpty() {
	    NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<>(3);
	    
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    
	    assertEquals(1, queue.dequeue());
	    assertEquals(2, queue.dequeue());
	    assertEquals(3, queue.dequeue());
	    assertThrows(EmptyQueueException.class, queue::dequeue);
	} // end testDequeueUntilEmpty
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testClearEmptyQueue() {
	    NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<>(10);
	    queue.clear();
	    assertTrue(queue.isEmpty());
	} // end testClearEmptyQueue
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testResizeWithWrap() {
	    NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<>(3);
	    
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    
	    // wrap starts here
	    queue.dequeue();
	    queue.enqueue(4);

	    // resize
	    queue.enqueue(5);
	    assertEquals(4, queue.getSize());
	    assertEquals(2, queue.getFront());
	} // end testResizeWithWrap
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testMultipleResizes() {
	    NoDuplicatesQueueArray<Integer> queue = new NoDuplicatesQueueArray<>(2);
	    
	    for (int i = 0; i < 20; i++) {
	        queue.enqueue(i);
	    }
	    
	    assertEquals(20, queue.getSize());
	    assertEquals(0, queue.getFront());
	} // end testMultipleResizes
} // end class NoDuplicatesQueueArrayTest
