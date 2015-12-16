package org.springframework.social.pinterest.api.impl;

import java.net.URI;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

public class PinterestURIBuilder {
	private URIBuilder uriBuilder;

	private String uri;

	private MultiValueMap<String, Object> parameters;

	public PinterestURIBuilder(String uri) {
		uriBuilder = URIBuilder.fromUri(uri);
		parameters = new LinkedMultiValueMap<String, Object>();
		this.uri = uri;
	}

	public PinterestURIBuilder add(String name, Object value) {
		parameters.add(name, value);
		convert(name, value);
		return this;
	}

	private void convert(String name, Object value) {
		if (ObjectUtils.isEmpty(value)) {
			return;
		}
		if (value instanceof String) {
			uriBuilder.queryParam(name, (String) value);
		}
		if (value instanceof Number) {
			uriBuilder.queryParam(name, ((Number) value).toString());
		}
	}
	
//	public PinterestURIBuilder addAll(Object... parameters) {
//		for (Object obj : parameters) {
//			convert(name, this.parameters.getFirst(name));
//		}
//		return this;
//	}

	public PinterestURIBuilder addAll(MultiValueMap<String, Object> parameters) {
		this.parameters.putAll(parameters);
		for (String name : this.parameters.keySet()) {
			convert(name, this.parameters.getFirst(name));
		}
		return this;
	}

	public String getUri() {
		return uri;
	}

	public URI build() {
		return uriBuilder.build();
	}
}
