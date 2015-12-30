package org.springframework.social.pinterest.api;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.pinterest.api.impl.PinterestTemplate;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class UserTest {

	// insert token
	String token = "Aak6Ne1s--fUgpR3dK1eqzJHYQFNFCSQjZih94RCtmEPYoBGWgAAAAA";

	Pinterest pinterest = null;

	@Before
	public void before() {
		pinterest = new PinterestTemplate(token);
	}

	@Test
	public void getMe() {
		final Data<User> me = pinterest.userOperations().getMe("id,image(small)");
		System.out.println(me.getData().getBio());
		System.out.println(me.getData().getId());
		System.out.println(me.getData().getImage().getSmall());
		System.out.println(me);
	}

	@Test
	public void getBoards() {
		final Data<List<Boards>> boards = pinterest.userOperations().getBoards();
		for (Boards board : boards.getData()) {
			System.out.println(board.getCounts().getCollaborators());
			System.out.println(board);
		}
	}

	@Test
	public void getUserSerach() {
		final Data<User> user = pinterest.userOperations().getUserSearch("aoruqjfu");
		System.out.println(user);
	}

	@Test
	public void getSuggested() {
		final Data<List<Boards>> user = pinterest.userOperations().getSuggested("174303585486549445");
		System.out.println(user);
	}

	@Test
	public void getFollowers() {
		final Data<List<User>> user = pinterest.userOperations().getFollowers();
		System.out.println(user);
		System.out.println(user.getPage().getCursor());
		System.out.println(user.getPage().getNext());
	}

	@Test
	public void getFollowersCursor() {
		final Data<List<User>> user = pinterest.userOperations().getFollowersCursor(
				"Pz9MVEZmUlE9PXxlYjcxNGYyOTIzMWEzNWRhNThlYzliNjQwYzM5NjE0YjQ1MDMwZDU4Nzk0MmQ0OTQxZTY3ZGU5ZDEyNjM4YzFj",
				1);
		System.out.println(user);
	}

	@Test
	public void getFollowersNext() {
		final Data<List<User>> user = pinterest.userOperations().getFollowersNext(
				"https://api.pinterest.com/v1/me/followers/?cursor=Pz9MVEZmUlE9PXxlYjcxNGYyOTIzMWEzNWRhNThlYzliNjQwYzM5NjE0YjQ1MDMwZDU4Nzk0MmQ0OTQxZTY3ZGU5ZDEyNjM4YzFj&fields=account_type%2Cbio%2Ccounts%2Ccreated_at%2Cfirst_name%2Cid%2Cimage%2Clast_name%2Curl%2Cusername&limit=1");
		System.out.println(user);
	}

	@Test
	public void getFollowersBoards() {
		final Data<List<Boards>> boards = pinterest.userOperations().getFollowersBoards(1);
		System.out.println(boards);
	}

	@Test
	public void followingBoards() {
		final Data<String> boards = pinterest.userOperations().followingBoards("522065850493445232");
		System.out.println(boards);
	}

	@Test
	public void unfollowingBoards() {
		pinterest.userOperations().unfollowingBoards("522065850493445232");
	}

	@Test
	public void getfollowingInterests() {
		Data<List<Interests>> listData = pinterest.userOperations().getfollowingInterests(3);
		System.out.println(listData);
	}

	@Test
	public void getfollowingInterestsNext() {
		Data<List<Interests>> listData = pinterest.userOperations().getfollowingInterestsNext(
				"https://api.pinterest.com/v1/me/following/interests/?cursor=Pz8wMDA5NmMzY2RjODc0OTMxNDExYmVmYTRhOWUwMDhjMnwxYjg1MDhhODdiMjVlY2M2OGQ1ZGMzZDI5NmJkOTQ3MTE4NDZkMzVlNzNmZGQ3ODliMDFiMjdhNWU5YTcxM2Vh&limit=3");
		System.out.println(listData);
		;
	}

	@Test
	public void getfollowingInterestsCursor() {
		Data<List<Interests>> listData = pinterest.userOperations().getfollowingInterestsCursor(
				"Pz8wMDA5NmMzY2RjODc0OTMxNDExYmVmYTRhOWUwMDhjMnwxYjg1MDhhODdiMjVlY2M2OGQ1ZGMzZDI5NmJkOTQ3MTE4NDZkMzVlNzNmZGQ3ODliMDFiMjdhNWU5YTcxM2Vh",
				3);
		System.out.println(listData);
	}

	@Test
	public void getfollowingUsers() {
		Data<List<User>> listData = pinterest.userOperations().getfollowingUsers(2);
		System.out.println(listData);
	}

	@Test
	public void getfollowingUsersNext() {
		Data<List<User>> listData = pinterest.userOperations().getfollowingUsersNext(
				"https://api.pinterest.com/v1/me/following/users/?cursor=Pz9Nakl5TXpvMU1qSXdOalU1TVRreU1USTJOVEU0TXpJNk9USXlNek0zTURVNE5qVXdPVEF5TkRBM09GOUZ8OTQ1MmJmODk0MGUzMDE1MjJjYzA1OTQ4YmUwZTc2MTg3NjY1NDdmYzEzMmQ4ZDhkZDQxMzhhNDkwOGJhNWJlMA%3D%3D&fields=account_type%2Cbio%2Ccounts%2Ccreated_at%2Cfirst_name%2Cid%2Cimage%2Clast_name%2Curl%2Cusername&limit=2");
		System.out.println(listData);

	}

	@Test
	public void getfollowingUsersCursor() {
		Data<List<User>> listData = pinterest.userOperations().getfollowingUsersCursor(
				"Pz9Nakl5TXpvMU1qSXdOalU1TVRreU1USTJOVEU0TXpJNk9USXlNek0zTURVNE5qVXdPVEF5TkRBM09GOUZ8OTQ1MmJmODk0MGUzMDE1MjJjYzA1OTQ4YmUwZTc2MTg3NjY1NDdmYzEzMmQ4ZDhkZDQxMzhhNDkwOGJhNWJlMA==",
				2);
		System.out.println(listData);
	}

	@Test
	public void followingUsers() {
		Data<String> str = pinterest.userOperations().followingUsers("xtopherv");
		System.out.println(str);
	}

	@Test
	public void unfollowingUsers() {
		pinterest.userOperations().unfollowingUsers("xtopherv");
	}

	@Test
	public void getLike() {
		final Data<List<Pins>> like = pinterest.userOperations().getLike(10);
		System.out.println(like);

	}

	@Test
	public void getLikeNext() {
		final Data<List<Pins>> likeNext = pinterest.userOperations().getLikeNext(
				"https://api.pinterest.com/v1/me/likes/?cursor=LT4yNzE0ODI2ODM3NjUxOTQ5Nzc6MTB8OGMwZDE1NzNmZWI0MmJmZGEyYzQzZjUzNWRlMGVjNzQxYTBlMzMxYzQ2NTNkMTE1ZThhYzdhZjU5NjczNTUwOA%3D%3D&fields=attribution%2Cboard%28counts%2Ccreated_at%2Ccreator%2Cdescription%2Cid%2Cimage%2Cname%2Cprivacy%2Creason%2Curl%29%2Ccolor%2Ccounts%2Ccreated_at%2Ccreator%2Cid%2Cimage%2Clink%2Cmedia%2Cmetadata%2Cnote%2Coriginal_link%2Curl&limit=10");
		System.out.println(likeNext);
	}

	@Test
	public void getLikeCursor() {
		final Data<List<Pins>> likeCursor = pinterest.userOperations().getLikeCursor(
				"LT4yNzE0ODI2ODM3NjUxOTQ5Nzc6MTB8OGMwZDE1NzNmZWI0MmJmZGEyYzQzZjUzNWRlMGVjNzQxYTBlMzMxYzQ2NTNkMTE1ZThhYzdhZjU5NjczNTUwOA==",
				10);
		System.out.println(likeCursor);
	}

	@Test
	public void getPins() {
		final Data<List<Pins>> pins = pinterest.userOperations().getPins(10);
		System.out.println(pins);
	}

	@Test
	public void getPinsNext() {
		final Data<List<Pins>> pins = pinterest.userOperations().getPinsNext(
				"https://api.pinterest.com/v1/me/pins/?cursor=LT4xNzQzMDM0NDgwNTYxNjE1NDY6MTB8ZWU5NzU0YjUxMDVjZmNlYWZkZmIxN2ZhM2EwYjAxOTUwMmMzYjNiMWEzYjM0ODExMjg2ZGFiZDBhMzcwZjc5Yw%3D%3D&fields=attribution%2Cboard%28counts%2Ccreated_at%2Ccreator%2Cdescription%2Cid%2Cimage%2Cname%2Cprivacy%2Creason%2Curl%29%2Ccolor%2Ccounts%2Ccreated_at%2Ccreator%2Cid%2Cimage%2Clink%2Cmedia%2Cmetadata%2Cnote%2Coriginal_link%2Curl&limit=10");
		System.out.println(pins);
	}

	@Test
	public void getPinsCursor() {
		final Data<List<Pins>> pins = pinterest.userOperations().getPinsCursor(
				"LT4xNzQzMDM0NDgwNTYxNjE1NDY6MTB8ZWU5NzU0YjUxMDVjZmNlYWZkZmIxN2ZhM2EwYjAxOTUwMmMzYjNiMWEzYjM0ODExMjg2ZGFiZDBhMzcwZjc5Yw==",
				10);
		System.out.println(pins);
	}

	@Test
	public void getSearchBoards() throws UnsupportedEncodingException {
		final Data<List<Boards>> pins = pinterest.userOperations().getSearchBoards("gg1");
		System.out.println(pins);
	}

	@Test
	public void getSearchBoardsNext() {
		final Data<List<Boards>> pins = pinterest.userOperations().getSearchBoardsNext(
				"https://api.pinterest.com/v1/me/search/boards/?cursor=b28yNXxmMGVmZDA5YjA5Yjk5NDIxZjgzODZjNDRkZWEzNTRhZmIyZDRjZjE3ZWY4YmRmMWE4NmVhZGQwNDg1NTNmOTAw&query=gg1&fields=counts%2Ccreated_at%2Ccreator%2Cdescription%2Cid%2Cimage%2Cname%2Cprivacy%2Creason%2Curl");
		System.out.println(pins);
	}

	@Test
	public void getSearchBoardsCursor() {
		final Data<List<Boards>> pins = pinterest.userOperations().getSearchBoardsCursor("gg1",
				"b28yNXxmMGVmZDA5YjA5Yjk5NDIxZjgzODZjNDRkZWEzNTRhZmIyZDRjZjE3ZWY4YmRmMWE4NmVhZGQwNDg1NTNmOTAw");
		System.out.println(pins);
	}

	@Test
	public void getSearchPins() throws UnsupportedEncodingException {
		final Data<List<Pins>> pins = pinterest.userOperations().getSearchPins("create", 2);
		System.out.println(pins);
	}

	@Test
	public void getSearchPinsNext() {
		final Data<List<Pins>> pins = pinterest.userOperations().getSearchPinsNext(
				"https://api.pinterest.com/v1/me/search/pins/?cursor=b28yfGNhZGY0ZDM1MjlhNjEwNGYzZTAxYTVjNDlkYjE4MDk2MDczNDMyNTc4ZjYyYmM3Zjg3NWU0ZjA1NDYzYTAyMmE%3D&query=create&limit=2&fields=attribution%2Cboard%28counts%2Ccreated_at%2Ccreator%2Cdescription%2Cid%2Cimage%2Cname%2Cprivacy%2Creason%2Curl%29%2Ccolor%2Ccounts%2Ccreated_at%2Ccreator%2Cid%2Cimage%2Clink%2Cmedia%2Cmetadata%2Cnote%2Coriginal_link%2Curl");
		System.out.println(pins);
	}

	@Test
	public void getSearchPinsCursor() {
		final Data<List<Pins>> pins = pinterest.userOperations().getSearchPinsCursor("create",
				"b28yfGNhZGY0ZDM1MjlhNjEwNGYzZTAxYTVjNDlkYjE4MDk2MDczNDMyNTc4ZjYyYmM3Zjg3NWU0ZjA1NDYzYTAyMmE=", 2);
		System.out.println(pins);
	}
}
