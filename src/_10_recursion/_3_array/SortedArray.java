package _10_recursion._3_array;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {-100,-1,2,3,4,4,5};
        boolean result = checkAscSorted(arr,0);
        System.out.println(result);
    }
    static boolean checkAscSorted(int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }
        if(arr[index] > arr[index+1]){
            return false;
        }
        return checkAscSorted(arr, ++index);
    }
}
