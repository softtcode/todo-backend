package com.softtcode.todo.model.request;

import lombok.Data;

@Data
public class RegisterFormRequest {
    private String email;
    private String password;
}
