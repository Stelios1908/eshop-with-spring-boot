package com.example.eshop.entity.shop;

import com.example.eshop.entity.items.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
@Entity
@Table(name = "itemOrder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrder {

    @Id
    @SequenceGenerator(
            name = "itemOrder_seq",
            sequenceName = "itemOrder_seq",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "itemOrder_seq"

    )
    private Long id;


    @NotNull
    @OneToOne
    @JoinColumn(name="item")
    private Item item;

    @NotNull
    @Column(name="quantity")
    private int quantity;
}*/
