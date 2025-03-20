package _20_file_handling;

import java.io.*;

class Output {

    // Method for handling various output operations
    static void output() {
        // OutputStream used for writing data to the console (System.out)
        OutputStream os = System.out;

        // Using OutputStreamWriter to convert bytes into characters with UTF-8 encoding
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8")) {
            // Writing a string to the output stream
            osw.write("Hello World");

            // Writing a newline character (ASCII 10 corresponds to '\n')
            osw.write(10); // Writes newline

            // Writing the character 'a' (ASCII code 97)
            osw.write(97); // Writes 'a'

            // Writing another newline character
            osw.write(10); // Writes newline

            // Writing a character 'A' directly to the stream
            osw.write('A');

            // Writing a newline using '\n' character
            osw.write('\n');

            // Converting a string to a character array and writing it to the stream
            char[] arr = "hello world".toCharArray();
            osw.write(arr);

            // Writing an emoji using a Unicode escape sequence
            osw.write("\uD83D\uDE0D"); // Unicode for the "heart eyes" emoji (😍)
        } catch (IOException e) {
            // Handling IOException (e.g., if there are issues with the output stream)
            System.out.println(e.getMessage());
        }

        // Writing content to a file using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/_20_file_handling/note.txt"))) {
            // Writing a string to the file
            bw.write("blueGEM\n");
        } catch (IOException e) {
            // Handling IOException (e.g., if the file can't be opened or written to)
            System.out.println(e.getMessage());
        }

        // Appending content to the same file using FileWriter
        try (FileWriter fw = new FileWriter("src/_20_file_handling/note.txt", true)) {
            // Writing additional content to the file, the 'true' flag ensures it's appended
            fw.write("this should be appended");
        } catch (IOException e) {
            // Handling IOException (e.g., if the file can't be opened or written to)
            System.out.println(e.getMessage());
        }
    }

    // Main method to execute the output method
    public static void main(String[] args) {
        output(); // Calling the output method to execute the operations
    }
}
