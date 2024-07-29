package com.example.eshop.serviceImpl.shop;

import com.example.eshop.dto.shop.ShoppingCartDTO;
import com.example.eshop.entity.shop.ShoppingCart;
import com.example.eshop.exceptions.item.itemnotfound.ItemNotFoundException;
import com.example.eshop.exceptions.users.buyernotfound.BuyerNotFoundException;
import com.example.eshop.exceptions.users.buyernotfound.BuyerNotFoundResponse;
import com.example.eshop.repository.shop.ShoppingCartRepository;
import com.example.eshop.service.shop.ShoppingCartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ModelMapper modelMapper;

    /**
     * Get List with all shopping cart for all users
     * @return List of alll shopping cart
     */
    @Override
    public List<ShoppingCartDTO> getAllShoppingCard() {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();

        return modelMapper.map(shoppingCartList, new TypeToken<List<ShoppingCartDTO>>() {
        }.getType());
    }

    /**
     * Get shopping card for buyer with specific id
     * @param id is fot buyer i wnat find his shopping cart
     * @return the List of shopping cart for specific buyer
     */
    @Override
    public List<ShoppingCartDTO> getShoppingCartById(Long id) {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findByBuyerId(id);

        return modelMapper.map(shoppingCartList, new TypeToken<List<ShoppingCartDTO>>() {
        }.getType());
    }

    /**
     * Delete a item from shopping cart of specific buyer
     * @param buyer_id is for buyer i want delete a item
     * @param item_id is for item i want delete
     */
    @Transactional
    @Override
    public void deleteItemFromShopCart(Long buyer_id, Long item_id) {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findByBuyerId(buyer_id);

        if (shoppingCartList.isEmpty()) {
            throw new BuyerNotFoundException("Buyer with id " + buyer_id + " has not shopping cart");
        }

        boolean exist =shoppingCartRepository.existsItemByBuyerIdAndItemId(buyer_id , item_id);
        if (!exist) {
            throw new ItemNotFoundException(
                    "Ät the shopping cart buyer with id " + buyer_id + " the item with id " + item_id + " does not exist"
            );
        }

        shoppingCartRepository.deleteByBuyerIdAndItemId( buyer_id, item_id );

    }
}






