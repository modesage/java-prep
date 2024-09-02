package _07_sorting.cyclic;

import java.util.Arrays;
//Amazon
//leetcode
//268. Missing Number
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        cyclic(arr);
        int result = check(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("not in array: " + result);
    }
    static void cyclic(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if(correct != arr.length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    private static int check(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i) return i;
        }
        return arr.length;
    }

}
