package com.example.eshop.repository.shop;


import com.example.eshop.entity.shop.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    // @Query(value = "SELECT * FROM shopping_cart WHERE buyer_id = :buyerId", nativeQuery = true)
    List<ShoppingCart> findByBuyerId(@Param("buyerId") Long buyerId);

    boolean existsItemByBuyerIdAndItemId(Long buyer_id, Long item_id);

    // @Modifying
     // @Query("DELETE FROM ShoppingCartItem sc WHERE sc.buyerId = :buyerId AND sc.itemName = :itemName")
    void deleteByBuyerIdAndItemId( Long buyerId, Long item_id);

}
