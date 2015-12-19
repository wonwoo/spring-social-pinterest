package org.springframework.social.pinterest.api.impl;

import static org.springframework.social.pinterest.api.Const.*;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.Pins;
import org.springframework.social.pinterest.api.PinsData;
import org.springframework.social.pinterest.api.PinsOperations;
import org.springframework.social.pinterest.api.PinterestRestApi;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

public class PinsTemplate extends AbstractPinterestOperations implements PinsOperations {

	private String prefix = "pins/";
	private PinterestRestApi pinterestRestApi;

	public PinsTemplate(PinterestRestApi pinterestRestApi, boolean authorized) {
		super(authorized);
		this.pinterestRestApi = pinterestRestApi;
	}

	@Override
	public Data<Pins> create(PinsData pinsData) {
		return create(pinsData, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<Pins> create(PinsData pinsData, String fields) {
		requireAuthorization();
		requiredParameters(fields);
		String url = getBaseUrl() + prefix + "?fields={fields}";
		URI expanded = new UriTemplate(url).expand(fields);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
				pinsData.toRequestParameters());
		return pinterestRestApi.postExchange(expanded, requestEntity, new ParameterizedTypeReference<Data<Pins>>() {
		}).getBody();

	}

	@Override
	public void delete(String pin) {
		requireAuthorization();
		requiredParameters(pin);
		String url = getBaseUrl() + prefix + "{pin}/";
		URI expanded = new UriTemplate(url).expand(pin);
		pinterestRestApi.delete(expanded);
	}

	@Override
	public Data<Pins> patch(String pin, PinsData pinsData, String fields) {
		requireAuthorization();
		requiredParameters(pin, fields);
		String url = getBaseUrl() + prefix + "{pin}/?fields={fields}";
		URI expanded = new UriTemplate(url).expand(pin, fields);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
				pinsData.toRequestParameters());
		return pinterestRestApi.patchExchange(expanded, requestEntity, new ParameterizedTypeReference<Data<Pins>>() {
		}).getBody();
	}

	@Override
	public Data<Pins> patch(String pin, PinsData pinsData) {
		return patch(pin, pinsData, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<Pins> get(String pin, String fields) {
		requireAuthorization();
		requiredParameters(pin, fields);
		String url = getBaseUrl() + prefix + "{pin}?fields={fields}";
		URI expanded = new UriTemplate(url).expand(pin, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<Pins>>() {
		}).getBody();
	}

	@Override
	public Data<Pins> get(String pin) {
		return get(pin, DEFAULT_PINS_FIELDS);
	}
}
