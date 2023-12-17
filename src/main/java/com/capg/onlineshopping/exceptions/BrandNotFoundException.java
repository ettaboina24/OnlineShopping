package com.capg.onlineshopping.exceptions;

public class BrandNotFoundException extends Exception{
	String msg;
	
public BrandNotFoundException(String msg)
{
	super(msg);
	this.msg=msg;
}

public String getMsg() {
	return msg;
}


}
