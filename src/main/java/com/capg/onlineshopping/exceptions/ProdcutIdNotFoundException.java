package com.capg.onlineshopping.exceptions;

public class ProdcutIdNotFoundException extends RuntimeException {
	String msg;
	public ProdcutIdNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMsg()
    {
    	return msg;
    }


}
