package com.topics;

public class ChapterNotFoundException extends Exception {

	String msg;
	public ChapterNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	public ChapterNotFoundException() {
		super();
		
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.msg;
	}

	
	

}
