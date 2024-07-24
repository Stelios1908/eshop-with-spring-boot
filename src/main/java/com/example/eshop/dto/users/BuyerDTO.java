package com.example.eshop.dto.users;

import com.example.eshop.enums.BuyerCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuyerDTO extends UsersDTO{

    private  int bonus;

    private BuyerCategoryEnum buyerCategory;

    public BuyerDTO(Long id,
                    String name,
                    String email,
                    int bonus,
                    BuyerCategoryEnum buyerCategory
    ){
        super(id,name,email);
        this.bonus=bonus;
        this.buyerCategory=buyerCategory;

    }
}
