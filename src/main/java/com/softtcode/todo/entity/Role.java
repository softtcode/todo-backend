package com.softtcode.todo.entity;

import com.softtcode.todo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Role extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
