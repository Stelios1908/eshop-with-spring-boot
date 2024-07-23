package com.example.eshop.exceptions.users.buyer_allready_exist;


import com.example.eshop.exceptions.item.item_allready_exist.ItemAllreadyExistException;
import com.example.eshop.exceptions.item.item_allready_exist.ItemAllreadyExistResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BuyerAllreadyExistHandler {

    @ExceptionHandler(BuyerAllreadyExistException.class)
    public ResponseEntity<BuyerAllreadyExistResponse> handleMyException(BuyerAllreadyExistException ex, HttpServletRequest request) {
        BuyerAllreadyExistResponse errorResponse = new BuyerAllreadyExistResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Buyer Allready Exist",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}