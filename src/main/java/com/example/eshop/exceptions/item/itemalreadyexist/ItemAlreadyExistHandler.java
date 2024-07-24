package com.example.eshop.exceptions.item.itemalreadyexist;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ItemAlreadyExistHandler {

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ItemAlreadyExistException.class)
    public ResponseEntity<ItemAlreadyExistResponse> handleMyException(ItemAlreadyExistException ex, HttpServletRequest request) {
        ItemAlreadyExistResponse errorResponse= new ItemAlreadyExistResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Item Already Exist",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
