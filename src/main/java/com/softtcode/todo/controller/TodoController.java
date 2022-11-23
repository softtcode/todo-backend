package com.softtcode.todo.controller;

import com.softtcode.todo.base.BaseResponse;
import com.softtcode.todo.model.response.TodoResponseList;
import com.softtcode.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todo")
    public ResponseEntity<BaseResponse<?>> getTodoByUserId(@RequestHeader(name = "Authorization") String token){
        BaseResponse<TodoResponseList> response = new BaseResponse<>();
        response = todoService.getTodo(token);
        return ResponseEntity.ok(response);
    }
}
