package _21_heaps;

import java.util.ArrayList;

// Generic Heap class that works for any type T that extends Comparable<T>
public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list; // Internal list to store heap elements

    // Constructor to initialize the heap as an empty list
    public Heap() {
        list = new ArrayList<>();
    }

    public int size(){
        return list.size();
    }

    // Utility method to swap two elements in the list
    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    // Returns the index of the parent of the node at the given index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Returns the index of the left child of the node at the given index
    private int left(int index) {
        return index * 2 + 1;
    }

    // Returns the index of the right child of the node at the given index
    private int right(int index) {
        return index * 2 + 2;
    }

    // Insert a new value into the heap and ensure the heap property is maintained
    public void insert(T value) {
        list.add(value); // Add the element at the end of the heap
        upheap(list.size() - 1); // Restore the heap property by moving the element up if necessary
    }

    // Restore the heap property by "bubbling up" the element at the given index
    private void upheap(int index) {
        if (index == 0) {
            return; // Root element, no need to move up
        }

        int p = parent(index); // Get the index of the parent node
        // If the current element is smaller than the parent, swap them
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p); // Swap current node with its parent
            upheap(p); // Continue upheap process on the parent index
        }
    }

    // Remove and return the root element (minimum in a min-heap)
    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!"); // Can't remove from an empty heap
        }

        T temp = list.get(0); // Store the root element (min in a min-heap)

        T last = list.remove(list.size() - 1); // Remove the last element in the heap
        if (!list.isEmpty()) {
            list.set(0, last); // Move the last element to the root
            downheap(0); // Restore the heap property by moving the element down
        }

        return temp; // Return the root element (min in a min-heap)
    }

    // Restore the heap property by "bubbling down" the element at the given index
    private void downheap(int index) {
        int min = index; // Assume the current index is the smallest
        int left = left(index); // Left child index
        int right = right(index); // Right child index

        // If left child exists and is smaller than the current element, update min index
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        // If right child exists and is smaller than the current element, update min index
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        // If min is not the current index, swap the current element with the smallest child
        if (min != index) {
            swap(min, index); // Swap with the smallest of the children
            downheap(min); // Continue downheap process on the child index
        }
    }

    // Perform heap sort by repeatedly removing the root element (min) and placing it in a sorted list
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        // Remove the root element until the heap is empty, storing the removed elements
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data; // Return the sorted list
    }
}
