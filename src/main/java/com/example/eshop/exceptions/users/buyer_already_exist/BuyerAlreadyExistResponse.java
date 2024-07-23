package com.example.eshop.exceptions.users.buyer_already_exist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BuyerAlreadyExistResponse {

    private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

}