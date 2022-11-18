package com.softtcode.todo.model.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@Validated
public class RegisterFormRequest {
    @Email
    private String email;
    private String password;
}
