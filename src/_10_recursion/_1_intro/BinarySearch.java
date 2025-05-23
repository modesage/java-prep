package _10_recursion._1_intro;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,9,11,23,45,67,99};
        int target = 99;
        int result = search(arr,target,0,arr.length-1);
        System.out.println("target at index: " + result);
    }
    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            return search(arr,target,start,mid-1);
        }
        return search(arr,target,mid+1,end);
    }
}
