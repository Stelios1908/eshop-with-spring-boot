package com.example.eshop.service.item;

import com.example.eshop.dto.item.PenDTO;
import com.example.eshop.entity.items.Pen;
import com.example.eshop.exceptions.item.itemalreadyexist.ItemAlreadyExistException;
import com.example.eshop.exceptions.item.item_not_found.ItemNotFoundException;
import com.example.eshop.repository.items.PenRepository;
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
public class PenService {


    private final  PenRepository penRepository;


    private final ModelMapper modelMapper;


    @Transactional
    public List<PenDTO> getAllPen(){
        List<Pen> penList = penRepository.findAll();
        return modelMapper.map(penList, new TypeToken<List<PenDTO>>(){}.getType());

    }


    @Transactional
    public  PenDTO getPenById(Long id) {

        Pen optionalPen = penRepository.findById(id)
               .orElseThrow(() -> new ItemNotFoundException("Pen with id : " + id + " is not exist"));

       return modelMapper.map(optionalPen,new TypeToken<PenDTO>(){}.getType());

    }

    @Transactional
    public PenDTO getPenByName(String name) {

       Pen optionalPen =  penRepository.findByName(name)
               .orElseThrow(()-> new ItemNotFoundException("Pen with name : " +name+ " is not exist"));

        return modelMapper.map(optionalPen,new TypeToken<PenDTO>(){}.getType());

    }

    @Transactional
    public void saveNewPen(PenDTO penDTO) {
        Optional<Pen> optionalPen =  penRepository.findByName(penDTO.getName());
        if(optionalPen.isPresent()){
            throw new ItemAlreadyExistException("the Pen with  name : " +penDTO.getName()+ " is already store");
        }
        Pen penForDataBase = modelMapper.map(penDTO,Pen.class);

        penRepository.save(penForDataBase);
    }

    @Transactional
    public void deletePen(Long id) {
        boolean exist = penRepository.existsById(id);
        if(!exist){
            throw new ItemNotFoundException("Pen with id : " +id+ " not exist");
        }
        penRepository.deleteById(id);
    }

    @Transactional
    public void updatePen(Long id, Double price,Integer stock) {
        Pen pen = penRepository.findById(id).orElseThrow(()->
                new ItemNotFoundException("Pen with id : "+id+ " not exist"));


        if (price != null && price >= 0 && !Objects.equals(pen.getPrice(), price)) {
            pen.setPrice(price);
        }


        if (stock != null && stock >= 0 && !Objects.equals(pen.getStock(), stock)) {
            pen.setStock(stock);
        }

    }

}
