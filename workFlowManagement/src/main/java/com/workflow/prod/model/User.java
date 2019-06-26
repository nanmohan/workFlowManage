package com.workflow.prod.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "postgres_uservo", schema = "work_flow")
public class User {

	@Id
	@Column(name="user_id")
	private Long userId;

	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

	@JsonManagedReference
	@OneToMany(mappedBy="user")
    private List<AssignedTask> assignedTask;

	@JsonManagedReference
	@OneToMany(mappedBy="taskOwner")
    private List<Task> task;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<AssignedTask> getAssignedTask() {
		return assignedTask;
	}

	public void setAssignedTask(List<AssignedTask> assignedTask) {
		this.assignedTask = assignedTask;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
}
