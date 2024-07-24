package com.example.eshop.exceptions.users.buyeralreadyexist;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BuyerAlreadyExistHandler {

    @ExceptionHandler(BuyerAlreadyExistException.class)
    public ResponseEntity<BuyerAlreadyExistResponse> handleMyException(BuyerAlreadyExistException ex, HttpServletRequest request) {
        BuyerAlreadyExistResponse errorResponse = new BuyerAlreadyExistResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Buyer Allready Exist",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}