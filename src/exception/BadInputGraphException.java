package exception;

public class BadInputGraphException extends RuntimeException{
    public BadInputGraphException(String input) {
        super(input);
    }
}
