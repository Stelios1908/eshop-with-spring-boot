package com.example.eshop.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDTO {

    private Long id;

    private String name;

    private String email;

    private String password;
}
