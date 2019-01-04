package com.api.MessengerAPI.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.api.MessengerAPI.Database.Database;
import com.api.MessengerAPI.Model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService() {
		profiles.put("Profile1", new Profile(1L, "Profile1", "FirstName1", "LastName1"));
		profiles.put("Profile2", new Profile(2L, "Profile2", "FirstName2", "LastName2"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {		
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profile.setId(profiles.get(profile.getProfileName()).getId());		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}