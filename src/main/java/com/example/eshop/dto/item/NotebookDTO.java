package com.example.eshop.dto.item;

import com.example.eshop.enums.ItemTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotebookDTO  extends ItemDTO{

    private int section;

    public NotebookDTO(Long id, String name, Double price, String description, int stock, int section) {
        super(id, name, ItemTypeEnum.Notebook,price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
        this.section= section;

    }
}
