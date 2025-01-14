package labwork.web.errorHandler;

import labwork.service.errorHandler.InvalidArguments;
import labwork.service.errorHandler.UserNotFound;
import labwork.service.errorHandler.CategoryNotFound;
import labwork.service.errorHandler.RecordNotFound;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidArguments.class)
    ProblemDetail handleInvalidArguments(InvalidArguments ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, ex.getMessage());
        problemDetail.setType(URI.create("invalid-arguments"));
        problemDetail.setTitle("Invalid Arguments");
        return problemDetail;
    }
	
	@ExceptionHandler(UserNotFound.class)
    ProblemDetail handleUserNotFound(UserNotFound ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create("user-not-found"));
        problemDetail.setTitle("User Not Found");
        return problemDetail;
    }

    @ExceptionHandler(CategoryNotFound.class)
    ProblemDetail handleCategoryNotFound(CategoryNotFound ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create("category-not-found"));
        problemDetail.setTitle("Category Not Found");
        return problemDetail;
    }
    @ExceptionHandler(RecordNotFound.class)
    ProblemDetail handleRecordNotFound(RecordNotFound ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create("record-not-found"));
        problemDetail.setTitle("Record Not Found");
        return problemDetail;
    }
    
}