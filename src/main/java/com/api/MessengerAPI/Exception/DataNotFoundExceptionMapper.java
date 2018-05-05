package com.api.MessengerAPI.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.api.MessengerAPI.Model.ErrorMessage;

//this class is used to map a particular exception so that jax-rs will know and it'll not print tomcat error page in 
//response body and by implementing this approach we can display our own data in response body incase of this exception

@Provider // this annotation registers mapper class in jax-rs. so whenever there is
			// dataNotFound exception thrown, it'll come to this class and will generate
			// custom response
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{
	@Override
	public Response toResponse(DataNotFoundException ex)
	{
		// creating custom response for this exception
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
