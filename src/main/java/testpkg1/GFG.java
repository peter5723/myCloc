package testpkg1;

// Java Program Illustrating Reading a File to a String
// Using readLine() method of BufferReader class

// Importing required classes
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// MAin class
public class GFG {

    // Method 1
    // To read file content into the string
    // using BufferedReader and FileReader
    private static String method(String filePath)
    {

        // Declaring object of StringBuilder class
        StringBuilder builder = new StringBuilder();

        // try block to check for exceptions where
        // object of BufferedReader class us created
        // to read filepath
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;

            // Condition check via buffer.readLine() method
            // holding true upto that the while loop runs
            while ((str = buffer.readLine()) != null) {

                builder.append(str).append("\n");
            }
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Print the line number here exception occurred
            // using printStackTrace() method
            e.printStackTrace();
        }

        // Returning a string
        return builder.toString();
    }

    // Method 2
    // Main driver method
    public static void main(String[] args)
    {

        // Custom input file path stored in string type
        String filePath = "C:\\Users\\Peter\\作业\\高程\\多态.md";

        // Calling the Method 1 to
        // read file to a string
        System.out.println(method(filePath));
    }
}

