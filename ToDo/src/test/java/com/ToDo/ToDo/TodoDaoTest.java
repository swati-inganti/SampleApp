package com.ToDo.ToDo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.todo.todo.dao.ToDoDao;
import com.todo.todo.data.ToDo;

@SpringBootTest
public class TodoDaoTest {
	
	@Autowired
	ToDoDao repo;
	
	@Test
	public void getTodoByIdTest() {
		ToDo rec = new ToDo(100, "Bank", "Bank form", null,  null);
		repo.save(rec);
		boolean result = repo.existsById(100);
		assertEquals(true, result);
	}
	
	@Test
	public void getTodoListTest() {
		ToDo rec = new ToDo(100, "Bank", "Bank form", null,  null);
		repo.save(rec);
		boolean result = repo.exists(Example.of(rec));
		assertEquals(true, result);
	}
	
	@Test
	public void saveTodo() {
		ToDo rec = new ToDo(101 ,"Dentist", "Visit Dentist", null,  null);
		repo.save(rec);
		boolean result = repo.exists(Example.of(rec));
		assertEquals(true, result);
	}

}
