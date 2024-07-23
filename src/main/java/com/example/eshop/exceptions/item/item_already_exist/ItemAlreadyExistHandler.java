package com.example.eshop.exceptions.item.item_already_exist;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ItemAlreadyExistHandler {

    @ExceptionHandler(ItemAlreadyExistException.class)
    public ResponseEntity<ItemAlreadyExistResponse> handleMyException(ItemAlreadyExistException ex, HttpServletRequest request) {
        ItemAlreadyExistResponse errorResponse= new ItemAlreadyExistResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Item Allready Exist",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
