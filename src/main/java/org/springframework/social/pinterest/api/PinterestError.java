package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestError {
    private String errorType;
    private String message;

    public PinterestError(){}

    public PinterestError(String errorType, String message) {
        this.errorType = errorType;
        this.message = message;

    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
