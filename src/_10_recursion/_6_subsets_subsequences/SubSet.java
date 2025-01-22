package _10_recursion._6_subsets_subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Subsets are present in arrays.
// A subset is any collection of elements, which can include both adjacent and non-adjacent elements.

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr2 = {1, 2, 2};
//        List<List<Integer>> ans = subset(arr);
        List<List<Integer>> ans2 = subsetDuplicate(arr2);
        for (List<Integer> list : ans2) {
            System.out.println(list);
        }
    }

    //time taken at each level * total no of levels
    //as we are copying N elements
    //N is the total no of elements in the array
    //2^N total no of subsets we will have or total no of levels
    //time complexity - O(N * 2^N)

    //space complexity/auxilary space
    //O(2^N * N)  => O(total subsets * space taken by each subset)

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    //when found a duplicate element then only add it in the newly created subset of prev step
    //because of above point duplicates have to be together, else it will get super complex
    //not taking the duplicate subsets

    //both time and space complexity are the same as above
    //as the theory is changed but not the algo in core
    //so O(N * 2^N)
    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same, s = e + 1
            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
