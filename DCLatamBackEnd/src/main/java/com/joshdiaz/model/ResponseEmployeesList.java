package com.joshdiaz.model;

import java.util.List;

public class ResponseEmployeesList {
	
	private String status;
	private List<Employee> data;
	private String message;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Employee> getData() {
		return data;
	}
	public void setData(List<Employee> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseEmployeesList [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	
	

}
