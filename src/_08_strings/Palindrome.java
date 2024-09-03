package _08_strings;

public class Palindrome {
    public static void main(String[] args) {
        String input = " abc cba --=+";
        System.out.println(checkPalindrome(input));
    }
    static boolean checkPalindrome(String input){
        if (input == null || input.isEmpty()) {
            return true;
        }
        //this replaces the elements which are not in the regex to empty
        //and then converts the cleaned input to lowercase for case-insensitivity
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = cleanedInput.length() - 1;
        while(start <= end){
            if(cleanedInput.charAt(start) != cleanedInput.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
