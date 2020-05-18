package com.example.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {
	
	private String errorCode;
	private String message;
	int status;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yy-MM-dd hh:mm:ss")
	LocalDateTime timestamp;
	
	
	public ErrorMessage(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
