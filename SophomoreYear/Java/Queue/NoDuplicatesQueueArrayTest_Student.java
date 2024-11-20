import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class NoDuplicatesQueueArrayTest_Student {

    // 1. Test: Enqueue Single Element
    @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    
    public void testEnqueueSingleElement() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        queue.enqueue("A");
        assertEquals("A", queue.getFront());
    }

    // 2. Test: Enqueue Two Elements
    @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testEnqueueTwoElements() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.getFront());
    }

    // 3. Test: Enqueue Duplicate Element
    @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testEnqueueDuplicateElementWithoutSizeMethod() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        queue.enqueue("A");
        queue.enqueue("A");  // Duplicate should not be added
        
        int count = 0;
        while (!queue.isEmpty()) {
            queue.dequeue();
            count++;
        }
        assertEquals(1, count);  // There should be only 1 unique element in the queue
    }

    // 4. Test: Dequeue Single Element
    @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testDequeueSingleElement() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        queue.enqueue("A");
        assertEquals("A", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    // 5. Test: Dequeue from Empty Queue (Expect Exception)
    @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testDequeueEmptyQueue() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        try {
            queue.dequeue();  // Expecting an exception
            fail("Expected an EmptyQueueException to be thrown");
        } catch (EmptyQueueException e) {
            // Test passes if exception is caught
            System.out.println("Caught EmptyQueueException as expected.");  // Debugging statement
        } catch (Exception e) {
            fail("Expected EmptyQueueException but got " + e);
        }
    }



    // 6. Test: Get Front of Single Element Queue
    @Test @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testGetFrontSingleElement() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        queue.enqueue("A");
        assertEquals("A", queue.getFront());
    }

    // 7. Test: Get Front from Empty Queue (Expect Exception)
    @Test(expected = EmptyQueueException.class)
    @Timeout(value = 1, unit= TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    public void testGetFrontEmptyQueue() {
        NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<>();
        queue.getFront();  // Should throw EmptyQueueException
    }
}