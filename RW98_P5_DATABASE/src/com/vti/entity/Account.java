package com.vti.entity;

import java.time.LocalDateTime;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private int departmentId;
	private int positionId;
	private LocalDateTime createdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public LocalDateTime getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}

	public Account(int id, String email, String username, String fullname, int departmentId, int positionId,
			LocalDateTime createdate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.departmentId = departmentId;
		this.positionId = positionId;
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullname=" + fullname
				+ ", departmentId=" + departmentId + ", positionId=" + positionId + ", createdate=" + createdate + "]";
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
