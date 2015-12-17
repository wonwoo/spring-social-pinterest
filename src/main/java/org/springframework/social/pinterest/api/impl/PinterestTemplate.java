package org.springframework.social.pinterest.api.impl;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.pinterest.api.BoardsOperations;
import org.springframework.social.pinterest.api.PinsOperations;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.UserOperations;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestTemplate extends AbstractOAuth2ApiBinding implements Pinterest {

	private String apiKey;
	private UserOperations userOperations;
	private BoardsOperations boardsOperations;
	private PinsOperations pinsOperations;

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
		userOperations = new UserTemplate(this, isAuthorized());
		boardsOperations = new BoardsTemplate(this, isAuthorized());
		pinsOperations = new PinsTemplate(this, isAuthorized());
	}

	public String getBaseUrl() {
		return "https://api.pinterest.com/v1/";
	}

	@Override
	public UserOperations userOperations() {
		return this.userOperations;
	}

	@Override
	public BoardsOperations boardsOperations() {
		return this.boardsOperations;
	}

	@Override
	public PinsOperations pinsOperations() {
		return this.pinsOperations;
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
	public void delete(URI uri) {
		getRestTemplate().delete(uri);
	}

}
