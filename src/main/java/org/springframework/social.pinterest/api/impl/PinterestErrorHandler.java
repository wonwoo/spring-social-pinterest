package org.springframework.social.pinterest.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.social.pinterest.api.PinterestError;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestErrorHandler extends DefaultResponseErrorHandler {

    private static final String DAUM_PROVIDER_ID = "daum";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String errorString = readResponseJson(response);
        ObjectMapper mapper = new ObjectMapper();
        PinterestError error = mapper.readValue(errorString, PinterestError.class);
        handleFacebookError(response.getStatusCode(), error);
    }

    void handleFacebookError(HttpStatus statusCode, PinterestError error) {
        int code = statusCode.value();
        System.out.println(code);
//        if (code == ETC) {
//            throw new ServerException(DAUM_PROVIDER_ID, error.getMessage());
//        } else if (code == REQUEST_THROTTLED) {
//            throw new RateLimitExceededException(DAUM_PROVIDER_ID);
//        } else if (code == NOT_AUTHORIZED_ERROR) {
//            throw new NotAuthorizedException(DAUM_PROVIDER_ID,error.getMessage());
//        } else if (code == UNAUTHORIZED ) {
//            throw new InvalidAuthorizationException(DAUM_PROVIDER_ID, error.getMessage());
//        } else if (code == ACCESS_DENIED_ERROR) {
//            throw new InsufficientPermissionException(DAUM_PROVIDER_ID);
//        } else if (code == MISSING_PARAMETER) {
//            throw new ApiException(DAUM_PROVIDER_ID, error.getMessage());
//        } else if (code == REQUEST_TIMEOUT) {
//            throw new ServerOverloadedException(DAUM_PROVIDER_ID, error.getMessage());
//        } else if (code == RESOURCE_NOT_FOUND) {
//            throw new ResourceNotFoundException(DAUM_PROVIDER_ID, error.getMessage());
//        } else {
            throw new UncategorizedApiException(DAUM_PROVIDER_ID, error.getMessage(), null);
//        }


    }
    private String readResponseJson(ClientHttpResponse response) throws IOException {
        String json = readFully(response.getBody());
        if (logger.isDebugEnabled()) {
            logger.debug("Error from daum: " + json);
        }
        return json;
    }

    private String readFully(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
        }
        return sb.toString();
    }

}