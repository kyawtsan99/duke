import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by;
    //protected LocalDateTime formattedDueDate;
    //protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Deadline(String task, String by) {
        super(task);
        this.by = by;
        //this.formattedDueDate = dueDateTime.parse(formatter);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
