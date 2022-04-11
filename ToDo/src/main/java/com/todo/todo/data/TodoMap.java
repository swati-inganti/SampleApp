package com.todo.todo.data;

public class TodoMap {

	public static ToDoJson mapToJson(ToDo obj) {
		ToDoJson json = new ToDoJson();
		json.setTaskId(obj.getTaskId());
		json.setTaskName(obj.getTaskName());
		json.setTaskDesc(obj.getTaskDesc());
		json.setCreatedDate(obj.getCreatedDate());
		json.setLastUpdatedDate(obj.getLastUpdatedDate());
		return json;

	}

	public static ToDo mapToObj(ToDoJson json) {
		ToDo obj = new ToDo();
		obj.setTaskId(json.getTaskId());
		obj.setTaskName(json.getTaskName());
		obj.setTaskDesc(json.getTaskDesc());
		obj.setCreatedDate(json.getCreatedDate());
		obj.setLastUpdatedDate(json.getLastUpdatedDate());
		return obj;

	}

}
