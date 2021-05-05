package com.easycerti.datacenter.model;

enum Status {
	OK, KO
}

public class ApiResponse {
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
