package com.example.eshop.service.item;
import com.example.eshop.dto.item.PenDTO;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface PenService {


    List<PenDTO> getAllPen();

    PenDTO getPenById(Long id);

    PenDTO getPenByName(String name);

    void saveNewPen(PenDTO penDTO);

    void deletePen(Long id);

    void updatePen(Long id, Double price, Integer stock);


}
