package com.example.eshop.entity.items;

import com.example.eshop.enums.ItemTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pen extends Item{

    @NotNull
    @Column(name ="color")
    private String color;

    @NotNull
    @Column(name ="tipsize")
    private int tipSize;

    public Pen(Long id, String name, Double price, String description, int stock, String color, int tipSixe) {
        super(id, name, ItemTypeEnum.Pen, price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
        this.color= color;
        this.tipSize = tipSize;
    }
}
