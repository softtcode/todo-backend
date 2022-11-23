package com.softtcode.todo.model.response;

import com.softtcode.todo.model.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TodoResponseList {
    private Long userId;
    private List<Todo> todo;

    public TodoResponseList() {

    }
}
