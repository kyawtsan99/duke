import java.sql.SQLOutput;
import java.util.Scanner; // Import the Scanner class
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Duke {

    // Drawing of the horizontal line
    private static final String LINE = "____________________________________________________________ \n";

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
                System.out.println(LINE);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(LINE);
                stringComparison = false; // exits the loop
            }

            // list
            else if (userInput.equals("list")) {
                System.out.println(LINE);
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < arr.size(); i++) {
                    System.out.println( (i + 1) + ". " + arr.get(i).toString() ); // iterates through the entire array
                }
                System.out.println(LINE);
            }

            else {
                String[] splitArr = userInput.split(" ", 2); // splits the string by the white spaces
                String firstWord = splitArr[0]; // obtains the first word of the string
                String secondWord = splitArr[1]; // obtains the rest of the word

                switch(firstWord) {
                    // done
                    case "done":
                        int num = Integer.parseInt(secondWord); // converts string into int
                        arr.get(num - 1).taskIsDone();
                        System.out.println(LINE);
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(arr.get(num - 1).toString());
                        System.out.println(LINE);
                        break;

                        // to do
                    case "todo":
                        Todo newTodo = new Todo(secondWord);
                        arr.add(newTodo);

                        System.out.println(LINE);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(arr.get(arr.size() - 1).toString());
                        // If there is only 1 task
                        if (arr.size() == 1) {
                            System.out.println("Now you have 1 task in the list.");
                        }
                        // If there is more than 1 task
                        else {
                            System.out.println("Now you have " + arr.size() + " tasks in the list.");
                        }
                        System.out.println(LINE);
                        break;

                        // deadline
                    case "deadline":
                        String[] splitDeadlineArr = secondWord.split("/", 2); // splits the string by the "/"
                        String deadlineTask = splitDeadlineArr[0];
                        String[] splitDeadlineArr1 = splitDeadlineArr[1].split(" ", 2); // splits the string by the " "
                        String deadlineDate = splitDeadlineArr1[1];
                        Deadline newDeadline = new Deadline(deadlineTask, deadlineDate);
                        arr.add(newDeadline);

                        System.out.println(LINE);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(arr.get(arr.size() - 1).toString());
                        // If there is only 1 task
                        if (arr.size() == 1) {
                            System.out.println("Now you have 1 task in the list.");
                        }
                        // If there is more than 1 task
                        else {
                            System.out.println("Now you have " + arr.size() + " tasks in the list.");
                        }
                        System.out.println(LINE);
                        break;

                        // event
                    case "event":
                        String[] splitEventArr = secondWord.split("/", 2); // splits the string by the "/"
                        String eventTask = splitEventArr[0];
                        String[] splitEventArr1 = splitEventArr[1].split(" ", 2); // splits the string by the " "
                        String eventDate = splitEventArr1[1];
                        Event newEvent = new Event(eventTask, eventDate);
                        arr.add(newEvent);

                        System.out.println(LINE);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(arr.get(arr.size() - 1).toString());
                        // If there is only 1 task
                        if (arr.size() == 1) {
                            System.out.println("Now you have 1 task in the list.");
                        }
                        // If there is more than 1 task
                        else {
                            System.out.println("Now you have " + arr.size() + " tasks in the list.");
                        }
                        System.out.println(LINE);
                        break;
                }
            }
        }
    }
}
