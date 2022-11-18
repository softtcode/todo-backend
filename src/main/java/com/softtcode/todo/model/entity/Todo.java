package com.softtcode.todo.model.entity;

import com.softtcode.todo.base.BaseEntity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Todo extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private User user;
    @Column(columnDefinition = "boolean default false",nullable = false)
    private Boolean isCompleted=false;
}
