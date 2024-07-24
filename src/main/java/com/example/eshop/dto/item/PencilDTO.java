package com.example.eshop.dto.item;


import com.example.eshop.enums.ItemTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PencilDTO extends ItemDTO {

    private int tipSize;

    /**
     * TODO add comments
     */
    private int type;


    public PencilDTO(Long id, String name, Double price, String description, int stock, int tipSize, int type) {
        super(id, name, ItemTypeEnum.Pencil,price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
        this.tipSize= tipSize;
        this.type = type;
    }
}
