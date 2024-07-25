package com.example.eshop.dto.users;

import com.example.eshop.entity.users.Users;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwenDTO extends Users {

    private boolean isAdmin;

    public OwenDTO(Long id,String name,String email,String password,boolean isAdmin){
        super(id,name,email,password);
        this.isAdmin=isAdmin;
    }
}
