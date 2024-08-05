package _02_first_java;

import java.util.Objects;
import java.util.Scanner;

//Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)
public class CalculateValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter number 1: ");
        double number1 = input.nextDouble();
        System.out.print("enter number 2: ");
        double number2 = input.nextDouble();
        System.out.print("enter an operator (+, -, *, /): ");
        String operator = input.next();

        double result = 0;
        boolean validOperator = false;

        if(Objects.equals(operator, "+")){
            validOperator = true;
            result = number1 + number2;
        }
        else if (Objects.equals(operator, "-")){
            validOperator = true;
            result = number1 - number2;
        }
        else if (Objects.equals(operator, "*")){
            validOperator = true;
            result = number1 * number2;
        }
        else if(Objects.equals(operator, "/")){
            if(number2 != 0){
                validOperator = true;
                result = number1 / number2;
            }
            else {
                System.out.println("Error: Division by zero!");
            }
        }
        else {
            System.out.println("Invalid Operator!");
            System.out.println("Please use the following only (+, -, *, /)");
        }

        if(validOperator){
            System.out.printf("%f %s %f = %f%n",number1, operator, number2, result);
        }

        input.close();

    }
}
