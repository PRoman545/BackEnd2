package labwork.service.errorHandler;

import java.util.UUID;

public class UserNotFound extends RuntimeException {

    private static final String MESSAGE = "User with id %s has not been found";
    public UserNotFound(UUID id) {
        super(String.format(MESSAGE, id));
    }

}