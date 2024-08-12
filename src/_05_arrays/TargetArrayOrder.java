package _05_arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode
//1389. Create Target Array in the Given Order
public class TargetArrayOrder {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        int[] result = createTargetArray(nums, index);
        System.out.println(Arrays.toString(result));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        int[] targetArray = new int[targetList.size()];
        for (int i = 0; i < targetList.size(); i++) {
            targetArray[i] = targetList.get(i);
        }
        return targetArray;
    }

}
