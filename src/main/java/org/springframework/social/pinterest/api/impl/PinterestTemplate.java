package org.springframework.social.pinterest.api.impl;

import java.net.URI;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.pinterest.api.BoardsOperations;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.UserOperations;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestTemplate extends AbstractOAuth2ApiBinding implements Pinterest {

	private String apiKey;
	private UserOperations userOperation;
	private BoardsOperations boardsOperations;

	public PinterestTemplate(String apiKey) {
		this.apiKey = apiKey;
		initialize();
	}

	public PinterestTemplate(String accessToken, String apiKey) {
		super(accessToken);
		this.apiKey = apiKey;
		initialize();
	}

	private void initialize() {
		ClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(httpRequestFactory));
		initSubApis();
	}

	private void initSubApis() {
		userOperation = new UserTemplate(this, getRestTemplate(), isAuthorized());
		boardsOperations = new BoardsTemplate(this, getRestTemplate(), isAuthorized());
	}

	public String getBaseUrl() {
		return "https://api.pinterest.com/v1/";
	}

	@Override
	public UserOperations userOperation() {
		return this.userOperation;
	}

	@Override
	public BoardsOperations boardsOperations() {
		return this.boardsOperations;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new PinterestErrorHandler());
	}

	@Override
	public <T> ResponseEntity<T> getExchange(URI uri, ParameterizedTypeReference<T> responseType) {
		return getRestTemplate().exchange(uri, HttpMethod.GET, null, responseType);
	}

	@Override
	public <T> ResponseEntity<T> postExchange(URI uri, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType) {
		return getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity, responseType);
	}

	@Override
	public <T> ResponseEntity<T> patchExchange(URI uri, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType) {
		return getRestTemplate().exchange(uri, HttpMethod.PATCH, requestEntity, responseType);
	}

	@Override
	public void delete(String url, Object... urlVariables) {
		getRestTemplate().delete(getBaseUrl() + url, urlVariables);
	}
}
