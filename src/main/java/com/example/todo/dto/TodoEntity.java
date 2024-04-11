package com.example.todo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
public class TodoEntity {
	private Integer id;
	private String subject;
	public String body;
	public Boolean completed;
}
