package com.todo.todo.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.ToDoApplication;
import com.todo.todo.dao.ToDoDao;
import com.todo.todo.data.ToDo;
import com.todo.todo.exception.TodoException;

@Service
public class ToDoService {

	private static final Logger logger = LogManager.getLogger(ToDoApplication.class);

	@Autowired
	private ToDoDao dao;

	/* Service method to retrieve task list */
	public List<ToDo> getToDoList() {
		logger.debug("Entering getToDoList()");
		List<ToDo> list = dao.findAll();
		logger.debug("Exiting getToDoList()");
		return list;
	}

	/* Service method to retrieve task by id */
	public Optional<ToDo> getTodoById(Integer id) {
		logger.debug("Entering getTodoById() with id : " + id);
		Optional<ToDo> rec = dao.findById(id);
		logger.debug("Exiting getTodoById()");
		return rec;
	}

	/* Service method to insert task */
	public ToDo insertTodo(ToDo rec) throws TodoException {
		try {
			logger.debug("Entering insertTodo()");
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			rec.setCreatedDate(date);
			rec.setLastUpdatedDate(date);
			ToDo saveRec = dao.save(rec);
			logger.debug("Exiting insertTodo()");
			return saveRec;
		} catch (Exception e) {
			throw new TodoException("Error creating record, task id is null");
		}
	}

	/* Service method to delete task */
	public String deleteTodo(Integer id) {
		logger.debug("Entering deleteTodo()");
		Optional<ToDo> rec = dao.findById(id);
		if (rec.isPresent()) {
			ToDo delRec = rec.get();
			dao.delete(delRec);
			logger.debug("Exiting deleteTodo() after deleting the record");
			return "Successfully Deleted";
		} else {
			logger.debug("Exiting deleteTodo() : record not found");
			return "Record Not Found";
		}
	}

	/* Service method to update task */
	public ToDo updateTodo(ToDo rec) {
		logger.debug("Entering updateTodo()");
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		rec.setLastUpdatedDate(date);
		Optional<ToDo> oldrec = dao.findById(rec.getTaskId());
		ToDo todo = null;
		if (oldrec.isPresent()) {
			todo = oldrec.get();
			todo.setTaskId(rec.getTaskId());
			todo.setTaskName(rec.getTaskName());
			todo.setTaskDesc(rec.getTaskDesc());
			todo.setCreatedDate(rec.getCreatedDate());
			todo.setLastUpdatedDate(rec.getLastUpdatedDate());
			dao.save(todo);
		} else {
			return new ToDo();
		}
		logger.debug("Exiting updateTodo()");
		return todo;
	}

}
