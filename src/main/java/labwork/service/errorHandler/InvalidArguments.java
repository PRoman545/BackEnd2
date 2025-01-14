package labwork.service.errorHandler;

public class InvalidArguments extends RuntimeException {

    public InvalidArguments(String message) {
        super(message);
    }

}