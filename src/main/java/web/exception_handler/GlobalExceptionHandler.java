package web.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApplicationIncorrectData> exceptionHandler(NoSuchPersonException exception){

        ApplicationIncorrectData wrongData = new ApplicationIncorrectData();
        wrongData.setInfo(exception.getMessage());
        return new ResponseEntity<>(wrongData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationIncorrectData> exceptionHandler(Exception exception){

        ApplicationIncorrectData wrongData = new ApplicationIncorrectData();
        wrongData.setInfo(exception.getMessage());
        return new ResponseEntity<>(wrongData, HttpStatus.BAD_REQUEST);
    }
}
