package com.example.eshop.exceptions.users.buyer_allready_exist;

public class BuyerAllreadyExistException extends RuntimeException{


    public BuyerAllreadyExistException(String message){
        super(message);
    }
}
