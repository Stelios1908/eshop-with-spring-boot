package com.example.eshop.serviceImpl.item;
import com.example.eshop.dto.item.PencilDTO;
import com.example.eshop.entity.items.Pencil;
import com.example.eshop.exceptions.item.itemalreadyexist.ItemAlreadyExistException;
import com.example.eshop.exceptions.item.itemnotfound.ItemNotFoundException;
import com.example.eshop.repository.items.PencilRepository;
import com.example.eshop.service.item.PencilService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PencilServiceImpl implements PencilService {

    public final PencilRepository pencilRepository;
    public final ModelMapper modelMapper;

    /**
     * Get all Pencil
     * @return List with all Pencil
     */
    @Override
    public List<PencilDTO> getAllPencil() {
        List<Pencil> pencilList = pencilRepository.findAll();
        return modelMapper.map(pencilList,  new TypeToken<List<PencilDTO>>(){}.getType());
    }

    /**
     * Get Pencil By id
     * @param id is the id for the pencil i want find
     * @return  the specific pencil
     */
    @Override
    public PencilDTO getPencilById(Long id) {

        Pencil optionalPencil = pencilRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Pen with id : " + id + " is not exist"));

        return modelMapper.map(optionalPencil,new TypeToken<PencilDTO>(){}.getType());

    }

    /**
     * Get pencil by name
     * @param name of Pencil i want find
     * @return the specific pencil
     */
    @Override
    public PencilDTO getPencilByName(String name) {

        Pencil optionalPencil =  pencilRepository.findByName(name)
                .orElseThrow(()-> new ItemNotFoundException("Pen with name : " +name+ " does not exist"));

        return modelMapper.map(optionalPencil,new TypeToken<PencilDTO>(){}.getType());

    }

    /**
     * Add new Pencil
     * @param pencilDTO of pencil i want save
     */
    @Transactional
    @Override
    public void saveNewPencil(PencilDTO pencilDTO) {
        Optional<Pencil> optionalPencil =  pencilRepository.findByName(pencilDTO.getName());
        if(optionalPencil.isPresent()){
            throw new ItemAlreadyExistException("the Pen with  name : " +pencilDTO.getName()+ " is already store");
        }
        Pencil pencilForDataBase = modelMapper.map(pencilDTO,Pencil.class);

        pencilRepository.save(pencilForDataBase);
    }

    /**
     * Delete a Pencil with specific id
     * @param id of pencil i want delete
     */
    @Transactional
    @Override
    public void deletePencil(Long id) {
        boolean exist = pencilRepository.existsById(id);
        if(!exist){
            throw new ItemNotFoundException("Pen with id : " +id+ " not exist");
        }
        pencilRepository.deleteById(id);
    }

    /**
     * Update the fields to a specific  Pencil
     * @param id of pencil i want update
     * @param price is new value that might  update
     * @param stock is new value that might  update
     */
    @Transactional
    @Override
    public void updatePencil(Long id, Double price,Integer stock) {
        Pencil pencil = pencilRepository.findById(id).orElseThrow(()->
                new ItemNotFoundException("Pen with id : "+id+ " not exist"));


        if (price != null && price >= 0 && !Objects.equals(pencil.getPrice(), price)) {
            pencil.setPrice(price);
        }


        if (stock != null && stock >= 0 && !Objects.equals(pencil.getStock(), stock)) {
            pencil.setStock(stock);
        }

    }

}
