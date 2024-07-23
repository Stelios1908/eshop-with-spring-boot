package com.example.eshop.exceptions.users.buyer_already_exist;

public class BuyerAlreadyExistException extends RuntimeException{


    public BuyerAlreadyExistException(String message){
        super(message);
    }
}
