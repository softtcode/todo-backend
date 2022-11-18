package com.softtcode.todo.model.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;

@Data
@Validated
public class LoginFormRequest {
    @Email
    private String email;
    private String password;
}
