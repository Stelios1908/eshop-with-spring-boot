package com.example.eshop.dto.item;

import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {


    private Long id;
    private String name;
    private ItemTypeEnum category;
    private Double price;
    private String description;
    private int stock;

}
