package practice.blind75.sliding_window;
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
//You are given a string s and an integer k.
// You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // to store frequency of each letter
        int maxFreq = 0; // max frequency of a single char in the window
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the count
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;

            // Update maxFreq if needed
            maxFreq = Math.max(maxFreq, count[currentChar - 'A']);

            // Check if window is valid
            int windowSize = right - left + 1;
            if (windowSize - maxFreq > k) {
                // Shrink window from the left
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
