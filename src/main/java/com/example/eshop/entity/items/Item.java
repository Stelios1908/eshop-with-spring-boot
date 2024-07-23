package com.example.eshop.entity.items;


import com.example.eshop.dto.item.ItemDTO;
import com.example.eshop.enums.ItemTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {


    @Id
    @SequenceGenerator(
            name = "seq_paper",
            sequenceName = "seq_paper",
            allocationSize=50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_paper"
    )
    private Long id;

    @NotNull
    @Column(name ="name")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ItemTypeEnum category;

    @NotNull
    @Column(name ="price")
    private Double price;

    @NotNull
    @Column(name ="description")
    private String description;

    @NotNull
    @Column(name ="stock")
    private int stock;

}
