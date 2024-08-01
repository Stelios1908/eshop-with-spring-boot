package com.example.eshop.exceptions.item.itemnotfound;

import jakarta.persistence.EntityNotFoundException;

public class ItemNotFoundException extends EntityNotFoundException {

    public ItemNotFoundException(String message) {
        super(message);
    }
}
