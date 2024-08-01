package com.example.eshop.service.item;

import com.example.eshop.dto.item.ItemDTO;
import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ItemService {


    List<ItemDTO> getAllItem();

    List<ItemDTO> getItemByCategory(ItemTypeEnum category);

    List<ItemDTO> getItemsByPriceLessThan(Double price);
}
