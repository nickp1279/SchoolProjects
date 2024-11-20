
/**
 * This class will test the implementation of the NoDuplicatesPriorityQueueLinkedNodes
 * 
 * @author Nick Pieroni
 */
public class NoDuplicatesPriorityQueueLinkedNodesDriver {
	public static void main(String[] args) {
		// Test constructor
		System.out.println("\nTest Constructor");
		NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<Integer>();
		System.out.println(queue);
		
		// Test add
		System.out.println("\nTest Add");
		System.out.println("check size before (0): " + queue.getSize());
		System.out.println("add: 1");
		queue.add(1);
		System.out.println("add: 2");
		queue.add(2);
		System.out.println("add: 3");
		queue.add(3);
		System.out.println("check size after (3): " + queue.getSize());
		
		// Test remove
		System.out.println("\nTest Remove");
		System.out.println("check size before (3): " + queue.getSize());
		System.out.println("remove (3): " + queue.remove());
		System.out.println("remove (2): " + queue.remove());
		System.out.println("remove (1): " + queue.remove());
		System.out.println("check size after (0): " + queue.getSize());
		
		// Test peek
		System.out.println("\nTest Peek");
		System.out.println("add: 1");
		queue.add(1);
		System.out.println("peek (1): " + queue.peek());
		System.out.println("add: 2");
		queue.add(2);
		System.out.println("peek (2): " + queue.peek());
		System.out.println("add: 3");
		queue.add(3);
		System.out.println("peek (3): " + queue.peek());
		
		// Test isEmpty
		System.out.println("\nTest isEmpty");
		System.out.println("isEmpty (false): " + queue.isEmpty());
		System.out.println("clear");
		queue.clear();
		System.out.println("isEmpty (true): " + queue.isEmpty());
		
		// Test clear
		System.out.println("\nTest Clear");
		System.out.println("check size before (3): " + queue.getSize());
		System.out.println("clear");
		queue.clear();
		System.out.println("check size after (0): " + queue.getSize());
		
		// Test getSize
		System.out.println("\nTest getSize");
		System.out.println("getSize (0): " + queue.getSize());
		System.out.println("add: 1");
		queue.add(1);
		System.out.println("add: 2");
		queue.add(2);
		System.out.println("add: 3");
		queue.add(3);
		System.out.println("getSize (3): " + queue.getSize());
		
		/**
		 * EXPECTED RESULTS

			Test Constructor
			NoDuplicatesPriorityQueueLinkedNodes@33c7353a
			
			Test Add
			check size before (0): 0
			add: 1
			add: 2
			add: 3
			check size after (3): 3
			
			Test Remove
			check size before (3): 3
			remove (3): 3
			remove (2): 2
			remove (1): 1
			check size after (0): 0
			
			Test Peek
			add: 1
			peek (1): 1
			add: 2
			peek (2): 2
			add: 3
			peek (3): 3
			
			Test isEmpty
			isEmpty (false): false
			clear
			isEmpty (true): true
			
			Test Clear
			check size before (3): 3
			clear
			check size after (0): 0
			
			Test getSize
			getSize (0): 0
			add: 1
			add: 2
			add: 3
			getSize (3): 3
		 */
	} // end class main
} // end class NoDuplicatesPriorityQueueLinkedNodesDriver
