import java.sql.SQLOutput;

public class Task {
    protected String task;
    protected boolean isDone;

    public Task(String task) {
        this.task = task;
        this.isDone = false;
    }

    public void taskIsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); // return tick or X symbols
    }

    public void doneOutput() {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + this.getStatusIcon() + "] " + this.task);
    }

    /*public void listOutput() {
        System.out.println("[" + this.getStatusIcon() + "] " + this.task);
    }*/

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.task;
    }

}
