package _07_sorting.count;

import java.util.*;

/*
For small, non-negative integer ranges (or when you know the maximum value),
the array-based method (countSort) is typically the better choice in terms of performance and memory usage.

For large, sparse, or mixed ranges (especially when negative numbers are involved),
the HashMap-based method (countSortHash) is more flexible and will handle such cases better.
 */

class CountSort {
    // Count Sort using an array to count occurrences of elements
    public static void countSort(int[] array) {
        // If array is null or has only one element, no sorting is needed
        if(array == null || array.length <= 1) {
            return;
        }

        // Find the maximum value in the array
        int max = array[0];
        for(int num : array) {
            if(num > max) {
                max = num;  // Update max if current num is larger
            }
        }

        // Create a count array where index represents each number and value represents the count
        int[] countArray = new int[max + 1];

        // Fill countArray with the occurrences of each number in the original array
        for(int num : array) {
            countArray[num]++;
        }

        // Rebuild the original array by putting the elements back in sorted order
        int index = 0;
        for(int i = 0; i <= max; i++) {
            while(countArray[i] > 0) {
                array[index] = i;  // Place the element at the correct index
                index++;
                countArray[i]--;  // Decrease the count of that element
            }
        }
    }

    // Count Sort using a HashMap to count occurrences of elements
    public static void countSortHash(int[] arr) {
        // If array is null or has only one element, no sorting is needed
        if(arr == null || arr.length <= 1) {
            return;
        }

        // Find the minimum and maximum values in the array using streams
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // Use a HashMap to store the count of each element
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count the occurrences of each number in the array
        for(int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Rebuild the array in sorted order using the countMap
        int index = 0;
        for(int i = min; i <= max; i++) {
            // Get the count for the current element, or default to 0 if not present
            int count = countMap.getOrDefault(i, 0);
            for(int j = 0; j < count; j++) {
                arr[index] = i;  // Place the element at the correct index
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,1,3,2,9,6};
//        countSort(arr);
        countSortHash(arr);
        System.out.println(Arrays.toString(arr));
    }
}
