package _10_recursion._7_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//Google
public class LetterCombinations {
    public static void main(String[] args) {
//        pad("","91");
//        System.out.println(padList("","12"));
//        System.out.println(padCount("","12"));
        System.out.println((letterCombinations("23")));
    }

    //if we had digits from 1-9
    //1-abc     2-def   3-ghi   4-jkl   5-mno   6-pqr   7-stu   8-vwx   9-yz
    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; //this will convert '2' to 2
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            if(i == 26){
                return;
            }
            char ch = (char)('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    //if we had digits from 2-9
    //2-abc     3-def   4-ghi   5-jkl   6-mno   7-pqrs   8-tuv   9-wxyz
    // Mapping from digit to corresponding letters
    private static final String[] MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // Base case: if the input is empty, return an empty list
        if (digits.isEmpty()) {
            return result;
        }
        // Start with an empty string in the result list
        result.add("");
        // Iterate over each digit in the input string
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0'; // Get the current digit as an integer
            String letters = MAPPING[digit]; // Get the letters for the current digit
            List<String> newResult = new ArrayList<>();
            // For each current combination, append each character from the current digit's letters
            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    newResult.add(combination + letter); // Add the new combination
                }
            }
            // Update the result list to the newly formed combinations
            result = newResult;
        }
        return result;
    }

    //if we had digits from 1-9
    //1-abc     2-def   3-ghi   4-jkl   5-mno   6-pqr   7-stu   8-vwx   9-yz
    //returning list
    static ArrayList<String> padList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; //this will convert '2' to 2
        ArrayList<String> list = new ArrayList<>();
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char)('a' + i);
            list.addAll(padList(p + ch, up.substring(1)));
        }
        return list;
    }
    //if we had digits from 1-9
    //1-abc     2-def   3-ghi   4-jkl   5-mno   6-pqr   7-stu   8-vwx   9-yz
    //returning count
    static int padCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int digit = up.charAt(0) - '0'; //this will convert '2' to 2
        int count = 0;
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char)('a' + i);
            count += padCount(p + ch, up.substring(1));
        }
        return count;
    }
}
