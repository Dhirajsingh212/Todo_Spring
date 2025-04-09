package com.testing.todoapp.repository;

import com.testing.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,String> {
}
