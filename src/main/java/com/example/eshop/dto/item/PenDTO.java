package com.example.eshop.dto.item;

import com.example.eshop.entity.items.Item;
import com.example.eshop.enums.ItemTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PenDTO extends ItemDTO {


    private String  color;
    private int tipSize;

    public PenDTO(Long id, String name, Double price, String description, int stock, String color, int tipSixe) {
        super(id, name, ItemTypeEnum.Pen, price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
        this.color= color;
        this.tipSize = tipSize;
    }
}
