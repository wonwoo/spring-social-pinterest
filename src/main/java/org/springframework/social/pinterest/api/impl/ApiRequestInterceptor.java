package org.springframework.social.pinterest.api.impl;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator;

public class ApiRequestInterceptor implements ClientHttpRequestInterceptor {

	private String fields;
	
	public ApiRequestInterceptor(String fields) {
		this.fields = fields;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpRequestDecorator httpRequestDecorator = new HttpRequestDecorator(request);
		httpRequestDecorator.addParameter("fields", fields);
		return execution.execute(request, body);
	}

}
