package com.example.eshop.controller.users;

import com.example.eshop.entity.users.Buyer;
import com.example.eshop.service.users.BuyerService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/buyer")
@RequiredArgsConstructor
public class BuyerController {


    private final BuyerService buyerService;


    @GetMapping
    public List<Buyer> getBuyer() {
        return buyerService.getAllBuyer();
    }

    @GetMapping(value = "/{id}")
    public Buyer BuyerById(@PathVariable("id") Long id) {
        return buyerService.getBuyerById(id);
    }

    @GetMapping(value = "email/{email}")
    public Buyer BuyerByEmail(@PathVariable("email") String email) {
        return buyerService.findBuyerByEmail(email);
    }

    //TODO change Buyer with BuyerDTO
    @PostMapping()
    public void saveBuyer(@RequestBody Buyer buyer) {
        buyerService.saveNewBuyer(buyer);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteBuyer(@PathVariable("id") Long id) {
        buyerService.deleteBuyer(id);
    }

    @PutMapping(value = "update/{id}")
    public void updateBuyer(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        buyerService.updateBuyer(id, name, email);
    }
}