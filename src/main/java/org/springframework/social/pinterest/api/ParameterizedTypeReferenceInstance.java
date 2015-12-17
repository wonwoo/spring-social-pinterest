package org.springframework.social.pinterest.api;

import org.springframework.core.ParameterizedTypeReference;

public class ParameterizedTypeReferenceInstance<T> extends ParameterizedTypeReference<Data<T>> {

	public ParameterizedTypeReferenceInstance() {
		super();
	}
}
