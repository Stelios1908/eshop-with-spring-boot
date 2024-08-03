package com.example.eshop.controller.shop;

import com.example.eshop.dto.shop.ShoppingCartDTO;
import com.example.eshop.entity.items.Item;
import com.example.eshop.entity.users.Buyer;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.exceptions.item.itemnotfound.ItemNotFoundException;
import com.example.eshop.exceptions.users.buyernotfound.BuyerNotFoundException;
import com.example.eshop.serviceImpl.shop.ShoppingCartServiceImpl;
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

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShoppingCartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCartServiceImpl shoppingCartService;


    /**
     * Test the retrieval  of a shopping cart via /api/ShoppingCart GET endpoint
     *
     * @throws Exception if there is an error during of the execution of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void getShoppingCard() throws Exception {

        //first new buyer
        Buyer buyer = new Buyer();
        buyer.setId(1L);

        //after new item
        Item item = new Item();
        item.setId(1L);
        item.setStock(12);
        item.setName("test");
        item.setPrice(12.2);
        item.setCategory(ItemTypeEnum.Pencil);

        //now i have buyer and item  and i can create a shopping cart
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setId(1L);
        shoppingCartDTO.setBuyer(buyer);
        shoppingCartDTO.setItem(item);
        shoppingCartDTO.setQuantity(12);


        List<ShoppingCartDTO> shoppingCartlist = new ArrayList<>();
        shoppingCartlist.add(shoppingCartDTO);


        given(shoppingCartService.getAllShoppingCard()).willReturn(shoppingCartlist);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ShoppingCart")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "  'id': 1," +
                        "  'buyer': {" +
                        "    'id': 1" +
                        "  }," +
                        "  'item': {" +
                        "    'id': 1," +
                        "    'stock': 12," +
                        "    'name': 'test'," +
                        "    'price': 12.2," +
                        "    'category': 'Pencil'" +
                        "  }," +
                        "  'quantity': 12" +
                        "}]"));
    }


    /**
     * Test to retrieval of a shopping cart via /api/ShoppingCart/{id}"  GET endpoint using an id
     *
     * @throws Exception if there is an error during execution  of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void shoppingCartById() throws Exception {

        //first new buyer
        Buyer buyer = new Buyer();
        buyer.setId(1L);

        //after new item
        Item item = new Item();
        item.setId(1L);
        item.setStock(12);
        item.setName("test");
        item.setPrice(12.2);
        item.setCategory(ItemTypeEnum.Pencil);

        //now i have buyer and item  and i can create a shopping cart
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setId(1L);
        shoppingCartDTO.setBuyer(buyer);
        shoppingCartDTO.setItem(item);
        shoppingCartDTO.setQuantity(12);

        List<ShoppingCartDTO> shoppingCartlist = new ArrayList<>();
        shoppingCartlist.add(shoppingCartDTO);


        given(shoppingCartService.getShoppingCartById(shoppingCartDTO.getId())).willReturn(shoppingCartlist);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ShoppingCart/{id}", shoppingCartDTO.getId())
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "  'id': 1," +
                        "  'buyer': {" +
                        "    'id': 1" +
                        "  }," +
                        "  'item': {" +
                        "    'id': 1," +
                        "    'stock': 12," +
                        "    'name': 'test'," +
                        "    'price': 12.2," +
                        "    'category': 'Pencil'" +
                        "  }," +
                        "  'quantity': 12" +
                        "}]"));

    }


    /**
     * Test to retrieval of a shopping cart via /api/ShoppingCart/delete/{buyer_id}"   DELETE endpoint using an buyer_id
     *  and item_id as param
     * @throws Exception if there is an error during execution  of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void deleteItemFromShopCart() throws Exception{

        //first new buyer
        Buyer buyer = new Buyer();
        buyer.setId(1L);

        //after new item
        Item item = new Item();
        item.setId(1L);
        item.setStock(12);
        item.setName("test");
        item.setPrice(12.2);
        item.setCategory(ItemTypeEnum.Pencil);

        //now i have buyer and item  and i can create a shopping cart
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setId(1L);
        shoppingCartDTO.setBuyer(buyer);
        shoppingCartDTO.setItem(item);
        shoppingCartDTO.setQuantity(12);

        //try to delete item for a buyer  and everything was done successfully
        doNothing().when(shoppingCartService).deleteItemFromShopCart(buyer.getId(), item.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ShoppingCart/delete/{buyer_id}", buyer.getId())
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("item_id", String.valueOf(item.getId()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());


        //try to delete item for a buyer  but buyer not  found
        doThrow(new BuyerNotFoundException("Buyer not found ")).when(shoppingCartService).deleteItemFromShopCart(buyer.getId(), item.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ShoppingCart/delete/{buyer_id}", item.getId())
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("item_id", String.valueOf(item.getId()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()) // awaits  status 404
                .andExpect(content().string(containsString("Buyer not found")));

        //try to delete item for a buyer  but item not  found in the buyer shopping cart
        doThrow(new ItemNotFoundException("Item not found ")).when(shoppingCartService).deleteItemFromShopCart(buyer.getId(),item.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ShoppingCart/delete/{buyer_id}", item.getId())
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("item_id", String.valueOf(item.getId()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()) // awaits  status 404
                .andExpect(content().string(containsString("Item not found")));

    }
}