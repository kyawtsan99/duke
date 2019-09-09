import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected String at;
    protected LocalDateTime formattedDueDate;
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public Event(String task, String at) {
        super(task);
        this.formattedDueDate = LocalDateTime.parse(at, formatter); // Pass the string as a parameter
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + formattedDueDate.format(formatter) + ")";
    }
}