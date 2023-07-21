package ec.telconet.elemento;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ec.telconet.microservicio.dependencia.util.exception.GenericException;

@ControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(value
                   = GenericException.class)
 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 public @ResponseBody ErrorResponse
 handleException(GenericException ex)
 {
     return new ErrorResponse(
         ex.getMessage());
 }
}