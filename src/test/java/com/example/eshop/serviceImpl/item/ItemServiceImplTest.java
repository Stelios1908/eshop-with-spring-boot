package com.example.eshop.serviceImpl.item;

import com.example.eshop.dto.item.ItemDTO;
import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.repository.items.ItemRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ItemServiceImpl itemService;


    /**
     * Test getAllItem
     */
    @Test
    void getAllItem() {

        //given
        //first make 2 item and 2 itemDTO
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item 1",ItemTypeEnum.Pen,2.2, "kalo",12));
        itemList.add(new Item(2L, "Item 2",ItemTypeEnum.Pencil,2.2, "kalo",12));

        List<ItemDTO> itemDTOList = new ArrayList<>();
        itemDTOList.add(new ItemDTO(1L, "Item 1",ItemTypeEnum.Pen,2.2, "kalo",12));
        itemDTOList.add(new ItemDTO(2L, "Item 2",ItemTypeEnum.Pencil,2.2, "kalo",12));

        // Mocking the repository and mapper
        when(itemRepository.findAll()).thenReturn(itemList);
        when(modelMapper.map(itemList, new TypeToken<List<ItemDTO>>() {}.getType())).thenReturn(itemDTOList);

        //when
        //call getAllItem
        List<ItemDTO> result = itemService.getAllItem();

        //then
        assertEquals(2, result.size());
        assertEquals("Item 1", result.get(0).getName());
        assertEquals("Item 2", result.get(1).getName());

    }

    /**
     * Test getItemByCategory
     */
    @Test
    void getItemByCategory() {

        //given
        //first make 2 item and 2 itemDTO
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item 1",ItemTypeEnum.Pencil,2.2, "kalo",12));
        itemList.add(new Item(2L, "Item 2",ItemTypeEnum.Pencil,2.2, "kalo",12));

        List<ItemDTO> itemDTOList = new ArrayList<>();
        itemDTOList.add(new ItemDTO(1L, "Item 1",ItemTypeEnum.Pencil,2.2, "kalo",12));
        itemDTOList.add(new ItemDTO(2L, "Item 2",ItemTypeEnum.Pencil,2.2, "kalo",12));

        // Mocking the repository and mapper
        when(itemRepository.findByCategory(ItemTypeEnum.Pencil)).thenReturn(itemList);
        when(modelMapper.map(itemList, new TypeToken<List<ItemDTO>>() {}.getType())).thenReturn(itemDTOList);

        //when
        //call getItemByCategory
        List<ItemDTO> result  = itemService.getItemByCategory(ItemTypeEnum.Pencil);

        //then
        assertEquals(2,result.size());
        assertEquals("Item 1",result.get(0).getName());
        assertEquals("Item 2",result.get(1).getName());

    }


    /**
     * Test getItemsByPriceLessThan
     */
    @Test
    void getItemsByPriceLessThan() {

        //given
        //first make 2 item and 2 itemDTO
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item 1",ItemTypeEnum.Pencil,2.2, "kalo",12));
        itemList.add(new Item(2L, "Item 2",ItemTypeEnum.Pencil,2.2, "kalo",12));

        List<ItemDTO> itemDTOList = new ArrayList<>();
        itemDTOList.add(new ItemDTO(1L, "Item 1",ItemTypeEnum.Pencil,2.2, "kalo",12));
        itemDTOList.add(new ItemDTO(2L, "Item 2",ItemTypeEnum.Pencil,2.2, "kalo",12));

        // Mocking the repository and mapper
        when(itemRepository.findByPriceLessThan(4.0)).thenReturn(itemList);
        when(modelMapper.map(itemList, new TypeToken<List<ItemDTO>>() {}.getType())).thenReturn(itemDTOList);

        //when
        //call getItemByCategory
        List<ItemDTO> result  = itemService.getItemsByPriceLessThan(4.0);

        //then
        assertEquals(2,result.size());
        assertEquals("Item 1",result.get(0).getName());
        assertEquals("Item 2",result.get(1).getName());

    }
}