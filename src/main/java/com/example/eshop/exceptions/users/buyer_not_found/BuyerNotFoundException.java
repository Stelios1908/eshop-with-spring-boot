package com.example.eshop.exceptions.users.buyer_not_found;

import jakarta.persistence.EntityNotFoundException;

public class BuyerNotFoundException extends EntityNotFoundException {

    public BuyerNotFoundException(String message) {
        super(message);
    }
}
