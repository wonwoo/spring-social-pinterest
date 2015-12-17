package org.springframework.social.pinterest.api.impl;

import static org.springframework.social.pinterest.api.Const.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.social.pinterest.api.Boards;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.PinterestRestApi;
import org.springframework.social.pinterest.api.User;
import org.springframework.social.pinterest.api.UserOperations;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.util.UriTemplate;

/**
 * Created by wonwoo on 15. 12. 15..
 * 
 * @param <T>
 */
public class UserTemplate extends AbstractPinterestOperations implements UserOperations {

	private String prefix = "me/";
	private PinterestRestApi pinterestRestApi;

	// private static final String

	public UserTemplate(PinterestRestApi pinterestRestApi, boolean authorized) {
		super(authorized);
		this.pinterestRestApi = pinterestRestApi;
	}

	@Override
	public Data<User> getMe(String fields) {
		requireAuthorization();
		requiredParameters(fields);
		String url = getBaseUrl() + prefix + "?fields={fields}";
		URI expanded = new UriTemplate(url).expand(fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<User>>() {
		}).getBody();
	}

	@Override
	public Data<User> getMe() {
		return getMe("id,image,username,first_name,last_name,bio,created_at,counts,account_type,url");
	}

	@Override
	public Data<List<Boards>> getBoards(String fields) {
		requireAuthorization();
		requiredParameters(fields);
		String url = getBaseUrl() + prefix + "boards?fields={fields}";
		URI expanded = new UriTemplate(url).expand(fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Boards>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Boards>> getBoards() {
		return getBoards(DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<User> getUserSearch(String user) {
		return getUserSearch(user, DEFAULT_USER_FIELDS);
	}

	@Override
	public Data<User> getUserSearch(String user, String fields) {
		requireAuthorization();
		requiredParameters(user, fields);
		String url = getBaseUrl() + "/users/{user}/?fields={fields}";
		URI expanded = new UriTemplate(url).expand(user, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<User>>() {
		}).getBody();
	}

	@Override
	public Data<List<Boards>> getSuggested(String pin, Integer count, String fields) {
		requireAuthorization();
		requiredParameters(pin, count, fields);

		String url = getBaseUrl() + prefix + "/boards/suggested/?pin={pin}&count={count}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(pin, count, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Boards>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Boards>> getSuggested(String pin, Integer count) {
		return getSuggested(pin, count, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<List<Boards>> getSuggested(String pin) {
		return getSuggested(pin, 1);
	}

	@Override
	public Data<List<User>> getFollowers(Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(limit, fields);
		String url = getBaseUrl() + prefix + "followers/?limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<User>>>() {
		}).getBody();
	}

	@Override
	public Data<List<User>> getFollowers(Integer limit) {
		return getFollowers(limit, DEFAULT_USER_FIELDS);
	}

	@Override
	public Data<List<User>> getFollowers() {
		return getFollowers(DEFAULT_LIMIT);
	}

	@Override
	public Data<List<User>> getFollowersNext(String next) {
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<User>>>() {
				}).getBody();

	}

	@Override
	public Data<List<User>> getFollowersCursor(String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(cursor, limit, fields);
		String url = getBaseUrl() + prefix + "followers/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<User>>>() {
		}).getBody();
	}

	@Override
	public Data<List<User>> getFollowersCursor(String cursor, Integer limit) {
		return getFollowersCursor(cursor, limit, DEFAULT_USER_FIELDS);
	}

	@Override
	public Data<List<Boards>> getFollowersBoards(Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(limit, fields);
		String url = getBaseUrl() + prefix + "following/boards/?limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Boards>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Boards>> getFollowersBoards(Integer limit) {
		return getFollowersBoards(limit, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<List<Boards>> getFollowersBoards() {
		return getFollowersBoards(DEFAULT_LIMIT);
	}

	@Override
	public Data<List<Boards>> getFollowersBoardsNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Boards>>>() {
				}).getBody();
	}

	@Override
	public Data<List<Boards>> getFollowersBoardsCursor(String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(cursor, limit, fields);
		String url = getBaseUrl() + prefix + "following/boards/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Boards>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Boards>> getFollowersBoardsCursor(String cursor, Integer limit) {
		return getFollowersBoardsCursor(cursor, limit, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<String> followingBoards(String board) {
		requireAuthorization();
		requiredParameters(board);
		String url = getBaseUrl() + prefix + "following/boards/";
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("board", board);
		HttpEntity<?> requestEntity = new HttpEntity<Map<String, Object>>(body);
		return pinterestRestApi.postExchange(URIBuilder.fromUri(url).build(), requestEntity,
				new ParameterizedTypeReference<Data<String>>() {
				}).getBody();
	}

	@Override
	public void unfollowingBoards(String board) {
		requireAuthorization();
		requiredParameters(board);
		String url = getBaseUrl() + prefix + "following/boards/{board}/";
		URI expanded = new UriTemplate(url).expand(board);
		pinterestRestApi.delete(expanded);
	}

}
