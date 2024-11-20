import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class NoDuplicatesPriorityQueueLinkedNodesTester_Student {

    // 1. Test: Add Single Element to Priority Queue
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testAddSingleElement() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        queue.add(50);
        assertEquals((Integer) 50, queue.peek());
    }

    // 2. Test: Add Multiple Elements with Correct Priority
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testAddMultipleElements() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        queue.add(30);
        queue.add(70);
        assertEquals((Integer) 70, queue.peek());  // Highest priority element is 70
    }

    // 3. Test: Add Duplicate Element (Should not be added)
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testAddDuplicateElement() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        queue.add(30);
        queue.add(30);  // Duplicate should not be added
        int count = 0;
        while (queue.peek() != null) {
            queue.remove();
            count++;
        }
        assertEquals(1, count);  // There should be only 1 element in the queue
    }

    // 4. Test: Remove Highest Priority Element
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testRemoveHighestPriority() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        queue.add(30);
        queue.add(70);
        assertEquals((Integer) 70, queue.remove());  // Highest priority element is 70
        assertEquals((Integer) 30, queue.peek());  // Now highest is 30
    }

    // 5. Test: Remove from Empty Queue (Should return null)
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testRemoveFromEmptyQueue() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        assertNull(queue.remove());  // Removing from empty queue returns null
    }

    // 6. Test: Peek into Empty Queue (Should return null)
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testPeekEmptyQueue() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        assertNull(queue.peek());  // Peeking into empty queue returns null
    }

    // 7. Test: Check if Priority Queue is Empty Initially
   @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testIsEmptyInitially() {
        NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<>();
        assertTrue(queue.isEmpty());
    }
}