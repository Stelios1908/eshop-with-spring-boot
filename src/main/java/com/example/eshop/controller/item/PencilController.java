package com.example.eshop.controller.item;


import com.example.eshop.dto.item.PencilDTO;
import com.example.eshop.entity.items.Pencil;
import com.example.eshop.service.item.PencilService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/Pencil")
@RequiredArgsConstructor
public class PencilController {

    public final PencilService pencilService;

    public final ModelMapper modelMapper;

    @GetMapping
    public List<PencilDTO> getPencil(){
        return pencilService.getAllPencil();
    }
}
