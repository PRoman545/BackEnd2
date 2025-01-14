package labwork.service.errorHandler;

import java.util.UUID;

public class RecordNotFound extends RuntimeException {

    private static final String MESSAGE = "Record with id %s has not been found";
    public RecordNotFound(UUID id) {
        super(String.format(MESSAGE, id));
    }

}