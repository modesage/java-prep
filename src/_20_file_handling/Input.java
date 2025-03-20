package _20_file_handling;

import java.io.*;
import java.util.Scanner;

class Input {

    // Method to handle different input operations
    static void input() {
        // Create a Scanner object to take user input from the console
        Scanner sc = new Scanner(System.in);

        // Prompt user to choose an operation
        System.out.print("Choose from 1, 2, 3: ");
        int choice = sc.nextInt(); // User inputs choice: 1, 2, or 3

        // Handling choice 1: Read input from console using InputStreamReader
        if(choice == 1){
            try (InputStreamReader isr = new InputStreamReader(System.in)) {
                // Prompt the user to enter some characters
                System.out.print("Enter some letters: ");
                // Read the first character
                int letters = isr.read();

                // While there are characters available to read from the input stream
                while(isr.ready()) {
                    // Print the character as a char (cast from int to char)
                    System.out.println((char) letters);
                    // Read the next character
                    letters = isr.read();
                }
                // End of input reading
                System.out.println();
            } catch (IOException e) {
                // Handle IO exceptions (e.g., user input issues)
                System.out.println(e.getMessage());
            }
        }
        // Handling choice 2: Read input using BufferedReader (more efficient for line-based input)
        else if (choice == 2) {
            // Byte to character stream: InputStreamReader and BufferedReader work with character-based input
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                // Read an entire line of text from the user
                System.out.println("You typed: " + br.readLine());
            } catch (IOException e) {
                // Handle IO exceptions (e.g., issues during reading input)
                System.out.println(e.getMessage());
            }
        }
        // Handling choice 3: Read content from a file
        else{
            // Read file using FileReader (Character-based stream)
            try (FileReader fr = new FileReader("src/_20_file_handling/note.txt")) {
                // Read the first character from the file
                int letters = fr.read();

                // Read the rest of the file until EOF (end-of-file) is reached
                while(fr.ready()) {
                    // Print each character read from the file
                    System.out.println((char)letters);
                    // Read the next character from the file
                    letters = fr.read();
                }
                System.out.println(); // End of file reached
            } catch (IOException e) {
                // Handle IO exceptions (e.g., file not found or read errors)
                System.out.println(e.getMessage());
            }

            // Using BufferedReader for more efficient line-based reading from file
            try (BufferedReader br = new BufferedReader(new FileReader("src/_20_file_handling/note.txt"))) {
                // Read and print the content of the file line by line
                while (br.ready()) {
                    System.out.println(br.readLine());
                }
            } catch (IOException e) {
                // Handle IO exceptions (e.g., file not found or read errors)
                System.out.println(e.getMessage());
            }
        }
    }

    // Main method to invoke input method
    public static void main(String[] args) {
        input(); // Call the input method to start the process
    }
}
