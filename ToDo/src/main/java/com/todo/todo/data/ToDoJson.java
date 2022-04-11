package com.todo.todo.data;

import java.sql.Date;

public class ToDoJson {

	private Integer taskId;
	private String taskName;
	private String taskDesc;
	private Date createdDate;
	private Date lastUpdatedDate;

	public ToDoJson() {
		super();
	}

	public ToDoJson(Integer taskId, String taskName, String taskDesc, Date createdDate, Date lastUpdatedDate) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.createdDate = createdDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
