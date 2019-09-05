import java.util.Scanner; // Import the Scanner class
import java.io.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Duke {

    // Drawing of the horizontal line
    private static final String LINE = "____________________________________________________________ \n";
    private static ArrayList<Task> arr = new ArrayList<Task>(); // Creating array list


    private static void saveFile() {
        try {
            FileOutputStream savedFile = new FileOutputStream("C:\\Users\\sanwy\\duke\\src\\main\\java\\SavedFile.txt");
            ObjectOutputStream save = new ObjectOutputStream(savedFile);
            save.writeObject(arr);
            save.close();
            savedFile.close();

            System.out.println("File successfully saved!");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    private static void readFile() {
        try {
            FileInputStream savedFile1 = new FileInputStream("C:\\Users\\sanwy\\duke\\src\\main\\java\\SavedFile.txt");
            ObjectInputStream save1 = new ObjectInputStream(savedFile1);
            arr = (ArrayList) save1.readObject();

            save1.close();
            savedFile1.close();

            /*for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i).toString()); // iterates through the entire array
            }*/
            System.out.println("File successfully read!");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        Scanner input = new Scanner(System.in); // Create a Scanner object
        boolean stringComparison = true;
        readFile();

            while (stringComparison) {
                String userInput = input.nextLine();

                // BYE
                if (userInput.equals("bye")) {
                    System.out.println(LINE);
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println(LINE);
                    stringComparison = false; // exits the loop
                }

                // LIST
                else if (userInput.equals("list")) {
                    System.out.println(LINE);
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < arr.size(); i++) {
                        System.out.println((i + 1) + ". " + arr.get(i).toString()); // iterates through the entire array
                    }
                    System.out.println(LINE);
                }

                // DONE
                else if (userInput.startsWith("done")) {
                    String[] splitArr = userInput.split(" ");

                    try {
                        if (splitArr.length == 1) {
                            throw new noInfoCommandException();
                        } else {
                            String done = splitArr[0];
                            String doneNumString = splitArr[1];
                            int doneNum = Integer.parseInt(doneNumString); // converts string into
                            if (doneNum > arr.size() || doneNum < 0) {
                                throw new IndexOutOfBoundsException();
                            } else {
                                arr.get(doneNum - 1).taskIsDone();
                                System.out.println(LINE);
                                System.out.println("Nice! I've marked this task as done:");
                                System.out.println(arr.get(doneNum - 1).toString());
                                System.out.println(LINE);
                            }
                            saveFile();
                        }
                    }

                    // If nothing is written after done.
                    catch (noInfoCommandException e) {
                        System.out.println(LINE);
                        e.exceptionPrint(userInput);
                        System.out.println(LINE);
                    }

                    // If the number written after done exceeds the number of tasks or is a negative number.
                    catch (IndexOutOfBoundsException e) {
                        System.out.println(LINE);
                        System.out.println("☹ OOPS!!! The number you indicated is out of bounds.");
                        System.out.println(LINE);
                    }
                }

                // TASKS
                else {
                    String[] splitArr = userInput.split(" "); // splits the string by the white spaces

                    //TO DO
                    if (userInput.startsWith("todo")) {
                        try {
                            if (splitArr.length == 1) {
                                throw new noInfoCommandException();
                            } else {
                                splitArr = userInput.split(" ", 2); // splits the string by the white spaces
                                String firstWord = splitArr[0]; // obtains the first word of the string
                                String secondWord = splitArr[1]; // obtains the rest of the word

                                Todo newTodo = new Todo(secondWord);
                                arr.add(newTodo);
                                //saveFile(arr);

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
                                saveFile();
                            }
                        }

                        // If nothing is written after to do.
                        catch (noInfoCommandException e) {
                            System.out.println(LINE);
                            e.exceptionPrint(userInput);
                            System.out.println(LINE);
                        }
                    }

                    // DEADLINE
                    else if (userInput.startsWith("deadline")) {

                        try {
                            if (splitArr.length == 1) {
                                throw new noInfoCommandException();
                            } else {
                                splitArr = userInput.split(" ", 2); // splits the string by the white spaces
                                String firstWord = splitArr[0]; // obtains the first word of the string
                                String secondWord = splitArr[1]; // obtains the rest of the word

                                String[] splitDeadlineArr = secondWord.split("/", 2); // splits the string by the "/"
                                String deadlineTask = splitDeadlineArr[0];
                                String[] splitDeadlineArr1 = splitDeadlineArr[1].split(" ", 2); // splits the string by the " "
                                String deadlineDate = splitDeadlineArr1[1];
                                Deadline newDeadline = new Deadline(deadlineTask, deadlineDate);
                                arr.add(newDeadline);
                                //saveFile(arr);

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
                                saveFile();
                            }
                        }

                        // If nothing is written after deadline.
                        catch (noInfoCommandException e) {
                            System.out.println(LINE);
                            e.exceptionPrint(userInput);
                            System.out.println(LINE);
                        }
                    }

                    // EVENT
                    else if (userInput.startsWith("event")) {
                        try {
                            if (splitArr.length == 1) {
                                throw new noInfoCommandException();
                            } else {
                                splitArr = userInput.split(" ", 2); // splits the string by the white spaces
                                String firstWord = splitArr[0]; // obtains the first word of the string
                                String secondWord = splitArr[1]; // obtains the rest of the word

                                String[] splitEventArr = secondWord.split("/", 2); // splits the string by the "/"
                                String eventTask = splitEventArr[0];
                                String[] splitEventArr1 = splitEventArr[1].split(" ", 2); // splits the string by the " "
                                String eventDate = splitEventArr1[1];
                                Event newEvent = new Event(eventTask, eventDate);
                                arr.add(newEvent);
                                //saveFile(arr);

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
                                saveFile();

                            }
                        }

                        // If nothing is written after event.
                        catch (noInfoCommandException e) {
                            System.out.println(LINE);
                            e.exceptionPrint(userInput);
                            System.out.println(LINE);
                        }
                    }

                    // Other non-valid commands
                    else {
                        System.out.println(LINE);
                        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        System.out.println(LINE);
                    }
                }

        }
    }
}
