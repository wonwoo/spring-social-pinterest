package org.springframework.social.pinterest.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.pinterest.api.Pinterest;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestConnectionFactory extends OAuth2ConnectionFactory<Pinterest> {

    public PinterestConnectionFactory(String appId, String appSecret) {
        this(appId, appSecret, null);
    }

    public PinterestConnectionFactory(String appId, String appSecret, String appNamespace) {
        super("pinterest", new PinterestServiceProvider(appId, appSecret, appNamespace), new PinterestAdapter());
    }
}