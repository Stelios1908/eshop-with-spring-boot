package com.example.eshop.service.item;


import com.example.eshop.dto.item.PenDTO;
import com.example.eshop.dto.item.PencilDTO;
import com.example.eshop.entity.items.Pencil;
import com.example.eshop.repository.items.PencilRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PencilService {

    public final PencilRepository pencilRepository;
    public final ModelMapper modelMapper;

    public List<PencilDTO> getAllPencil() {
        List<Pencil> pencilList = pencilRepository.findAll();
        return modelMapper.map(pencilList,  new TypeToken<List<PencilDTO>>(){}.getType());
    }
}
