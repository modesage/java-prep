package _10_recursion._5_sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        int[] result = mergeSort(arr);
//        System.out.println(Arrays.toString(result));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //divide array into 2 parts
    //get both parts sorted via recursion
    //merge the sorted parts

    //time complexity
    //at every level N elements are being merged
    //there are log(N) no of levels
    // O(N * log(N))

    //space complexity - O(N)

    //merge sort is better in linked list, as linked list is not a continuous memory allocation like arrays
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        //inclusive and exclusive range
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;  //this pointer will be used in the first array
        int j = 0;  //this pointer will be used in the second array
        int k = 0;  //this pointer will be used in the mix array

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements

        //here it means that second array got empty first
        //so copy the remaining elements of first array
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        //here it means that first array got empty first
        //so copy the remaining elements of second array
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    //time complexity - O(N * log(N))
    //space complexity - O(N) //we were able to get rid of the left and right array, but still the temp mix array is being created
    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;

        //start is inclusive and end is exclusive
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        //here we are modifying the original array
        //from the specific starting index
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }

}