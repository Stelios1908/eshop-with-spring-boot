package com.example.eshop.exceptions.item.item_already_exist;



public class ItemAlreadyExistException extends RuntimeException{

    public ItemAlreadyExistException(String message){
        super(message);
    }
}
