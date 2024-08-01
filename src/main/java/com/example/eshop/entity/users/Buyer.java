package com.example.eshop.entity.users;

import com.example.eshop.enums.BuyerCategoryEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Buyer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buyer extends Users {


    @NotNull
    @Column(name = "bonus")
    private  int bonus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "buyer_category")
    private BuyerCategoryEnum buyerCategory;

    public Buyer (Long id,
                  String name,
                  String email,
                  String password,
                  int bonus,
                  BuyerCategoryEnum buyerCategory
                  ){
        super(id,name,email,password);
        this.bonus=bonus;
        this.buyerCategory=buyerCategory;

    }

}
