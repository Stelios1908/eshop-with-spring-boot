package com.example.eshop.serviceImpl.item;

import com.example.eshop.dto.item.ItemDTO;
import org.modelmapper.ModelMapper;
import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.repository.items.ItemRepository;
import com.example.eshop.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    /**
     * Get all Item
     * @return
     */
    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> itemList= itemRepository.findAll();
        return modelMapper.map(itemList,new TypeToken<List<ItemDTO>>(){}.getType());
    }

    /**
     * Get all item with category ==  param
     * @param category
     * @return
     */
    @Override
    public List<ItemDTO> getItemByCategory(ItemTypeEnum category) {
        List<Item> itemList = itemRepository.findByCategory(category);
        return  modelMapper.map(itemList,new TypeToken<List<ItemDTO>>(){}.getType());
    }

    /**
     *Get all item with price <= param
     * @param price
     * @return
     */
    @Override
    public List<ItemDTO> getItemsByPriceLessThan(Double price) {
        List<Item> itemList = itemRepository.findByPriceLessThan(price);
        return modelMapper.map(itemList,new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
