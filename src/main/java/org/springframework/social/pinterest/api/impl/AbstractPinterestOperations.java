package org.springframework.social.pinterest.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class AbstractPinterestOperations {
    private final boolean isAuthorized;

    public AbstractPinterestOperations(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException("pinterest");
        }
    }
}
