package org.springframework.social.pinterest.api;

import org.springframework.social.ApiException;

/**
 * Created by wonwoo on 15. 12. 16..
 */
public class RequiredParameterException extends ApiException{
    public RequiredParameterException(String message) {
        super("pinterest", message);
    }
}
