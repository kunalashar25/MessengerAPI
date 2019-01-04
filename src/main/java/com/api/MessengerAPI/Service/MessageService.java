package com.api.MessengerAPI.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.api.MessengerAPI.Database.Database;
import com.api.MessengerAPI.Exception.DataNotFoundException;
import com.api.MessengerAPI.Model.Message;

public class MessageService
{

	private Map<Long, Message> messages = Database.getMessages();

	// to set initial list
	public MessageService()
	{
		messages.put(1L, new Message(1, "Message1", "Author1"));
		messages.put(2L, new Message(2, "Message2", "Author2"));
	}

	// to get all messages from list
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}

	// to get all messages from list for a particular year
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values())
		{
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year)
			{
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}

	// to get all messages from list in pages
	public List<Message> getAllMessagesInPagination(int start, int size)
	{
		List<Message> messageList = new ArrayList<Message>(messages.values());

		if (start + size > messageList.size())
		{
			return new ArrayList<Message>();
		}

		return messageList.subList(start, start + size);
	}

	// to get single message from list
	public Message getMessage(long messageId)
	{
		Message message = messages.get(messageId);
		if(message == null)
		{
			throw new DataNotFoundException("No Data Found for Message with Id "+messageId);
		}
		return message;
	}

	// to add a message
	public Message addMessage(Message message)
	{
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}

	// to update a message
	public Message updateMessage(Message message)
	{
		if (message.getId() <= 0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	// to remove a message
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
}
