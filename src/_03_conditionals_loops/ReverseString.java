package _03_conditionals_loops;

import java.util.Scanner;

//reverse a string entered by the user
public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        char[] arr = text.trim().toCharArray();
        StringBuilder reversedStr = reverseStr(arr);
        System.out.println("Reversed String: " + reversedStr);
    }
    public static StringBuilder reverseStr(char[] arr){
        StringBuilder reversedStr = new StringBuilder();
        int arrLength = arr.length;
        for (int i = arrLength-1; i > -1 ; i--) {
            reversedStr.append(arr[i]);
        }
        return reversedStr;
    }
}
