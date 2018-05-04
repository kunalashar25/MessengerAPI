package com.api.MessengerAPI.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource
{
	@GET
	public String testComment()
	{
		return "comment resource";
	}

	@GET
	@Path("/{commentId}")
	//you can access param of parent resource in child resources
	public String getCommentId(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
	{
		return "message id: " + messageId + " | comment id: " + commentId;
	}

}
