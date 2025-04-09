package com.testing.todoapp.service;

import com.testing.todoapp.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodo();

    public String createNewTodo(Todo todo);

    public Todo updateTodo(String id,Todo todo);

    public void delete(String id);
}
