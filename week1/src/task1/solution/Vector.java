package task1.solution;

public interface Vector<T> {
	// Adds value at a specific index in the Vector.
	  // Complexity: O(n)
	  boolean insert (int index, T value);

	  // Adds value to the end of the Vector.
	  // Complexity: O(1)
	  boolean add(T value);

	  // Returns value at a specific index in the Vector
	  // Complexity: O(1)
	  T get(int index);

	  // Removes element at the specific index
	  // Complexity: O(n)
	  T remove(int index);

	  // Removes element at the last index
	  // Complexity: O(1)
	  T pop();

	  // Returns the number of elements in the Vector.
	  // Complexity: O(1)
	  int size();

	  // Returns the total capacity of the Vector.
	  // Complexity: O(1)
	  int capacity();
}
