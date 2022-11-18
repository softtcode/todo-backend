package com.softtcode.todo.model.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String jwt;
    private String email;
}
