package _02_first_java;

import java.text.Normalizer;
import java.util.Scanner;

//To find out whether the given String is Palindrome or not.
public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.nextLine();

        boolean palindrome = true;

        //decomposes characters into their base characters and combining marks
        //example the character é would be decomposed into e followed by an accent mark
        String cleanedStr = Normalizer.normalize(str, Normalizer.Form.NFD)
                //remove accents
                .replaceAll("[\\p{M}]", "")
                //remove non-alphanumeric characters
                .replaceAll("[^a-zA-Z0-9]", "")
                //converts the string to lowercase to ensure case insensitivity
                .toLowerCase();

        char[] charArr = cleanedStr.toCharArray();

        int strLength = cleanedStr.length();
        int operations = 0;

        if(strLength % 2 != 0){
            operations = (int) Math.floor((double) strLength/2);
        }
        else{
            operations = strLength/2;
        }

        for(int i = 0; i < operations; i++){
            if(charArr[i] != charArr[strLength-(i+1)]){
                palindrome = false;
                System.out.println("Not a Palindrome!");
                break;
            }
        }

        if(palindrome){
            System.out.println("Palindrome!");
        }
    }
}
