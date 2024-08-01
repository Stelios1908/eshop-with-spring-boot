package com.example.eshop.exceptions.users.buyernotfound;

import jakarta.persistence.EntityNotFoundException;

public class BuyerNotFoundException extends EntityNotFoundException {

    public BuyerNotFoundException(String message) {
        super(message);
    }
}
