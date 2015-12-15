package org.springframework.social.pinterest.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.impl.PinterestTemplate;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestServiceProvider extends AbstractOAuth2ServiceProvider<Pinterest> {

    private String appNamespace;

    public PinterestServiceProvider(String clientId, String appSecret, String appNamespace) {
        super(new PinterestOAuth2Template(clientId, appSecret));
        this.appNamespace = appNamespace;
    }

    public Pinterest getApi(String accessToken) {
        return new PinterestTemplate(accessToken);
    }
}
