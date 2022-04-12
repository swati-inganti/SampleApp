package com.ToDo.ToDo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.todo.dao.ToDoDao;
import com.todo.todo.data.ToDo;
import com.todo.todo.exception.TodoException;
import com.todo.todo.service.impl.ToDoService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TodoServiceTest {

	@Mock
	public ToDoDao repo;

	public ToDoService service;

	@BeforeEach
	void setUp() {
		this.service = new ToDoService(repo);
	}

	@Test
	public void getTodoListTest() throws TodoException {
		ToDo rec = new ToDo(100, "Bank", "Bank form", null, null);
		service.insertTodo(rec);
		List<ToDo> list = service.getToDoList();
		assertEquals(0, list.size());
	}
	
	@Test
	public void getTodoByIdTest() throws TodoException {
		ToDo rec = new ToDo(100, "Bank", "Bank form", null, null);
		service.insertTodo(rec);
		Optional<ToDo> retRec = service.getTodoById(100);
		assertNotNull(retRec);
	}

}
