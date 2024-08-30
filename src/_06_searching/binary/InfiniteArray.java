package _06_searching.binary;
//finding an element in an "infinite" array where you can't know the bounds beforehand.
//so assume you cant use the array length method
public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,6,9,11,23,34,45,56,67,78,89,99,101};
        int target = 34;
        System.out.println(ans(arr, target));
    }
    static int ans(int[] arr, int target) {
        // first find the range
        // start with a box of size 2
        // range [start, end] where end starts at 1
        int start = 0;
        int end = 1;

        // expand the range until target is within the range
        while (target > arr[end]) {
            int temp = end + 1; // move start
            // double the box value
            // end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        // perform binary search in the identified range
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid; //target found
            }
        }
        return -1; //target not found
    }
}
