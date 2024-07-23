package com.example.eshop.exceptions.users.buyer_not_found;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BuyerNotFoundHandler{

    @ExceptionHandler(BuyerNotFoundException.class)
    public ResponseEntity<BuyerNotFoundResponse> handleMyException(BuyerNotFoundException ex, HttpServletRequest request) {
    BuyerNotFoundResponse errorResponse = new BuyerNotFoundResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Item Not Found",
            ex.getMessage(),
            request.getRequestURI()
    );
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
}
}


