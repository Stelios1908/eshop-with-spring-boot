package com.example.eshop.serviceImpl.item;

import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.repository.items.ItemRepository;
import com.example.eshop.service.item.ItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getItemByCategory(ItemTypeEnum category) {
        return itemRepository.findByCategory(category);
    }

    @Override
    public List<Item> getItemsByPriceLessThan(Double price) {
        return itemRepository.findByPriceLessThan(price);
    }
}
