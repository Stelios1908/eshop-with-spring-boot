package com.example.eshop.controller.item;

import com.example.eshop.dto.item.ItemDTO;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.serviceImpl.item.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

//@WebMvcTest(ItemController.class) i have problemm with this
@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ItemServiceImpl itemService;


    /**
     * Tests the retrieval of an item via the /api/Item endpoint.
     * @throws Exception if there is an error during the execution of the mock request
     *                   *                   or if the mocking of the service layer fails.
     */
    @Test
    void testGetItem() throws Exception {

        ItemDTO itemDTO = new ItemDTO(); // Create a sample ItemDTO
        itemDTO.setName("Test Item");
        itemDTO.setStock(12);
        itemDTO.setPrice(12.0);

        List<ItemDTO> mylist = new ArrayList<>();
        mylist.add(itemDTO);

        //List<ItemDTO> allItems = Collections.singletonList (itemDTO);
        given(itemService.getAllItem()).willReturn(mylist);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/Item")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("sakis", "sakisPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "'name':'Test Item'," +
                        "'stock': 12 ," +
                        "'price':12.0" +
                        "}]"));
    }


    /**
     *Tests the retrieval of an item via the /api/Item/category/Pen endpoint using a category.
     * @throws Exception if there is an error during the execution of the mock request
     *                   *                   or if the mocking of the service layer fails.
     */
    @Test
    void testItemByCategory() throws Exception {
        ItemDTO itemDTO = new ItemDTO(); // Create a sample ItemDTO
        itemDTO.setName("Test Item");
        itemDTO.setStock(12);
        itemDTO.setPrice(12.0);
        itemDTO.setCategory(ItemTypeEnum.Pen);

        List<ItemDTO> myList = new ArrayList<>();
        myList.add(itemDTO);

        System.out.println("my list is  : " + myList);
        given(itemService.getItemByCategory(ItemTypeEnum.Pen)).willReturn(myList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Item/category/Pen")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("sakis", "sakisPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "'name':'Test Item'," +
                        "'stock': 12 ," +
                        "'price':12.0," +
                        "'category':'Pen'" +
                        "}]"));
    }


    /**
     * Tests the retrieval of an item via /api/item/Price/ using  a price
     * @throws Exception if there is an error during the execution of the mock request
     *                   *                   or if the mocking of the service layer fails.
     */
    @Test
    void testPriceLessThan() throws Exception {
        ItemDTO itemDTO = new ItemDTO(); // Create a sample ItemDTO
        itemDTO.setName("Test Item");
        itemDTO.setStock(12);
        itemDTO.setPrice(12.0);

        List<ItemDTO> itemsByPrice = new ArrayList<>();
        itemsByPrice.add(itemDTO);

        given(itemService.getItemsByPriceLessThan(100.0)).willReturn(itemsByPrice);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Item/Price/100.0")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("sakis", "sakisPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "'name':'Test Item'," +
                        "'stock': 12 ," +
                        "'price':12.0" +
                        "}]"));
    }

}
