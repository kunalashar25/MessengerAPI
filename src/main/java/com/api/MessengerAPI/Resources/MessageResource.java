package com.api.MessengerAPI.Resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.api.MessengerAPI.Model.Message;
import com.api.MessengerAPI.Resources.FilterBean.MessageFilterBean;
import com.api.MessengerAPI.Service.MessageService;

@Path("/messages")
@Consumes(
{ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
@Produces(
{ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
public class MessageResource
{
	MessageService messageService = new MessageService();

	/*
	 * @GET
	 * 
	 * public List<Message> getMessages(@QueryParam("year") int
	 * year, @QueryParam("start") int start,
	 * 
	 * @QueryParam("size") int size)
	 * {
	 * if (year > 0)
	 * {
	 * return messageService.getAllMessagesForYear(year);
	 * }
	 * if (start >= 0 && size >= 0)
	 * {
	 * return messageService.getAllMessagesInPagination(start, size);
	 * }
	 * return messageService.getAllMessages();
	 * }
	 */
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean)
	{
		if (filterBean.getYear() > 0)
		{
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >= 0)
		{
			return messageService.getAllMessagesInPagination(filterBean.getStart(), filterBean.getSize());
		}
		System.out.println("here");
		return messageService.getAllMessages();
	}

	/*
	 * @POST
	 * public Message addMessage(Message message)
	 * {
	 * return messageService.addMessage(message);
	 * }
	 */

	// to get control over response using response builder i.e. to create custom
	// status code. So when a new message is created, status would be 201 instead of
	// 200 and will return location of created message
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo)
	{
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message)
	{
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId)
	{
		messageService.removeMessage(messageId);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId)
	{
		return messageService.getMessage(messageId);
	}

	// Sub-Resource Locators aren't supposed to have HTTP method annotations
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
