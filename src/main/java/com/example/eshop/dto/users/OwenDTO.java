package com.example.eshop.dto.users;

import com.example.eshop.entity.users.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwenDTO extends Users {

    private boolean isAdmin;

    public OwenDTO(Long id,String name,String email,boolean isAdmin){
        super(id,name,email);
        this.isAdmin=isAdmin;
    }
}
