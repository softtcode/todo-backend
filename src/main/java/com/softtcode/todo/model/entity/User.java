package com.softtcode.todo.model.entity;

import com.softtcode.todo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Data
public class User extends BaseEntity {
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default false",nullable = false)
    private Boolean isEnable=false;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Todo> todos;
}
