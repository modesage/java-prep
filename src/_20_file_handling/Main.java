package _20_file_handling;

import java.io.*;
import java.io.IOException;

class Main {
    public static void main(String[] args) {

        // Creating a new file
        try {
            // Create a new File object representing the file "new-file.txt"
            File fo = new File("src/_20_file_handling/new-file.txt");
            // Create the file if it does not already exist
            fo.createNewFile();
            // If successful, no message will be printed (silent success)
        } catch (IOException e) {
            // If there's an error creating the file (e.g., permissions issues), print the error message
            System.out.println(e.getMessage());
        }

        // Writing data to the file
        try {
            // Create a FileWriter object to write characters to "new-file.txt"
            FileWriter fw = new FileWriter("src/_20_file_handling/new-file.txt");
            // Write a string to the file (this could be any text, here in Sanskrit)
            fw.write("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज, अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुच:");
            // Close the FileWriter to flush and release system resources
            fw.close();
        } catch (IOException e) {
            // If there's an error while writing to the file, print the error message
            System.out.println(e.getMessage());
        }

        // Reading data from the file
        try (BufferedReader br = new BufferedReader(new FileReader("src/_20_file_handling/new-file.txt"))) {
            // Read each line from the file and print it
            // The BufferedReader automatically buffers the file content for more efficient reading
            while (br.ready()) {
                // Read the next line from the file and print it
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            // If there's an error reading the file (e.g., file not found), print the error message
            System.out.println(e.getMessage());
        }

        // File creation and deletion example
        try {
            // Create another File object representing "random.txt"
            File fo = new File("src/_20_file_handling/random.txt");
            // Create the file if it doesn't already exist
            fo.createNewFile();
            // If the file was successfully created, attempt to delete it
            if (fo.delete()) {
                // Print the name of the deleted file
                System.out.println(fo.getName() + " was deleted successfully.");
            }
        } catch (IOException e) {
            // If there's an error (e.g., file can't be created or deleted), print the error message
            System.out.println(e.getMessage());
        }
    }
}
