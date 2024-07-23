package com.example.eshop.entity.shop;

import com.example.eshop.entity.items.Item;
import com.example.eshop.entity.users.Buyer;
import com.example.eshop.entity.users.Owen;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "Eshop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Eshop {

    @Id
    @SequenceGenerator(
            name = "eshop_seq",
            sequenceName = "eshop_seq",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "eshop_seq"

    )
    private Long id;

    @NotNull
    @Column( name ="name")
    private String name;


    @NotNull
    @OneToOne
    @JoinColumn( name ="owen_id")
    private Owen owen;


    @NotNull
    @Column( name ="item_list")
    private ArrayList<Item> iremsList = new ArrayList<Item>();


    @NotNull
    @Column( name ="buyer_list")
    private ArrayList<Buyer> buyerList = new ArrayList<Buyer>();

}

