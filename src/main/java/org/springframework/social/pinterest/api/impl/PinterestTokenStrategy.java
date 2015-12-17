package org.springframework.social.pinterest.api.impl;

import org.springframework.http.client.ClientHttpRequestInterceptor;

public enum PinterestTokenStrategy {

	API_KEY {
		public ClientHttpRequestInterceptor interceptor(String fields) {
			return new ApiRequestInterceptor();
		}
	};
	abstract ClientHttpRequestInterceptor interceptor(String fields);

}
