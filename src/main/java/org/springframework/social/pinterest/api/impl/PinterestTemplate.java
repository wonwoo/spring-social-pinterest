package org.springframework.social.pinterest.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.UserOperations;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestTemplate extends AbstractOAuth2ApiBinding implements Pinterest {

    private String apiKey;
    private UserOperations userOperation;


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
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }
    private void initSubApis() {
        userOperation = new UserTemplate(this, getRestTemplate(), isAuthorized());
    }

    public String getBaseUrl() {
        return "https://api.pinterest.com/v1/";
    }

    @Override
    public UserOperations userOperation() {
        return this.userOperation;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new PinterestErrorHandler());
    }

    public <T> T fetchObject(String url, Class<T> type) {
        return getRestTemplate().getForObject(URIBuilder.fromUri(getBaseUrl() + url).build(), type);
    }

    public <T> T fetchObject(URI uri, Class<T> type, Object... urlVariables) {
        return fetchObject(uri.toString(), type, urlVariables);
    }

    public <T> T fetchObject(String url, Class<T> type, Object... urlVariables) {
        return getRestTemplate().getForObject(getBaseUrl() + url, type, urlVariables);
    }

    @Override
    public <T> T fetchObject(String url, Class<T> type, Map<String, ?> urlVariables) {
        return getRestTemplate().getForObject(getBaseUrl() + url, type, urlVariables);
    }

    public <T> T post(String url, Object request, Class<T> type, Object... urlVariables) {
        return getRestTemplate().postForObject(getBaseUrl() + url, request, type, urlVariables);
    }

    public <T> T post(String url, Object request, Class<T> type) {
        return getRestTemplate().postForObject(getBaseUrl() + url, request, type);
    }

    @Override
    public <T> ResponseEntity<T> getExchange(String url, ParameterizedTypeReference<T> responseType) {
        return getExchange(url, null, responseType, null);
    }

    @Override
    public <T> ResponseEntity<T> getExchange(String url, ParameterizedTypeReference<T> responseType, Object... uriVariables) {
        return getExchange(url, null, responseType, uriVariables);
    }

    @Override
    public <T> ResponseEntity<T> getExchange(String url, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) {
        return getRestTemplate().exchange(getBaseUrl() + url, HttpMethod.GET, requestEntity, responseType,uriVariables);
    }
}
