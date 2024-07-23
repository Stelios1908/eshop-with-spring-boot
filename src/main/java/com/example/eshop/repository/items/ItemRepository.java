package com.example.eshop.repository.items;

import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT i FROM Item i WHERE i.category = :category")
    List<Item> findByCategory(ItemTypeEnum category);

    // Εύρεση αντικειμένων με βάση την τιμή χρησιμοποιώντας custom query
    @Query("SELECT i FROM Item i WHERE i.price < :price")
    List<Item> findByPriceLessThan(Double price);
}

