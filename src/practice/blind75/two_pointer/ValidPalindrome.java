package practice.blind75.two_pointer;
//https://leetcode.com/problems/valid-palindrome/description/
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
// it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            //move towards end
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            //move towards start
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            //now check
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
