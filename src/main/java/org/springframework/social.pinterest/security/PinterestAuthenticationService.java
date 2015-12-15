package org.springframework.social.pinterest.security;

import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.connect.PinterestConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestAuthenticationService extends OAuth2AuthenticationService<Pinterest> {

    public PinterestAuthenticationService(String clientId, String appSecret) {
        super(new PinterestConnectionFactory(clientId,appSecret));
    }
}