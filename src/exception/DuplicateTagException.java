package exception;

public class DuplicateTagException extends RuntimeException{
    public DuplicateTagException(String tag) {
        super(tag);
    }
}
