package com.todo.todo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.ToDoApplication;
import com.todo.todo.data.ToDo;
import com.todo.todo.exception.TodoException;
import com.todo.todo.service.impl.ToDoService;

@RestController
@ComponentScan
@RequestMapping("/myapp")
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoRestController {

	private static final Logger logger = LogManager.getLogger(ToDoApplication.class);

	@Autowired
	private ToDoService service;

	/* Handler method to get list of tasks */
	@RequestMapping(method = { RequestMethod.GET }, value = { "/get-todo-listing" })
	public List<ToDo> getToDoList() {
		logger.debug("Entering getToDoList()");
		List<ToDo> list = service.getToDoList();
		logger.debug("Exiting getToDoList()");
		return list;

	}

	/* Handler method to get task by id */
	@RequestMapping(method = { RequestMethod.GET }, value = { "/get-todo-by-id/{todoId}" })
	public ResponseEntity<ToDo> getToDoById(@PathVariable Integer todoId, HttpServletRequest request,
			HttpServletResponse response) throws TodoException {
		logger.debug("Entering getToDoById() with id : " + todoId);
		Optional<ToDo> rec = service.getTodoById(todoId);

		if (rec.isPresent()) {
			logger.debug("Exiting getToDoById() with id : " + rec.get().getTaskId());
			ToDo retRec = rec.get();
			return ResponseEntity.ok().body(retRec);
		} else {
			throw new TodoException("Record not found for this id : " + todoId);
		}

	}

	/* Handler method to save a task */
	@RequestMapping(method = { RequestMethod.POST }, value = { "/save-todo" })
	public ToDo saveTodo(@RequestBody ToDo rec) throws TodoException {
		logger.debug("Entering saveTodo()");
		logger.debug("saving...." + rec.toString());
		ToDo retRec = service.insertTodo(rec);
		logger.debug("Exiting saveTodo()");
		return retRec;

	}

	/* Handler method to update a task */
	@RequestMapping(method = { RequestMethod.PUT }, value = { "/update-todo/{todoId}" })
	public ResponseEntity<ToDo> updateTodo(@PathVariable Integer todoId, @RequestBody ToDo rec) throws TodoException {
		logger.debug("Entering updateTodo()");
		logger.debug("updating..." + rec.toString());
		ToDo updRec = service.updateTodo(rec);
		logger.debug("Exiting updateTodo()");
		return ResponseEntity.ok(updRec);

	}

	/* Handler method to delete a task */
	@RequestMapping(method = { RequestMethod.DELETE }, value = { "/delete-todo/{todoId}" })
	public String deleteTodo(@PathVariable Integer todoId, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Entering deleteTodo() with id : " + todoId);
		String result = service.deleteTodo(todoId);
		logger.debug("Exiting deleteTodo()");
		return result;

	}

}
