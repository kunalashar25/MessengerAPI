package com.api.MessengerAPI.Exception;

public class DataNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -6641159628910745655L;

	public DataNotFoundException(String message)
	{
		super(message);
	}

}
