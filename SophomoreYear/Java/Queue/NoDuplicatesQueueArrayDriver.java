
/**
 * This is the driver for the NoDuplicatesQueueArrayInterface.
 * 
 * @author Nick Pieroni
 */
public class NoDuplicatesQueueArrayDriver {
	public static void main(String[] args) {
		
		// Test constructor
		NoDuplicatesQueueArray<String> queue = new NoDuplicatesQueueArray<String>(5);
		System.out.println("Constructor made new instance: " + queue);
		
		// Test enqueue
		System.out.println("\nTest Enqueue");
		System.out.println("enqueue: Dog");
		queue.enqueue("Dog");
		System.out.println("enqueue: Cat");
		queue.enqueue("Cat");
		System.out.println("enqueue: Horse");
		queue.enqueue("Horse");
		System.out.println("Check size before (3): " + queue.getSize());
		System.out.println("Try enqueue duplicate: Dog"); // should not be added
		queue.enqueue("Dog"); // should not be added
		System.out.println("Check size after (3): " + queue.getSize());
		
		// Test dequeue
		System.out.println("\nTest Dequeue");
		System.out.println("Check size before (3): " + queue.getSize());
		System.out.println("Dequeue (Dog): " + queue.dequeue());
		System.out.println("Check size after (2): " + queue.getSize());
		
		// Test getFront
		System.out.println("\nTest getFront");
		System.out.println("getFront (Cat): " + queue.getFront());
		
		// Test isEmpty
		System.out.println("\nTest isEmpty");
		System.out.println("isEmpty (false): " + queue.isEmpty());
		queue.clear();
		System.out.println("Clear queue (0): " + queue.getSize());
		System.out.println("isEmpty (true): " + queue.isEmpty());
		
		// Test getSize
		System.out.println("\nTest getSize");
		System.out.println("getSize (0): " + queue.getSize());
		System.out.println("enqueue: Dog");
		queue.enqueue("Dog");
		System.out.println("getSize (1): " + queue.getSize());
		
		// Test clear
		System.out.println("\nTest clear");
		System.out.println("enqueue: Cat");
		queue.enqueue("Cat");
		System.out.println("enqueue: Horse");
		queue.enqueue("Horse");
		System.out.println("getSize (3): " + queue.getSize());
		queue.clear();
		System.out.println("clear (0): " + queue.getSize());
		
		/**
		 * EXPECTED OUTPUT:

			Constructor made new instance: NoDuplicatesQueueArray@33c7353a
			
			Test Enqueue
			enqueue: Dog
			enqueue: Cat
			enqueue: Horse
			Check size before (3): 3
			Try enqueue duplicate: Dog
			Check size after (3): 3
			
			Test Dequeue
			Check size before (3): 3
			Dequeue (Dog): Dog
			Check size after (2): 2
			
			Test getFront
			getFront (Cat): Cat
			
			Test isEmpty
			isEmpty (false): false
			Clear queue (0): 0
			isEmpty (true): true
			
			Test getSize
			getSize (0): 0
			enqueue: Dog
			getSize (1): 1
			
			Test clear
			enqueue: Cat
			enqueue: Horse
			getSize (3): 3
			clear (0): 0
		 */
	} // end class main
} // end class NoDuplicatesQueueArrayDriver
