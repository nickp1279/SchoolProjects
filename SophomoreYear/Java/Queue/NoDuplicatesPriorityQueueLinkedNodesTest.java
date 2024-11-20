
/**
 * This will test the implementation of the NoDuplicatesPriorityQueueLinkedNodes, as well as some edge cases.
 * 
 * @author Nick Pieroni
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

class NoDuplicatesPriorityQueueLinkedNodesTest {
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testConstructor() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
	} // end testConstructor
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testAdd() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        queue.add(5);
        assertEquals(5, queue.peek());
        assertEquals(1, queue.getSize());
        
        queue.add(10);
        assertEquals(10, queue.peek());
        assertEquals(2, queue.getSize());
        
        queue.add(7);
	} // end testAdd
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testRemove() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        queue.add(5);
        queue.add(10);
        queue.add(7);

        assertEquals(10, queue.remove());
        assertEquals(2, queue.getSize());
        assertEquals(7, queue.peek());

        queue.remove();
        queue.remove();
        
        assertTrue(queue.isEmpty());
        assertNull(queue.remove());
	} // end testRemove
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testPeek() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        assertNull(queue.peek());
        
        queue.add(3);
        
        assertEquals(3, queue.peek());
        
        queue.add(5);
        
        assertEquals(5, queue.peek());
	} // end testPeek
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testIsEmpty() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        assertTrue(queue.isEmpty());
        
        queue.add(1);
        
        assertFalse(queue.isEmpty());
        
        queue.remove();
        
        assertTrue(queue.isEmpty());
	} // end testIsEmpty
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testClear() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        queue.add(1);
        queue.add(2);
        
        queue.clear();
        
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
        assertNull(queue.peek());
	} // end testClear
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testGetSize() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        assertEquals(0, queue.getSize());
        
        queue.add(1);
        
        assertEquals(1, queue.getSize());
        
        queue.add(2);
        queue.add(3);
        
        assertEquals(3, queue.getSize());
        
        queue.remove();
        
        assertEquals(2, queue.getSize());
	} // end testGetSize
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testAddDuplicate() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();

        queue.add(10);
        queue.add(20);
        queue.add(10);
        queue.add(20);

        assertEquals(2, queue.getSize());
        assertEquals(20, queue.peek());
	} // end testAddDuplicate
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testRemoveEmptyQueue() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();

        assertNull(queue.remove());
	} // end testRemoveEmptyQueue
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testPeekEmptyQueue() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();

        assertNull(queue.peek());
	} // end testPeekEmptyQueue
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testAddOtherIntegers() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();

        queue.add(-5);
        queue.add(0);
        queue.add(-10);
        
        // Test priority
        assertEquals(3, queue.getSize());
        assertEquals(0, queue.peek());
	} // end testAddOtherIntegers
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testAddAllSame() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        queue.add(15);
        queue.add(15);
        queue.add(15);
        
        assertEquals(1, queue.getSize());
        assertEquals(15, queue.peek());
	} // end testAddAllSame
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testClearEmptyQueue() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();

        queue.clear();
        assertTrue(queue.isEmpty());
	} // end testClearEmptyQueue
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testClearAfterAdding() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        
        queue.add(30);
        queue.add(40);
        
        queue.clear();
        
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
	} // end testClearAfterAdding
	
	@Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	public void testAddAndRemoveMultiple() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();

        assertTrue(queue.isEmpty());
        
        queue.add(5);
        
        assertFalse(queue.isEmpty());
        
        queue.remove();
        
        assertTrue(queue.isEmpty());
	} // end testAddAndRemoveMultiple
} // end class NoDuplicatesPriorityQueueLinkedNodesTest
