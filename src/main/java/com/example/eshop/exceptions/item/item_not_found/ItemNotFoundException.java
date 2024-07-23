package com.example.eshop.exceptions.item.item_not_found;

import jakarta.persistence.EntityNotFoundException;

public class ItemNotFoundException extends EntityNotFoundException {

    public ItemNotFoundException(String message) {
        super(message);
    }
}
