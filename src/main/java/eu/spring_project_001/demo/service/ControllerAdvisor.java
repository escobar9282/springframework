package eu.spring_project_001.demo.service;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControllerAdvisor
{
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ErrorMessage> titular(CarNotFoundException e)
    {
        ErrorMessage errorMessage = new ErrorMessage(400, LocalDate.now(), e.getMessage(), "Exception appeared please fix the request.");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<ErrorMessage> conceal(OwnerNotFoundException exception)
    {
        ErrorMessage errorMessage = new ErrorMessage(400, LocalDate.now(), exception.getMessage(), "Exception has appeared please fix the request.");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarPartsNotFoundException.class)
    public ResponseEntity<ErrorMessage> concealCarParts(CarPartsNotFoundException exception)
    {
        ErrorMessage errorMessage = new ErrorMessage(400, LocalDate.now(), exception.getMessage(), "Exception has appeared please fix the request.");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
