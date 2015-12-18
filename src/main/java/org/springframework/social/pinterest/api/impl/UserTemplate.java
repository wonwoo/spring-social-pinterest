package org.springframework.social.pinterest.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.social.pinterest.api.*;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.Assert;
import org.springframework.web.util.UriTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.social.pinterest.api.Const.*;

/**
 * Created by wonwoo on 15. 12. 15..
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

	// public Data<T> getResult(URI uri, ){
	//
	// }

	@Override
	public Data<User> getMe() {
		return getMe(DEFAULT_USER_FIELDS);
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

	@Override
	public Data<List<Interests>> getfollowingInterests(Integer limit) {
		requireAuthorization();
		requiredParameters(limit);
		String url = getBaseUrl() + prefix + "following/interests/?limit={limit}";
		URI expanded = new UriTemplate(url).expand(limit);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Interests>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Interests>> getfollowingInterestsNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Interests>>>() {
				}).getBody();
	}

	@Override
	public Data<List<Interests>> getfollowingInterestsCursor(String cursor, Integer limit) {
		requireAuthorization();
		requiredParameters(cursor, limit);
		String url = getBaseUrl() + prefix + "following/interests/?cursor={cursor}&limit={limit}";
		URI expanded = new UriTemplate(url).expand(cursor, limit);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Interests>>>() {
		}).getBody();
	}

	@Override
	public Data<List<User>> getfollowingUsers(Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(limit, fields);
		String url = getBaseUrl() + prefix + "following/users/?limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<User>>>() {
		}).getBody();
	}

	@Override
	public Data<List<User>> getfollowingUsers(Integer limit) {
		return getfollowingUsers(limit, DEFAULT_USER_FIELDS);
	}

	@Override
	public Data<List<User>> getfollowingUsersNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<User>>>() {
				}).getBody();
	}

	@Override
	public Data<List<User>> getfollowingUsersCursor(String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(cursor, limit, fields);
		String url = getBaseUrl() + prefix + "following/users/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<User>>>() {
		}).getBody();
	}

	@Override
	public Data<List<User>> getfollowingUsersCursor(String cursor, Integer limit) {
		return getfollowingUsersCursor(cursor, limit, DEFAULT_USER_FIELDS);
	}

	@Override
	public Data<String> followingUsers(String user) {
		requireAuthorization();
		requiredParameters(user);
		String url = getBaseUrl() + prefix + "following/users/";
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("user", user);
		HttpEntity<?> requestEntity = new HttpEntity<Map<String, Object>>(body);
		return pinterestRestApi.postExchange(URIBuilder.fromUri(url).build(), requestEntity,
				new ParameterizedTypeReference<Data<String>>() {
				}).getBody();
	}

	@Override
	public void unfollowingUsers(String user) {
		requireAuthorization();
		requiredParameters(user);
		String url = getBaseUrl() + prefix + "following/users/{user}/";
		URI expanded = new UriTemplate(url).expand(user);
		pinterestRestApi.delete(expanded);
	}

	@Override
	public Data<List<Pins>> getLike(Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(limit, fields);
		String url = getBaseUrl() + prefix + "likes/?limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getLike(Integer limit) {
		return getLike(limit, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Pins>> getLikeNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Pins>>>() {
				}).getBody();
	}

	@Override
	public Data<List<Pins>> getLikeCursor(String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(cursor, limit, fields);
		String url = getBaseUrl() + prefix + "likes/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getLikeCursor(String cursor, Integer limit) {
		return getLikeCursor(cursor, limit, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Pins>> getPins(Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(limit, fields);
		String url = getBaseUrl() + prefix + "pins/?limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getPins(Integer limit) {
		return getPins(limit, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Pins>> getPinsNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Pins>>>() {
				}).getBody();
	}

	@Override
	public Data<List<Pins>> getPinsCursor(String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(cursor, limit, fields);
		String url = getBaseUrl() + prefix + "pins/?cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getPinsCursor(String cursor, Integer limit) {
		return getPinsCursor(cursor, limit, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Boards>> getSearchBoards(String query, String fields) {
		requireAuthorization();
		requiredParameters(query, fields);
		String url = getBaseUrl() + prefix + "search/boards/?query={query}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(query, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Boards>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Boards>> getSearchBoards(String query) {
		return getSearchBoards(query, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<List<Boards>> getSearchBoardsNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Boards>>>() {
				}).getBody();
	}

	@Override
	public Data<List<Boards>> getSearchBoardsCursor(String query, String cursor) {
		return getSearchBoardsCursor(query, cursor, DEFAULT_BOARDS_FIELDS);
	}

	@Override
	public Data<List<Boards>> getSearchBoardsCursor(String query, String cursor, String fields) {
		requireAuthorization();
		requiredParameters(query, cursor, fields);
		String url = getBaseUrl() + prefix + "search/boards/?query={query}&cursor={cursor}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(query, cursor, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Boards>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getSearchPins(String query, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(query, limit, fields);
		String url = getBaseUrl() + prefix + "search/pins/?query={query}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(query, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getSearchPins(String query, Integer limit) {
		return getSearchPins(query, limit, DEFAULT_PINS_FIELDS);
	}

	@Override
	public Data<List<Pins>> getSearchPinsNext(String next) {
		requireAuthorization();
		requiredParameters(next);
		return pinterestRestApi
				.getExchange(URIBuilder.fromUri(next).build(), new ParameterizedTypeReference<Data<List<Pins>>>() {
				}).getBody();
	}

	@Override
	public Data<List<Pins>> getSearchPinsCursor(String query, String cursor, Integer limit, String fields) {
		requireAuthorization();
		requiredParameters(query, cursor, limit, fields);
		String url = getBaseUrl() + prefix + "search/pins/?query={query}&cursor={cursor}&limit={limit}&fields={fields}";
		URI expanded = new UriTemplate(url).expand(query, cursor, limit, fields);
		return pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<List<Pins>>>() {
		}).getBody();
	}

	@Override
	public Data<List<Pins>> getSearchPinsCursor(String query, String cursor, Integer limit) {
		return getSearchPinsCursor(query, cursor, limit, DEFAULT_PINS_FIELDS);
	}

}
