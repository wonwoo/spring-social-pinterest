package org.springframework.social.pinterest.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.Map;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public interface PinterestRestApi {

    <T> T fetchObject(String url, Class<T> type);

    <T> T fetchObject(URI uri, Class<T> type, Object... urlVariables);

    <T> T fetchObject(String url, Class<T> type, Object... urlVariables);

    <T> T fetchObject(String url, Class<T> type, Map<String, ?> urlVariables);

    <T> T post(String url, Object request, Class<T> responseType, Object... urlVariables);

    <T> T post(String url, Object request, Class<T> type);

    <T> ResponseEntity getExchange(String url, ParameterizedTypeReference<T> responseType);


    <T> ResponseEntity<T> getExchange(String url,
                                      ParameterizedTypeReference<T> responseType, Object... uriVariables);


    <T> ResponseEntity<T> getExchange(String url,HttpEntity<?> requestEntity,
                                      ParameterizedTypeReference<T> responseType, Object... uriVariables);
}