package com.todo.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todo.data.ToDo;

@Repository
public interface ToDoDao extends JpaRepository<ToDo, Integer> {
}
