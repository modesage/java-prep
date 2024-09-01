# Sorting Algorithms

## 1. Bubble Sort
- **Best Case Time Complexity:** \( O(n) \) (when the list is already sorted)
- **Average Case Time Complexity:** \( O(n^2) \)
- **Worst Case Time Complexity:** \( O(n^2) \)
- **Space Complexity:** \( O(1) \)
- **Stability:** Stable
- **Best Use Case:** Very small datasets. Generally not used for large datasets due to poor performance.

## 2. Selection Sort
- **Best Case Time Complexity:** \( O(n^2) \)
- **Average Case Time Complexity:** \( O(n^2) \)
- **Worst Case Time Complexity:** \( O(n^2) \)
- **Space Complexity:** \( O(1) \)
- **Stability:** Unstable
- **Best Use Case:** When memory writes are costly, as it minimizes the number of swaps. Also useful for small datasets.

## 3. Insertion Sort
- **Best Case Time Complexity:** \( O(n) \) (when the list is already sorted)
- **Average Case Time Complexity:** \( O(n^2) \)
- **Worst Case Time Complexity:** \( O(n^2) \)
- **Space Complexity:** \( O(1) \)
- **Stability:** Stable
- **Best Use Case:** Small datasets or partially sorted lists. Efficient for datasets that are already mostly sorted.

## 4. Merge Sort
- **Best Case Time Complexity:** \( O(n log n) \)
- **Average Case Time Complexity:** \( O(n log n) \)
- **Worst Case Time Complexity:** \( O(n log n) \)
- **Space Complexity:** \( O(n) \) (due to extra space required for merging)
- **Stability:** Stable
- **Best Use Case:** When stable sorting is required and large datasets are involved. Suitable for linked lists as well.

## 5. Quick Sort
- **Best Case Time Complexity:** \( O(n log n) \)
- **Average Case Time Complexity:** \( O(n log n) \)
- **Worst Case Time Complexity:** \( O(n^2) \) (when the pivot selection is poor)
- **Space Complexity:** \( O(log n) \) (for recursion stack)
- **Stability:** Unstable
- **Best Use Case:** General-purpose sorting. Often used due to its average-case efficiency and low space requirements compared to merge sort.

## 6. Heap Sort
- **Best Case Time Complexity:** \( O(n log n) \)
- **Average Case Time Complexity:** \( O(n log n) \)
- **Worst Case Time Complexity:** \( O(n log n) \)
- **Space Complexity:** \( O(1) \)
- **Stability:** Unstable
- **Best Use Case:** When a guaranteed \( O(n log n) \) time complexity is needed and memory usage needs to be minimized. Useful when dealing with large datasets.

## 7. Counting Sort
- **Best Case Time Complexity:** \( O(n + k) \)
- **Average Case Time Complexity:** \( O(n + k) \)
- **Worst Case Time Complexity:** \( O(n + k) \)
- **Space Complexity:** \( O(k) \) (where \( k \) is the range of the input values)
- **Stability:** Stable
- **Best Use Case:** When dealing with a limited range of integers or characters. Efficient for scenarios where the range of elements is not significantly larger than the number of elements.

## 8. Radix Sort
- **Best Case Time Complexity:** \( O(n * k) \) (where \( k \) is the number of digits or bits)
- **Average Case Time Complexity:** \( O(n * k) \)
- **Worst Case Time Complexity:** \( O(n * k) \)
- **Space Complexity:** \( O(n + k) \)
- **Stability:** Stable
- **Best Use Case:** Suitable for sorting integers or strings of fixed length. Effective when the number of digits (or the range) is not excessively large.

## 9. Bucket Sort
- **Best Case Time Complexity:** \( O(n + k) \)
- **Average Case Time Complexity:** \( O(n + k) \)
- **Worst Case Time Complexity:** \( O(n^2) \) (depends on the bucket sort strategy)
- **Space Complexity:** \( O(n + k) \)
- **Stability:** Stable (if the internal sorting algorithm is stable)
- **Best Use Case:** When input is uniformly distributed over a range. Efficient when sorting floating-point numbers or when the range of values is known.

## 10. Shell Sort
- **Best Case Time Complexity:** \( O(n log n) \) (depends on the gap sequence used)
- **Average Case Time Complexity:** \( O(n^{3/2}) \) or \( O(n^{4/3}) \)
- **Worst Case Time Complexity:** \( O(n^2) \) (for simple gap sequences)
- **Space Complexity:** \( O(1) \)
- **Stability:** Unstable
- **Best Use Case:** Useful for medium-sized datasets and where implementation simplicity is preferred.
