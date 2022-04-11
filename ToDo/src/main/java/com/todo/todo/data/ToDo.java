package com.todo.todo.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TODO")
public class ToDo {

	@Id
	@Column(name = "TaskId")
	private Integer taskId;
	@Column(name = "TaskName")
	private String taskName;
	@Column(name = "TaskDesc")
	private String taskDesc;
	@Column(name = "CreatedDate")
	private Date createdDate;
	@Column(name = "LastUpdatedDate")
	private Date lastUpdatedDate;

	public ToDo() {
		super();
	}

	@Override
	public String toString() {
		return "ToDo [taskId=" + taskId + ", taskName=" + taskName + ", taskDesc=" + taskDesc + ", createdDate="
				+ createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	public ToDo(Integer taskId, String taskName, String taskDesc, Date createdDate, Date lastUpdatedDate) {
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
