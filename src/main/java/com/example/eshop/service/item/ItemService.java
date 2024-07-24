package com.example.eshop.service.item;

import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ItemService {

    /**
     *
     * @return
     */
    List<Item> getAllItem();

    /**
     *
     * @param category
     * @return
     */
    List<Item> getItemByCategory(ItemTypeEnum category);

    /**
     *
     * @param price
     * @return
     */
    List<Item> getItemsByPriceLessThan(Double price);
}
