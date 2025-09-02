package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/contains-duplicate/description/
//Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.
import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            if(freqMap.get(num) == null){
                freqMap.put(num, 1);
            }
            else{
                if(freqMap.get(num) == 1){
                    return true;
                }
            }
        }
        return false;
    }
}
