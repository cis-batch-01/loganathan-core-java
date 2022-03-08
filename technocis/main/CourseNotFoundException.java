package com.technocis.main;

public class CourseNotFoundException extends Exception {

	String msg;

	public CourseNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public CourseNotFoundException() {
		super();

	}

	@Override
	public String getMessage() {

		return this.msg;
	}

}
