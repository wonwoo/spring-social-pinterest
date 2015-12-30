package org.springframework.social.pinterest.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.User;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestAdapter implements ApiAdapter<Pinterest> {

	@Override
	public boolean test(Pinterest pinterest) {
		try {
			pinterest.userOperations().getMe();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	@Override
	public void setConnectionValues(Pinterest pinterest, ConnectionValues values) {
		Data<User> userData = pinterest.userOperations().getMe();
		User user = userData.getData();
		values.setProviderUserId(user.getId());
		values.setProfileUrl(user.getImage().getProfile().getUrl());
		values.setImageUrl(user.getImage().getProfile().getUrl());
		values.setDisplayName(user.getUsername());
	}

	@Override
	public UserProfile fetchUserProfile(Pinterest pinterest) {
		Data<User> profileData = pinterest.userOperations().getMe();
		User user = profileData.getData();
		return new UserProfileBuilder().setName(user.getFirst_name())
				.setFirstName(user.getFirst_name())
				.setLastName(user.getLast_name())
				.setId(user.getId())
				.setUsername(user.getUsername())
				.build();
	}

	@Override
	public void updateStatus(Pinterest pinterest, String message) {
	}
}
