package com.api.MessengerAPI.Service;

import java.util.ArrayList;
import java.util.List;

import com.api.MessengerAPI.Model.Message;

public class MessageService
{

	public List<Message> getAllMessages()
	{
		Message m1 = new Message(1L, "Message1", "Author1");
		Message m2 = new Message(2L, "Message2", "Author2");

		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);

		return list;
	}
}
