import java.sql.SQLOutput;
import java.util.Scanner; // Import the Scanner class
import java.io.*;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        Scanner input = new Scanner(System.in); // Create a Scanner object
        boolean stringComparison = true;
        int n = 0;
        String[] arr = new String[100]; // Declaring the size of the string array to 100

        while (stringComparison) {
            String userInput = input.nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                stringComparison = false;
            } else if (userInput.equals("list")) {
                for (int i = 0; i < n; i++) {
                    String x = arr[i];
                    System.out.println( (i + 1) + ". " + x); // iterates through the entire array
                }
            } else {
                arr[n] = userInput; // adds tasks into the array
                System.out.println("added: " + userInput);
                n++;
            }
        }
    }
}
