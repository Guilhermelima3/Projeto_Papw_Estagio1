package com.guilherme.rest.exception;



public class StandardError {
	
	private String msg;
	private Integer status;
	
	public StandardError() {
		
	}
	
	public StandardError(String msg, Integer status) {
		super();
		this.msg = msg;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
