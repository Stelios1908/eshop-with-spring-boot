package com.example.eshop.entity.items;


import com.example.eshop.dto.item.ItemDTO;
import com.example.eshop.enums.ItemTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notebook")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notebook extends Item{

    @NotNull
    @Column(name ="section")
    private int section;

    public Notebook(Long id, String name, Double price, String description, int stock, int section) {
        super(id, name, ItemTypeEnum.Notebook,price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
        this.section= section;

    }

}
