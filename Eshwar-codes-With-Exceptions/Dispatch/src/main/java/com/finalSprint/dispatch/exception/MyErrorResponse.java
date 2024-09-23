package com.finalSprint.dispatch.exception;


import java.util.Date;

public class MyErrorResponse {
 
	 private String message;
	 private String errorCode;
	 private Date time;
	 
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	 
	 
	 
	 
}