package com.example.eshop.exceptions.users.buyeralreadyexist;

public class BuyerAlreadyExistException extends RuntimeException{


    public BuyerAlreadyExistException(String message){
        super(message);
    }
}
