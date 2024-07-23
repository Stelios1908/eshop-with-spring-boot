package com.example.eshop.exceptions.item.item_not_found;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class ItemNotFoundHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ItemNotFoundResponse> handleMyException(ItemNotFoundException ex, HttpServletRequest request) {
        ItemNotFoundResponse errorResponse = new ItemNotFoundResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Item Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
