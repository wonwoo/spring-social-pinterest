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
		Data<User> user = pinterest.userOperations().getMe();
		values.setProviderUserId(user.getData().getId());
		values.setProfileUrl(user.getData().getImage().getProfile().getUrl());
		values.setImageUrl(user.getData().getImage().getProfile().getUrl());
		values.setDisplayName(user.getData().getFirst_name());
	}

	@Override
	public UserProfile fetchUserProfile(Pinterest pinterest) {
		Data<User> profile = pinterest.userOperations().getMe();
		return new UserProfileBuilder().setName(profile.getData().getFirst_name())
				.setUsername(profile.getData().getFirst_name()).build();
	}

	@Override
	public void updateStatus(Pinterest pinterest, String message) {
	}
}
