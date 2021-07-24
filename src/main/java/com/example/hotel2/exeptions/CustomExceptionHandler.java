package com.example.hotel2.exeptions;

import com.example.hotel2.Exeption.TransactionnotValid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleNoDataFoundException (TransactionnotValid ex) {
        ErrorObject eObject = new ErrorObject();
        eObject.setHttpCodeMessage(HttpStatus.NOT_ACCEPTABLE.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_ACCEPTABLE);
    }

}
