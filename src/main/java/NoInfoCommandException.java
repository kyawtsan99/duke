public class NoInfoCommandException extends Exception {
    NoInfoCommandException(String firstWord) {
        super(generateMessage(firstWord));
    }

    private static String generateMessage(String firstWord) {
        if (firstWord.equals("done")) {
            return "☹ OOPS!!! There has to be a number indicated after " + firstWord + ".";
        }
        else {
            return "☹ OOPS!!! There has to be a task indicated after " + firstWord + ".";
        }
    }
}
