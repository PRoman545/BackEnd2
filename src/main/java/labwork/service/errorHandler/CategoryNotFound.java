package labwork.service.errorHandler;

import java.util.UUID;

public class CategoryNotFound extends RuntimeException {

    private static final String MESSAGE = "Category with id %s has not been found";
    public CategoryNotFound(UUID id) {
        super(String.format(MESSAGE, id));
    }

}