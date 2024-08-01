package com.example.eshop.entity.users;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owen extends Users {

    @NotNull
    @Column(name = "is_admin")
    private boolean isAdmin;

    public Owen(Long id,String name,String email,String password,boolean isAdmin){
        super(id,name,email,password);
        this.isAdmin=isAdmin;
    }
}
