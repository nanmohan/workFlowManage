package com.workflow.prod.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "task", schema = "work_flow")
public class Task {
	
	@Id
	@Column(name="task_id")
	private Long taskId;

	@Column(name="task_name")
	private String taskName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

	@Column(name="user_id")
    private Long assignedUserId;
	
	@JsonBackReference
	@ManyToOne	
    @JoinColumn(name="task_owner", nullable=false)
    private User taskOwner;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(Long assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(User taskOwner) {
		this.taskOwner = taskOwner;
	}

}