package vet.petx.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vet.petx.api.domain.exceptions.ResourceNotFoundException;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> HandleEntityNotFoundException() {


        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorValidationsDTO>> HandleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(errors
                .stream()
                .map(ErrorValidationsDTO::new)
                .toList());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetailsDTO> HandleValidationException(ValidationException exception) {

        return ResponseEntity.badRequest().body(new ErrorDetailsDTO(exception.getMessage()));
    }

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> HandleResourceNotFoundException(ResourceNotFoundException exception) {

        return ResponseEntity.badRequest().body(new ErrorDetailsDTO(exception.getMessage()));
    }

    private record ErrorValidationsDTO(String field, String message){
        public ErrorValidationsDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
