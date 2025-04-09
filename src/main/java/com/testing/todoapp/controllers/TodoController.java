package com.testing.todoapp.controllers;

import com.testing.todoapp.model.Todo;
import com.testing.todoapp.repository.TodoRepository;
import com.testing.todoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodo(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNewTodo(@RequestBody Todo todo){
        HttpStatus stcode;
        String result = todoService.createNewTodo(todo);
        if(result.equals("Success")){
            stcode = HttpStatus.CREATED;
        }else{
            stcode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result,stcode);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateSingleTodo(@PathVariable("id") String id,@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(id,todo),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id){
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
