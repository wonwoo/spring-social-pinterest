package org.springframework.social.pinterest.api.impl;

import static org.springframework.social.pinterest.api.Const.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.social.pinterest.api.Boards;
import org.springframework.social.pinterest.api.BoardsOperations;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.Pins;
import org.springframework.social.pinterest.api.PinterestRestApi;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.util.UriTemplate;

public class BoardsTemplate extends AbstractPinterestOperations implements BoardsOperations {

	private PinterestRestApi pinterestRestApi;
	private String prefix = "boards/";

	public BoardsTemplate(boolean isAuthorized) {
		super(isAuthorized);
	}

	public BoardsTemplate(PinterestRestApi pinterestRestApi, boolean authorized) {
		super(authorized);
		this.pinterestRestApi = pinterestRestApi;
	}

	@Override
	public Data<Boards> create(String name, String description, String fields) {
		requireAuthorization();
		requiredParameters(name, fields);
		String url = getBaseUrl() + prefix + "?fields={fields}";
		URI expanded = new UriTemplate(url).expand(fields);
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("name", name);
		body.put("description", description == null ? "" : description);
		HttpEntity<?> requestEntity = new HttpEntity<Map<String, Object>>(body);
		return pinterestRestApi.postExchange(expanded, requestEntity, new ParameterizedTypeReference<Data<Boards>>() {
		}).getBody();

	}

	@Override
	public Data<Boards> create(String name, String description) {
		return create(name, description, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<Boards> create(String name) {
		return create(name, "");
	}

	@Override
	public Data<Boards> patch(String board, String name, String description, String fields) {
		requireAuthorization();
		requiredParameters(board, name, fields);
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("name", name);
		body.put("description", description == null ? "" : description);
		HttpEntity<?> requestEntity = new HttpEntity<Map<String, Object>>(body);
		String url = getBaseUrl() + prefix + "{board}/?fields={fields}";
		URI expanded = new UriTemplate(url).expand(board, fields);
		return pinterestRestApi.patchExchange(expanded, requestEntity, new ParameterizedTypeReference<Data<Boards>>() {
		}).getBody();
	}

	@Override
	public Data<Boards> getBoard(String board) {
		return getBoard(board, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<Boards> getBoard(String board, String fields) {
		requiredParameters(board, fields);
		String url = getBaseUrl() + prefix + "{board}/?fields={fields}";
		URI expanded = new UriTemplate(url).expand(board, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<Boards>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getPin(String board) {
		return getPin(board, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Pins>> getPin(String board, String fields) {
		return getPin(board, DEFAULT_LIMIT, fields);
	}

	public Data<List<Pins>> getPin(String board, Integer limit, String fields) {
		requiredParameters(board, limit, fields);
		String url = getBaseUrl() + prefix + "{board}/pins/?fields={fields}&limit={limit}";
		URI expanded = new UriTemplate(url).expand(board, fields, limit);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getPinNext(String next) {
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Pins>>>() {
				}).getBody();

	}

	@Override
	public Data<List<Pins>> getPinCursor(String board, String cursor, Integer limit) {
		return getPinCursor(board, cursor, limit, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Pins>> getPinCursor(String board, String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(board, cursor, limit, fields);
		String url = getBaseUrl() + prefix + "{board}/pins/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(board, cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();

	}

	@Override
	public void delete(String board) {
		requireAuthorization();
		requiredParameters(board);
		String url = getBaseUrl() + prefix + "{board}/";
		URI expanded = new UriTemplate(url).expand(board);
		pinterestRestApi.delete(expanded);
	}

}
