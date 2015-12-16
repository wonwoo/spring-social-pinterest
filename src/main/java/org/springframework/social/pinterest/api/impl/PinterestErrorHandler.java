package org.springframework.social.pinterest.api.impl;

/**
 * Created by wonwoo on 15. 12. 15..
 */
import static org.springframework.social.pinterest.api.PinterestErrors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.ApiException;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.ServerException;
import org.springframework.social.ServerOverloadedException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.pinterest.api.PinterestError;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PinterestErrorHandler extends DefaultResponseErrorHandler {

	private static final String PINTEREST_PROVIDER_ID = "pinterest";

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		String errorString = readResponseJson(response);
		ObjectMapper mapper = new ObjectMapper();
		PinterestError error = mapper.readValue(errorString, PinterestError.class);
		handlePinterestError(response.getStatusCode(), error);
	}

	void handlePinterestError(HttpStatus statusCode, PinterestError error) {
		int code = statusCode.value();
		if (code == SERVER_ERROR || code == SERVER_ERROR2 || code == SERVER_ERROR99) {
			throw new ServerException(PINTEREST_PROVIDER_ID, error.getMessage());
		} else if (code == TOO_MANY_REQUESTS) {
			throw new RateLimitExceededException(PINTEREST_PROVIDER_ID);
		} else if (code == AUTHORIZATION) {
			throw new NotAuthorizedException(PINTEREST_PROVIDER_ID, error.getMessage());
		} else if (code == PERMISSIONS) {
			throw new InsufficientPermissionException(PINTEREST_PROVIDER_ID);
		} else if (code == SOMETHING) {
			throw new ApiException(PINTEREST_PROVIDER_ID, error.getMessage());
		} else if (code == TIME_OUT) {
			throw new ServerOverloadedException(PINTEREST_PROVIDER_ID, error.getMessage());
		} else if (code == NOT_FOUND) {
			throw new ResourceNotFoundException(PINTEREST_PROVIDER_ID, error.getMessage());
		} else {
			throw new UncategorizedApiException(PINTEREST_PROVIDER_ID, error.getMessage(), null);
		}

	}

	private String readResponseJson(ClientHttpResponse response) throws IOException {
		String json = readFully(response.getBody());
		if (logger.isDebugEnabled()) {
			logger.debug("Error from pinterest: " + json);
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