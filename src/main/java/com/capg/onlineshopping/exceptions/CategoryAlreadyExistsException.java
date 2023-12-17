package com.capg.onlineshopping.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException{
	String msg;
	public CategoryAlreadyExistsException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMsg()
    {
    	return msg;
    }


}
