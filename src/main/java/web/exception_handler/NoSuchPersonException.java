package web.exception_handler;

public class NoSuchPersonException extends RuntimeException{

    public NoSuchPersonException(String message) {
        super(message);
    }
}
