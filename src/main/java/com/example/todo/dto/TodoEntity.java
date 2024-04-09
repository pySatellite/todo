package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TodoEntity {
    private Integer  id ;
    private String   subject ;
    public String   body ;
    public Boolean  completed ;
}
