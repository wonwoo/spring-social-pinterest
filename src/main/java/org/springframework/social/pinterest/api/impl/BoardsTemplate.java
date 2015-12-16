package org.springframework.social.pinterest.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.social.pinterest.api.BoardPin;
import org.springframework.social.pinterest.api.Boards;
import org.springframework.social.pinterest.api.BoardsOperations;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.PinterestRestApi;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class BoardsTemplate extends AbstractPinterestOperations implements BoardsOperations {

	private PinterestRestApi pinterestRestApi;
	private RestTemplate restTemplate;
	private String prefix = "boards/";

	public BoardsTemplate(boolean isAuthorized) {
		super(isAuthorized);
	}

	public BoardsTemplate(PinterestRestApi pinterestRestApi, RestTemplate restTemplate, boolean authorized) {
		super(authorized);
		this.pinterestRestApi = pinterestRestApi;
		this.restTemplate = restTemplate;
	}

	@Override
	public Data<Boards> create(String name, String description, String fields) {
		requireAuthorization();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name == null ? "" : name);
		parameters.put("description", description == null ? "" : description);
		HttpEntity<?> requestEntity = new HttpEntity<Map<String, Object>>(parameters);
		MultiValueMap<String, Object> getParameters = new LinkedMultiValueMap<String, Object>();
		getParameters.add("fields", fields);
		return pinterestRestApi.postExchange(prefix, requestEntity, new ParameterizedTypeReference<Data<Boards>>() {
		}, getParameters).getBody();
	}

	@Override
	public Data<Boards> create(String name, String description) {
		return create(name, description, "counts,created_at,creator,description,id,image,name,privacy,reason,url");
	}

	@Override
	public Data<Boards> create(String name) {
		return create(name, null);
	}

	@Override
	public void delete(String board) {
		requireAuthorization();
		pinterestRestApi.delete(prefix + "{board}/", board);
	}

	@Override
	public Data<Boards> patch(String board, String name, String description, String fields) {
		requireAuthorization();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name == null ? "" : name);
		parameters.put("description", description == null ? "" : description);
		HttpEntity<?> requestEntity = new HttpEntity<Map<String, Object>>(parameters);
		Map<String, Object> getParameters = new HashMap<String, Object>();
		getParameters.put("fields", fields);
		getParameters.put("board", board);
		return pinterestRestApi
				.patchExchange(prefix + "{board}/", requestEntity, new ParameterizedTypeReference<Data<Boards>>() {
				}, getParameters).getBody();
	}

	@Override
	public Data<Boards> get(String board) {
		return get(board, "counts,created_at,creator,description,id,image,name,privacy,reason,url");
	}

	@Override
	public Data<Boards> get(String board, String fields) {
		return pinterestRestApi
				.getExchange(prefix + "{board}/?fields={fields}", new ParameterizedTypeReference<Data<Boards>>() {
				}, board, fields).getBody();
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
		return pinterestRestApi.getExchange(prefix + "{board}/pins/?fields={fields}&limit={limit}",
				new ParameterizedTypeReference<Data<List<BoardPin>>>() {
				}, board, fields, limit).getBody();
	}

	@Override
	public Data<List<BoardPin>> getPinNext(String next) {
		return pinterestRestApi.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<BoardPin>>>() {
		}).getBody();
	}

	@Override
	public Data<List<BoardPin>> getPinCursor(String board, String cursor, Integer limit) {
		return getPinCursor(board, cursor, limit,
				"attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url");
	}

	@Override
	public Data<List<BoardPin>> getPinCursor(String board, String cursor, Integer limit, String fields) {
		return pinterestRestApi.getExchange(prefix + "{board}/pins/?cursor={cursor}&limit={limit}&fields={fields}",
				new ParameterizedTypeReference<Data<List<BoardPin>>>() {
				}, board, cursor, limit, fields).getBody();
	}

}
