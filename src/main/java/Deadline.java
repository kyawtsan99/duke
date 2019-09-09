import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by;
    protected LocalDateTime formattedDueDate;
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public Deadline(String task, String by) {
        super(task);
        this.formattedDueDate = LocalDateTime.parse(by, formatter); // Pass the string as a parameter
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formattedDueDate.format(formatter) + ")";
    }
}
