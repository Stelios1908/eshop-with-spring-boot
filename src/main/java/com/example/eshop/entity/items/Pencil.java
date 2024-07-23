package com.example.eshop.entity.items;

import com.example.eshop.enums.ItemTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "pencil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pencil extends Item{


    @NotNull
    @Column(name ="tipsize")
    private int tipSize;

    @NotNull
    @Column(name ="type")
    private int type;

    public Pencil(Long id, String name, Double price, String description, int stock, int tipSize, int type) {
        super(id, name, ItemTypeEnum.Pencil,price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
        this.tipSize= tipSize;
        this.type = type;
    }

}
