package practice.blind75.sliding_window;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//Given a string s, find the length of the longest substring without duplicate characters.
import java.util.HashSet;
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            // If current character is not in the set, it's safe to add
            if (!set.contains(currentChar)) {
                set.add(currentChar);

                maxLength = Math.max(maxLength, right - left + 1);
                right++; // move right forward
            } else {
                // If duplicate, remove character at left and move left forward
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
