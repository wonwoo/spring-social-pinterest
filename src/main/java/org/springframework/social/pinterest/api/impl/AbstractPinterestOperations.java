package org.springframework.social.pinterest.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.pinterest.api.RequiredParameterException;
import org.springframework.util.ObjectUtils;

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

    public String getBaseUrl() {
        return "https://api.pinterest.com/v1/";
    }

    protected void requiredParameters(Object... parameters) {
        for(Object obj : parameters){
            if(obj == null){
                throw new RequiredParameterException("No Such Parameter Exception");
            }
        }
    }

}
