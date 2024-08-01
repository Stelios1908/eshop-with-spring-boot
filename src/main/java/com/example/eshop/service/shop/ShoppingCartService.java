package com.example.eshop.service.shop;

import com.example.eshop.dto.shop.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartService {


    List<ShoppingCartDTO> getAllShoppingCard();

    List<ShoppingCartDTO>  getShoppingCartById(Long id);

    void deleteItemFromShopCart(Long buyer_id, Long item_id);
}
