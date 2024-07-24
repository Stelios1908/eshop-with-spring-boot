package com.example.eshop.controller.item;


import com.example.eshop.dto.item.PenDTO;
import com.example.eshop.entity.items.Pen;
import com.example.eshop.service.item.PenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Pen")
@RequiredArgsConstructor
public class PenController {


    private final PenService penService;


    @GetMapping
    public List<PenDTO> getPen(){
        return penService.getAllPen();
    }

    @GetMapping(value = "/{id}")
    public PenDTO PenById(@PathVariable("id") Long id){
        return penService.getPenById(id);
    }

    @GetMapping(value ="name/{name}")
    public PenDTO PenName(@PathVariable(value = "name") String name){
        return penService.getPenByName(name);
    }


    //TODO change Pen with PenDTO
    @PostMapping
    public void savePen(@RequestBody PenDTO pen){
        penService.saveNewPen(pen);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deletePen(@PathVariable("id") Long id){
        penService.deletePen(id);
    }

    @PutMapping("update/{id}")
    public void upDatePen(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Integer stock){
    penService.updatePen(id,price,stock);
    }



}
