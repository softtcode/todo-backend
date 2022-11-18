package com.softtcode.todo.controller;

import com.softtcode.todo.base.BaseResponse;
import com.softtcode.todo.model.entity.User;
import com.softtcode.todo.model.request.RegisterFormRequest;
import com.softtcode.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("register")
    public ResponseEntity<BaseResponse> userRegister(@RequestBody RegisterFormRequest requestForm){
        userService.register(requestForm);
        return null;
    }
}
