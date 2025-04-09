package com.testing.todoapp.service.impl;

import com.testing.todoapp.model.Todo;
import com.testing.todoapp.repository.TodoRepository;
import com.testing.todoapp.service.TodoService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public String createNewTodo(Todo todo) {
        try{
            todoRepository.save(todo);
            return "Success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    public Todo updateTodo(String id,Todo todo) {
        Todo rec = todoRepository.findById(id).orElseThrow();
        rec.setTitle(todo.getTitle());
        rec.setDescription(todo.getDescription());
        todoRepository.save(rec);
        return rec;
    }

    @Override
    public void delete(String id) {
        Todo rec = todoRepository.findById(id).orElseThrow();
        todoRepository.delete(rec);
    }
}
