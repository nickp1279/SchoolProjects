/**
 * This is the driver class that will test all the methods associated
 * with the ArrayUtility class.
 * @author Nick Pieroni
 */
public class ArrayUtilityDriver {
	
	public static void main(String[] args) {
		ArrayUtility arrayUtility = new ArrayUtility();
		
		// test add method
		System.out.println("Add an integer: " + arrayUtility.add(1));
		
		// test add at index method
		System.out.println("Add an integer to an index: " + arrayUtility.add(2, 1));
		
		// test clear method
		System.out.println("Clear array. ");
		arrayUtility.clear();
		System.out.println("Is clear: " + arrayUtility.isEmpty());
		
		// test contains method
		System.out.println("Add 1 and 2: " + arrayUtility.add(1) + " " + arrayUtility.add(2));
		System.out.println("Contains 1: " + arrayUtility.contains(1));
		System.out.println("Contains 3: " + arrayUtility.contains(3));
		
		// test get method
		System.out.println("Get index 0: " + arrayUtility.get(0));
		System.out.println("Get index 1: " + arrayUtility.get(1));
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
		
		// test get current size method
		System.out.println("Get current size: " + arrayUtility.getCurrentSize());
		
		// test get frequency of method
		System.out.println("Add 1 to index 2: " + arrayUtility.add(1, 2));
		System.out.println("Get frequency of 1: " + arrayUtility.getFrequencyOf(1));
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
		
		// test index of method
		System.out.println("Index of element 2: " + arrayUtility.indexOf(2));
		System.out.println("Index of 3: " + arrayUtility.indexOf(5));
		
		// test is empty method
		System.out.println("Is empty: " + arrayUtility.isEmpty());
		System.out.println("Clear array.");
		arrayUtility.clear();
		System.out.println("Is empty: " + arrayUtility.isEmpty());
		
		// test remove method
		System.out.println("Add 1 to the array: " + arrayUtility.add(1));
		System.out.println("Add 2 to the array: " + arrayUtility.add(2));
		System.out.println("Remove 1: " + arrayUtility.remove(1));
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
		
		// test remove first method
		System.out.println("Add 1 to index 0: " + arrayUtility.add(1, 0));
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
		System.out.println("Remove first element: " + arrayUtility.removeFirst());
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
		
		// test remove last method
		System.out.println("Add 1 to index 9: " + arrayUtility.add(1, 9));
		System.out.println("Remove last element: " + arrayUtility.removeLast());
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
		
		// test remove middle method
		System.out.println("Add 1 to index 0: " + arrayUtility.add(1, 0));
		for (int i = 2; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			System.out.println("Add " + (i + 1) + " to index " + i + ": " + arrayUtility.add(i + 1, i));
		}
		System.out.println("Remove middle: " + arrayUtility.removeMiddle());
		System.out.println("See array contents below: ");
		for (int i = 0; i < ArrayUtility.DEFAULT_CAPACITY; i++) {
			
			if (arrayUtility.get(i) != null) {
				System.out.print(arrayUtility.get(i) + ", ");
			}
		}
		System.out.println();
	}
}
