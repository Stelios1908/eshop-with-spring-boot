package com.example.eshop.serviceImpl.users;

import com.example.eshop.dto.item.PencilDTO;
import com.example.eshop.dto.users.BuyerDTO;
import com.example.eshop.entity.users.Buyer;
import com.example.eshop.exceptions.users.buyeralreadyexist.BuyerAlreadyExistException;
import com.example.eshop.exceptions.users.buyernotfound.BuyerNotFoundException;
import com.example.eshop.repository.users.BuyerRepository;
import com.example.eshop.service.users.BuyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {


    private final BuyerRepository buyerRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<BuyerDTO> getAllBuyer(){
        List<Buyer> buyerList = buyerRepository.findAll();
        return  modelMapper.map(buyerList, new TypeToken<List<BuyerDTO>>(){}.getType());
    }

    @Override
    public BuyerDTO getBuyerById(Long BuyerId){
      Buyer buyer = buyerRepository.findById(BuyerId)
              .orElseThrow(()-> new BuyerNotFoundException("buyer not found with id :" +BuyerId));

      return modelMapper.map(buyer,new TypeToken<BuyerDTO>(){}.getType());
    }

    @Override
    public BuyerDTO findBuyerByEmail(String email) {
        Buyer buyer = buyerRepository.findByEmail(email)
                .orElseThrow(()-> new BuyerNotFoundException("Buyer does not found with email :" +email));
        return modelMapper.map(buyer, new TypeToken<BuyerDTO>(){}.getType());
    }

    @Override
    public void saveNewBuyer(BuyerDTO buyer) {

        Optional<Buyer> optionalbuyer = buyerRepository.findByEmail(buyer.getEmail());
        if (optionalbuyer.isPresent()) {
            throw new BuyerAlreadyExistException("Buyer with email : " +buyer.getEmail()+" is already register");
        }
        Buyer penForDataBase = modelMapper.map(buyer, Buyer.class);
        buyerRepository.save(penForDataBase);
    }

    @Transactional
    @Override
    public void deleteBuyer(Long id){
        boolean exist = buyerRepository.existsById(id);
        if (!exist) {
            throw new BuyerNotFoundException("buyer with id : " +id +" does not exist");
        }
        buyerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateBuyer(Long id, String name, String email){
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

