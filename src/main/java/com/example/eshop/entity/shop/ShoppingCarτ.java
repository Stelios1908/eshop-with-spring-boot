package com.example.eshop.entity.shop;


import com.example.eshop.entity.items.Item;
import com.example.eshop.entity.users.Buyer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "ShoppingCart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCarτ {

    @Id
    @SequenceGenerator(
            name = "shopping_card_seq",
            sequenceName = "shopping_card_seq",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shopping_card_seq"

    )
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @NotNull
    @Column(name="quantity")
    private int quantity;


}
