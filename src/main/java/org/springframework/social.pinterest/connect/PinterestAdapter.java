package org.springframework.social.pinterest.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.pinterest.api.Pinterest;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestAdapter implements ApiAdapter<Pinterest> {

    @Override
    public boolean test(Pinterest api) {
        return false;
    }

    @Override
    public void setConnectionValues(Pinterest pinterest, ConnectionValues values) {

    }

    @Override
    public UserProfile fetchUserProfile(Pinterest pinterest) {
        return null;
    }

    @Override
    public void updateStatus(Pinterest pinterest, String message) {
    }
}
