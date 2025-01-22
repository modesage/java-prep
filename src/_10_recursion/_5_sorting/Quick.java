package _10_recursion._5_sorting;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        //for non-primitive types (such as Integer[], String[], etc.), Java uses Timsort.
        // This is because Timsort is highly efficient for sorting objects,
        // particularly when the data is partially sorted or contains long runs of ordered elements.

        //Timsort is a hybrid sorting algorithm that combines merge sort and insertion sort.
        //It leverages merge sort for merging larger chunks of data
        //and insertion sort for efficiently handling small or partially sorted subarrays.
        // Sorting an array of non-primitives (Integer[])
        Integer[] arr2 = {5, 4, 3, 2, 1};
        Arrays.sort(arr2);  // Uses Timsort
        System.out.println("Sorted Integer[]: " + Arrays.toString(arr2));

        //for primitive types (such as int[], char[], etc.)
        //java uses here Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch is being used
        // This algorithm offers O(n log(n)) performance on all data sets,
        // and is typically faster than traditional (one-pivot) Quicksort implementations.
        // Sorting an array of primitives (int[])
        int[] arr1 = {5, 4, 3, 2, 1};
        Arrays.sort(arr1);  // Uses Dual-Pivot Quicksort
        System.out.println("Sorted int[]: " + Arrays.toString(arr1));
    }

    //choose any pivot element, after first pass
    //put the elements < pivot to the LHS of pivot
    //put the elements > Pivot to the RHS of pivot
    //so after every pass the pivot element will be at the correct position

    //pick the pivot based on - random element or corner element or middle element
    //then that condition needs to the same for all the recursion calls

    //time complexity - best case - O(n log(n)), worst case - O(n^2)

    //not stable
    //in-place as we are not taking extra mix array like taken in merge sort
    //so no auxilary space, but recursion stack space will be there which is inevitable
    //so quick sort is preferred for arrays instead of merge sort as it take O(n) extra space

    //here the low and high is determining the range to work in
    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        //start and end is used to swap
        int s = low;
        int e = hi;
        //we are taking the middle element as pivot
        int m = s + (e - s) / 2; //finding the index
        int pivot = nums[m]; //putting the value

        while (s <= e) {
            // this is also a reason if its already sorted it will not swap
            while (nums[s] < pivot) { //if the number smalled than pivot is at left side of pivot
                s++; //next position
            }
            while (nums[e] > pivot) { //if the number greater than pivot is at right side of pivot
                e--; //next position
            }
            //here both start and end have violated the condition
            //so swap both
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }
}