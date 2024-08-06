package _03_conditionals_loops;

import java.util.Scanner;

//check if the given year is leap year or not
public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if(year <= 0) System.out.println("Enter a valid year!");
        else {
            if(year % 4 != 0){
                System.out.println("Not a leap year");
            }
            else if(year % 100 == 0){
                if(year % 400 == 0){
                    System.out.println("Leap year");
                }
                else System.out.println("Not a leap year");
            }
            else System.out.println("Leap year");
        }
    }
}
