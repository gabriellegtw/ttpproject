package com.example.ttpproject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthDTO {
    private String email;
    private String password;

    public AuthDTO() {}

    public AuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
