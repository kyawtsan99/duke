import java.sql.SQLOutput;
import java.util.Scanner; // Import the Scanner class
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        Scanner input = new Scanner(System.in); // Create a Scanner object
        boolean stringComparison = true;

        ArrayList<Task> arr = new ArrayList<Task>(); // Creating array list

        while (stringComparison) {
            String userInput = input.nextLine();
            // bye
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                stringComparison = false; // exits the loop
            }
            // list
            else if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < arr.size(); i++) {
                    System.out.print( (i + 1) + ". " ); // iterates through the entire array
                    arr.get(i).listOutput();
                }
            }
            else {
                String[] splitArr = userInput.split(" "); // splits the string by the white spaces
                String firstWord = splitArr[0]; // obtains the first word of the string

                // done
                if (firstWord.equals("done")) {
                    String secondWord = splitArr[1]; // obtains the number after done
                    int num = Integer.parseInt(secondWord); // converts string into int
                    arr.get(num - 1).taskIsDone();
                    arr.get(num - 1).doneOutput();
                }
                // add
                else {
                    Task newTask = new Task(userInput);
                    arr.add(newTask);
                    //arr.add(userInput); // adds tasks into the array
                    System.out.println("added: " + userInput);
                }
            }
        }
    }
}
