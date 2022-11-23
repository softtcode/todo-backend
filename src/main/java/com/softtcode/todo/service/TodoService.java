package com.softtcode.todo.service;


import com.softtcode.todo.base.BaseResponse;
import com.softtcode.todo.helper.JwtHelper;
import com.softtcode.todo.model.entity.Todo;
import com.softtcode.todo.model.response.TodoResponseList;
import com.softtcode.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    UserService userService;
    public BaseResponse<TodoResponseList> getTodo(String token) {
        TodoResponseList response = new TodoResponseList();
        String email = jwtHelper.getTokenSubject(token);
        Long userId = userService.findById(email);
        List<Todo> dbTodo = todoRepository.findByUserId(userId);
        response.setTodo(dbTodo);
        return BaseResponse.ok(response);
    }
}
