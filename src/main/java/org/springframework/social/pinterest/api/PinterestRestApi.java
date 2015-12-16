package org.springframework.social.pinterest.api;

import java.net.URI;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public interface PinterestRestApi {

	<T> ResponseEntity<T> getExchange(String url, ParameterizedTypeReference<T> responseType);

	<T> ResponseEntity<T> getExchange(String url, ParameterizedTypeReference<T> responseType, Object... uriVariables);

	<T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, MultiValueMap<String, Object> parameters);

	<T> ResponseEntity<T> postExchange(String url, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, MultiValueMap<String, Object> parameters);

	<T> ResponseEntity<T> patchExchange(String url, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, Map<String, Object> parameters);

	<T> ResponseEntity<T> getExchange(URI uri, ParameterizedTypeReference<T> responseType);

	void delete(String url, Object... urlVariables);

}