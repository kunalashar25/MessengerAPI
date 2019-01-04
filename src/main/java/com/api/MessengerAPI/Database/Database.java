package com.api.MessengerAPI.Database;

import java.util.HashMap;
import java.util.Map;

import com.api.MessengerAPI.Model.Message;
import com.api.MessengerAPI.Model.Profile;

public class Database
{
	private static Map<Long, Message>	messages	= new HashMap<Long,Message>();
	private static Map<String, Profile>	profiles	= new HashMap<String,Profile>();

	public static Map<Long, Message> getMessages()
	{
		return messages;
	}

	public static Map<String, Profile> getProfiles()
	{
		return profiles;
	}
}
