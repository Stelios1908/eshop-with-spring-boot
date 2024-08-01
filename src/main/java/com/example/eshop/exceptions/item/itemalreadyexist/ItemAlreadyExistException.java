package com.example.eshop.exceptions.item.itemalreadyexist;



public class ItemAlreadyExistException extends RuntimeException{

    public ItemAlreadyExistException(String message){
        super(message);
    }
}
