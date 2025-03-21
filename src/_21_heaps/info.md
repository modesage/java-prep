# Heaps in Java

A **heap** is a special tree-based data structure that satisfies the **heap property**. Heaps are commonly used to implement **priority queues**, where the element with the highest or lowest priority is always at the top.


# Heap Storage in Java: Array vs Tree Representation

A **heap** is typically stored as an **array**, but it is conceptually represented as a **binary tree**. This array-based storage simplifies the implementation and allows efficient heap operations.

### How Heaps are Stored as Arrays:
In an array, a heap is stored in a way that allows easy access to parent and child nodes without the need for pointers, which are used in a traditional tree structure.

#### Parent and Child Relationships:
For an element at index `i` in the array:
- **Left child** is located at index `2i + 1`
- **Right child** is located at index `2i + 2`
- **Parent** is located at index `(i - 1) / 2` (integer division)

### Why Use an Array?
- **Efficient Memory Usage**: Storing a heap in an array eliminates the need for pointers (as used in linked structures), making it more memory efficient.
- **Easy Indexing**: The relationships between nodes (parent/child) are easily computed using simple arithmetic on array indices (`2i + 1` for left child, `2i + 2` for right child, etc.).
- **Efficient Operations**: The array-based representation allows efficient implementation of heap operations like insertion and extraction, both of which are done in logarithmic time (`O(log n)`).

### Operations and Array Representation:

- **Insertion**: Insert the new element at the end of the array (preserving the complete binary tree property) and then "bubble it up" to restore the heap property.
- **Extraction**: Remove the root element (the first element in the array), replace it with the last element in the array, and "heapify" to restore the heap property.


### Types of Heaps:
1. **Max-Heap**:
    - In a max-heap, the value of each parent node is greater than or equal to the values of its children.
    - The root node contains the maximum element in the heap.

2. **Min-Heap**:
    - In a min-heap, the value of each parent node is less than or equal to the values of its children.
    - The root node contains the minimum element in the heap.

### Key Characteristics of a Heap:
- **Binary Tree**: A heap is a binary tree, meaning each node has at most two children.
- **Complete Binary Tree**: Heaps are complete binary trees, meaning all levels are fully filled, except possibly for the last level, which is filled from left to right. This ensures that the heap remains balanced.
- **Heap Property**:
    - **Max-Heap**: Each parent node's value is greater than or equal to its children's values.
    - **Min-Heap**: Each parent node's value is less than or equal to its children's values.

### Operations on Heaps:
1. **Insertion**:
    - A new element is added to the heap at the last position (preserving the complete binary tree property).
    - The heap property is restored by "bubbling up" the new element.
    - **Time Complexity**: `O(log n)` because in the worst case, the new element might have to move from the leaf to the root.

2. **Extraction (Removing the Root)**:
    - The root element (maximum in a max-heap or minimum in a min-heap) is removed.
    - To restore the heap property, the last element is moved to the root and "heapified" (the element is moved down to its correct position).
    - **Time Complexity**: `O(log n)` because the heap property needs to be restored, and this involves moving down through the height of the tree.

3. **Peek**:
    - The root element is returned without removing it. This operation simply accesses the root.
    - **Time Complexity**: `O(1)` because it's just accessing the root node.

4. **Heapify**:
    - Heapify is used to convert an unsorted array into a heap. It can be done by iterating over the elements in reverse order and applying the "heapify down" operation.
    - **Time Complexity**: `O(n)` because it takes linear time to process all elements when building the heap.

### Time Complexity Summary:
| Operation        | Time Complexity |
|------------------|-----------------|
| **Insertion**     | O(log n)        |
| **Extraction**    | O(log n)        |
| **Peek**          | O(1)            |
| **Heapify**       | O(n)            |
| **Build Heap**    | O(n)            |

### Example Usage:
- **Priority Queue**: A priority queue is often implemented using a heap, where the element with the highest (or lowest) priority is always accessible at the root.
- **Heap Sort**: A sorting algorithm that repeatedly extracts the maximum (or minimum) element from the heap and places it in its correct position in the sorted array.

### Java Implementation:

#### Min-Heap Example (default):
```java
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a min-heap (default in PriorityQueue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(15);

        // Extract elements (will be in increasing order)
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
