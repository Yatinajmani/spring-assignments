package ttn.spring.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex,
                                                                       WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(true));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<String> errorMessageList = ex.getBindingResult().getAllErrors()
                .stream().filter(e -> e instanceof FieldError).map((e) -> {
                    FieldError fieldError = (FieldError) e;
                    return messageSource.getMessage(fieldError, null);
                }).collect(Collectors.toList());
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Cannot process the request.",
                errorMessageList.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
