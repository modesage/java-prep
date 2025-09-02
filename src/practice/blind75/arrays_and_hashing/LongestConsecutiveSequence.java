package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/longest-consecutive-sequence/description/
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//You must write an algorithm that runs in O(n) time.
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            //Add all elements to the set
            hs.add(num);
        }
        int maxLength = 0;
        for(int num : hs){
            //Only start a sequence if num - 1 is not in set
            if(!hs.contains(num - 1)){
                int currentNum = num;
                int currentLength = 1;
                //Count consecutive numbers
                while(hs.contains(currentNum + 1)){
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
