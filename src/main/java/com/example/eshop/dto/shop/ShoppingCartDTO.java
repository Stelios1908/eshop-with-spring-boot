package com.example.eshop.dto.shop;

import com.example.eshop.entity.items.Item;
import com.example.eshop.entity.users.Buyer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartDTO {

    private Long id;

    @JsonIgnoreProperties({"name", "email", "password","bonus","buyerCategory"})
    private Buyer buyer;

    private Item item;

    private int quantity;

}
