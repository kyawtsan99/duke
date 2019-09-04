public class noInfoCommandException extends Exception {
    protected String command;

    noInfoCommandException() {
        super();
    }

    public noInfoCommandException(String command) {
        super(command);
        this.command = command;
    }

    public void exceptionPrint(String command) {
        switch (command) {
            case "done":
                System.out.println("☹ OOPS!!! There has to be a number indicated after done.");
                break;

            case "todo":
                System.out.println("☹ OOPS!!! There has to be a task indicated after todo.");
                break;

            case "deadline":
                System.out.println("☹ OOPS!!! There has to be a task indicated after deadline.");
                break;

            case "event":
                System.out.println("☹ OOPS!!! There has to be a task indicated after event.");
                break;
        }
    }

}
