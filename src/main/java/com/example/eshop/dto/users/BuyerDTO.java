package com.example.eshop.dto.users;

import com.example.eshop.enums.BuyerCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuyerDTO extends UsersDTO{

    private  int bonus;

    private BuyerCategoryEnum buyerCategory;

    public BuyerDTO(Long id,
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
