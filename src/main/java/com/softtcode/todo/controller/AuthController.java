package com.softtcode.todo.controller;

import com.softtcode.todo.base.BaseResponse;
import com.softtcode.todo.model.request.LoginFormRequest;
import com.softtcode.todo.model.request.RegisterFormRequest;
import com.softtcode.todo.model.response.LoginResponse;
import com.softtcode.todo.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<BaseResponse<?>> userRegister(@RequestBody @Valid RegisterFormRequest formRequest){
        userService.register(formRequest);
        return ResponseEntity.ok(BaseResponse.ok());
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody @Valid LoginFormRequest formRequest){
       LoginResponse data = userService.login(formRequest);
       return ResponseEntity.ok(BaseResponse.ok(data));
    }
}
