package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TodoEntity {
    public Integer  id ; 
    public String   subject ;
    public String   body ;
    public Boolean  completed ; 
}
