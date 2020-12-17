package exception;

public class BadVertexException extends RuntimeException{
    public BadVertexException(String tag) {
        super(tag);
    }
}
