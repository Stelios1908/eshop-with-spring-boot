package com.example.eshop.service.users;

import com.example.eshop.entity.users.Buyer;
import com.example.eshop.exceptions.users.buyer_already_exist.BuyerAlreadyExistException;
import com.example.eshop.exceptions.users.buyer_not_found.BuyerNotFoundException;
import com.example.eshop.repository.users.BuyerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class BuyerService {


    private final BuyerRepository buyerRepository;


    @Transactional(readOnly = true)
    public List<Buyer> getAllBuyer(){
       return  buyerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Buyer getBuyerById(Long BuyerId){
        Optional<Buyer> optionalBuyer = buyerRepository.findById(BuyerId);

        if(optionalBuyer.isPresent()){
            return optionalBuyer.get();
        }
        else{
            throw new BuyerNotFoundException("buyer not found with id :" +BuyerId);
        }
    }

    @Transactional(readOnly = true)
    public Buyer findBuyerByEmail(String email) {
        //TODO exception if not find user by email
       Optional<Buyer> optionalBuyer = buyerRepository.findByEmail(email);

        if(optionalBuyer.isPresent()){
            return optionalBuyer.get();
        }
        else{
            throw new BuyerNotFoundException("buyer not found with email :" +email);
        }
    }

    public void saveNewBuyer(Buyer buyer) {

        Optional<Buyer> optionalbuyer = buyerRepository.findByEmail(buyer.getEmail());
        if (optionalbuyer.isPresent()) {
            throw new BuyerAlreadyExistException("buyer with email : " +buyer.getEmail()+" is already register");
        }
        buyerRepository.save(buyer);
    }


    public void deleteBuyer(Long id){
        boolean exist = buyerRepository.existsById(id);
        if (!exist) {
            throw new BuyerNotFoundException("buyer with id : " +id +" does not exist");
        }
        buyerRepository.deleteById(id);
    }

    @Transactional
    public void updateBuyer(Long id,
                            String name,
                            String email){
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new BuyerNotFoundException(
                "buyer with id : " +id+ " does not exist"));

        if(name != null &&
                !name.isEmpty()  &&
                !Objects.equals(buyer.getName(), name)){
            buyer.setName(name);
        }

        if(email != null &&
            !email.isEmpty()  &&
            !Objects.equals(buyer.getEmail(), email)) {
            Optional<Buyer> optionalBuyer = buyerRepository.findByEmail(email);
            if(optionalBuyer.isPresent()){
                throw  new IllegalStateException("email taken");
            }
            buyer.setEmail(email);
        }
    }
}

