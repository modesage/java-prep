package _07_sorting.radix;

import java.util.*;

class RadixSort {
    // Main method to perform Radix Sort
    public static void radixSort(int[] arr) {
        // Find the maximum number in the array to determine the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Perform count sort for every digit place starting from the least significant digit (LSD)
        // We increase the exponent by powers of 10 (1, 10, 100, 1000, etc.)
        for(int exp = 1; max/exp > 0; exp *= 10) {
            countSort(arr, exp);  // Perform count sort based on the current digit (exp)
        }
    }

    // Helper method to perform count sort based on a specific digit place (exp)
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;  // Length of the input array
        int[] output = new int[n];  // Array to store the sorted output
        int[] count = new int[10];  // Count array to store the frequency of digits (0-9)

        // Initialize the count array with zeros
        Arrays.fill(count, 0);

        // Count the occurrences of each digit in the input array at the current digit place (exp)
        for(int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;  // Extract the digit at the current place and update the count
        }

        // Print the count array after counting the digits at the current place
        System.out.println("\nCount array for exp " + exp + " : " + Arrays.toString(count));

        // Update the count array by calculating the cumulative sum
        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];  // This gives the position of the current digit in the output array
        }

        // Print the updated count array showing the cumulative sum
        System.out.println("Updated count array " + Arrays.toString(count));

        // Build the output array using the count array (placing elements in sorted order)
        // Start from the end of the original array to ensure stable sorting
        for(int i = n - 1; i >= 0; i--) {
            // Find the correct position for the current element based on its digit at place `exp`
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];

            // Decrease the count for the current digit since we have placed this element in the output array
            count[(arr[i] / exp) % 10]--;
        }

        // Print the output array after sorting by the current digit place
        System.out.println("Output array after sorting by exp " + exp + ": " + Arrays.toString(output));

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Main method to test the Radix Sort implementation
    public static void main(String[] args) {
        // Example input array to be sorted
        int[] arr = {29, 83, 471, 36, 91, 8};

        // Print the original array
        System.out.println("Original array: " + Arrays.toString(arr));

        // Perform Radix Sort on the input array
        radixSort(arr);

        // Print the sorted array after Radix Sort
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
