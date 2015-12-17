package org.springframework.social.pinterest.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.social.pinterest.api.*;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return pinterestRestApi.postExchange(expanded, requestEntity, new ParameterizedTypeReferenceInstance<Boards>())
				.getBody();
	}

	@Override
	public Data<Boards> create(String name, String description) {
		return create(name, description, "counts,created_at,creator,description,id,image,name,privacy,reason,url");
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
		return pinterestRestApi.patchExchange(expanded, requestEntity, new ParameterizedTypeReferenceInstance<Boards>())
				.getBody();
	}

	@Override
	public Data<Boards> getBoard(String board) {
		return getBoard(board, "counts,created_at,creator,description,id,image,name,privacy,reason,url");
	}

	@Override
	public Data<Boards> getBoard(String board, String fields) {
		requiredParameters(board, fields);
		String url = getBaseUrl() + prefix + "{board}/?fields={fields}";
		URI expanded = new UriTemplate(url).expand(board, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReferenceInstance<Boards>()).getBody();
	}

	@Override
	public Data<List<BoardPin>> getPin(String board) {
		return getPin(board,
				"attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url");
	}

	@Override
	public Data<List<BoardPin>> getPin(String board, String fields) {
		return getPin(board, 25, fields);
	}

	public Data<List<BoardPin>> getPin(String board, Integer limit, String fields) {
		requiredParameters(board, limit, fields);
		String url = getBaseUrl() + prefix + "{board}/pins/?fields={fields}&limit={limit}";
		URI expanded = new UriTemplate(url).expand(board, fields, limit);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReferenceInstance<List<BoardPin>>())
				.getBody();
	}

	@Override
	public Data<List<BoardPin>> getPinNext(String next) {
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReferenceInstance<List<BoardPin>>())
				.getBody();
	}

	@Override
	public Data<List<BoardPin>> getPinCursor(String board, String cursor, Integer limit) {
		return getPinCursor(board, cursor, limit,
				"attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url");
	}

	@Override
	public Data<List<BoardPin>> getPinCursor(String board, String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(board, cursor, limit, fields);
		String url = getBaseUrl() + prefix + "{board}/pins/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(board, cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReferenceInstance<List<BoardPin>>())
				.getBody();
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
