package com.example.eshop.service.item;

import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.repository.items.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class ItemService {


    private final ItemRepository itemRepository;


    @Transactional
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Transactional
    public  List<Item> getItemByCategory(ItemTypeEnum category) {
          return  itemRepository.findByCategory(category);
    }

    @Transactional
    public List<Item> getItemsByPriceLessThan(Double price) {
        return itemRepository.findByPriceLessThan(price);
    }
}
