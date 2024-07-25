package com.example.eshop.service.item;

import com.example.eshop.dto.item.PenDTO;
import com.example.eshop.dto.item.PencilDTO;
import com.example.eshop.entity.items.Pencil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PencilService {

    public List<PencilDTO> getAllPencil();

    PencilDTO getPencilById(Long id);

    PencilDTO getPencilByName(String name);

    void saveNewPencil(PencilDTO pencilDTO);

    void deletePencil(Long id);

    void updatePencil(Long id, Double price, Integer stock);
}
