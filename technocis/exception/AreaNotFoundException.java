package com.technocis.exception;

public class AreaNotFoundException extends Exception {
	String msg;

	public AreaNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public AreaNotFoundException() {
		super();


	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	

}
