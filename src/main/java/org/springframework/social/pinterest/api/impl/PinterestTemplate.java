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

		// List<HttpMessageConverter<?>> converters =
		// restTemplate.getMessageConverters();
		// for (HttpMessageConverter<?> converter : converters) {
		// if (converter instanceof MappingJackson2HttpMessageConverter) {
		// MappingJackson2HttpMessageConverter jsonConverter =
		// (MappingJackson2HttpMessageConverter) converter;
		// jsonConverter.setObjectMapper(new ObjectMapper());
		// jsonConverter.setSupportedMediaTypes(Arrays.asList(
		// new MediaType("application", "json",
		// MappingJackson2HttpMessageConverter.DEFAULT_CHARSET),
		// new MediaType("text", "html",
		// MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
		// }
		// }
	}

	@Override
	public <T> ResponseEntity<T> getExchange(String url, ParameterizedTypeReference<T> responseType) {
		return getRestTemplate().exchange(getBaseUrl() + url, HttpMethod.GET, null, responseType);
	}
	
	@Override
	public <T> ResponseEntity<T> getExchange(URI uri, ParameterizedTypeReference<T> responseType) {
		return getRestTemplate().exchange(uri, HttpMethod.GET, null, responseType);
	}

	@Override
	public <T> ResponseEntity<T> getExchange(String url, ParameterizedTypeReference<T> responseType,
			Object... uriVariables) {
		return getRestTemplate().exchange(getBaseUrl() + url, HttpMethod.GET, null, responseType, uriVariables);
	}

	@Override
	public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, MultiValueMap<String, Object> parameters) {
		URI uri = new PinterestURIBuilder(getBaseUrl() + url).addAll(parameters).build();
		ResponseEntity<T> responseEntity = getRestTemplate().exchange(uri, method, requestEntity, responseType);
		return responseEntity;
	}

	public <T> ResponseEntity<T> exchange(URI uri, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, MultiValueMap<String, Object> parameters) {
		ResponseEntity<T> responseEntity = getRestTemplate().exchange(uri, method, requestEntity, responseType);
		return responseEntity;
	}

	@Override
	public <T> ResponseEntity<T> postExchange(String url, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, MultiValueMap<String, Object> parameters) {
		return exchange(url, HttpMethod.POST, requestEntity, responseType, parameters);
	}

	@Override
	public <T> ResponseEntity<T> patchExchange(String url, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, Map<String, Object> parameters) {
		return getRestTemplate().exchange(getBaseUrl() + url, HttpMethod.PATCH, requestEntity, responseType,
				parameters);
	}

	@Override
	public void delete(String url, Object... urlVariables) {
		getRestTemplate().delete(getBaseUrl() + url, urlVariables);
		// public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
		// HttpEntity<?> requestEntity, Class<T> responseType, Object...
		// uriVariables)
		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_XML);
		// MultiValueMap<String, String> headers = new
		// LinkedMultiValueMap<String,String>();
		// headers.add("content_type", MediaType.TEXT_HTML_VALUE);
		// HttpEntity<MultiValueMap<String, String>> httpEntity = new
		// HttpEntity<>(headers);
		// ResponseEntity<String> a = getRestTemplate().exchange(getBaseUrl() +
		// url, HttpMethod.DELETE, httpEntity, String.class,
		// urlVariables);
		// System.out.println(a);
		// System.out.println(a.getBody());
		// System.out.println(a.getHeaders());
		// System.out.println(a.getStatusCode());

	}
}
