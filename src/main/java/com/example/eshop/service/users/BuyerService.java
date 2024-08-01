package com.example.eshop.service.users;

import com.example.eshop.dto.users.BuyerDTO;
import com.example.eshop.entity.users.Buyer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuyerService {

    /**
     *
     * @return
     */
    List<BuyerDTO> getAllBuyer();

    /**
     *
     * @param BuyerId
     * @return
     */
    BuyerDTO getBuyerById(Long BuyerId);

    /**
     *
     * @param email
     * @return
     */
    BuyerDTO findBuyerByEmail(String email);

    /**
     *
     * @param buyer
     */
    void saveNewBuyer(BuyerDTO buyer);

    /**
     *
     * @param id
     */
    void deleteBuyer(Long id);

    /**
     *
     * @param id
     * @param name
     * @param email
     */
    void updateBuyer(Long id, String name, String email);


}

