package com.example.hotel2.Exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid input or transaction")
public class TransactionnotValid extends RuntimeException {

    public TransactionnotValid(String message) {

        super(message);
    }
}
