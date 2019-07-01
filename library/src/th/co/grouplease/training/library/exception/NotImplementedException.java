package th.co.grouplease.training.library.exception;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException(){
    }

    public NotImplementedException(String message, Throwable cause){
        super(message, cause);
    }
}
