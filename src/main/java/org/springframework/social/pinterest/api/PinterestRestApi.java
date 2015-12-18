package org.springframework.social.pinterest.api;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public interface PinterestRestApi {

	<T> ResponseEntity<T> getExchange(URI uri, ParameterizedTypeReference<T> responseType);

	<T> ResponseEntity<T> postExchange(URI uri, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType);

	<T> ResponseEntity<T> patchExchange(URI uri, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType);

	void delete(URI uri);

}