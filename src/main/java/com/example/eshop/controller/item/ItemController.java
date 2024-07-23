package com.example.eshop.controller.item;


import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Item")
@RequiredArgsConstructor
public class ItemController {


    private final ItemService itemService;


    @GetMapping
    public List<Item> getItem(){
        return itemService.getAllItem();
    }

    @GetMapping(value="category/{category}")
    public List<Item> ItemByCategory(@PathVariable ItemTypeEnum category){
        return itemService.getItemByCategory(category);
    }

    @GetMapping(value ="Price/{price}")
    public  List<Item> PriceLessThan(@PathVariable Double price){
       return itemService.getItemsByPriceLessThan(price);
    }


}
