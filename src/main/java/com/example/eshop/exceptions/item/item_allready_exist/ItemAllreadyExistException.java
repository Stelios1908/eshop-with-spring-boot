package com.example.eshop.exceptions.item.item_allready_exist;



public class ItemAllreadyExistException extends RuntimeException{

    public ItemAllreadyExistException(String message){
        super(message);
    }
}
