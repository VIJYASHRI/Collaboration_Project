package com.niit.dao;

import com.niit.model.ProfilePicture;

public interface ProfileUploadDao {
	void save (ProfilePicture profilepicture);
	ProfilePicture getProfilePic(String username);
}
