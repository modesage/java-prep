package _10_recursion._3_array;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args){
        int[] arr = {5,1,2,5,3,4,5,6,12,41,5};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(multipleElementOccurIndex(arr,0,5,list));
//        int result = elementIndex(arr,0,6);
//        System.out.println(result);
    }
    static int elementIndex(int[] arr, int index, int element){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == element){
            return index;
        }
        return elementIndex(arr,++index,element);
    }

    static ArrayList multipleElementOccurIndex(int[] arr, int index, int element, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == element){
            list.add(index);
        }
        return multipleElementOccurIndex(arr,++index,element, list);
    }
}

