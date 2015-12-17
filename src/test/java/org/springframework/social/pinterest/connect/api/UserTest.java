package org.springframework.social.pinterest.connect.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.pinterest.api.Boards;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.User;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.impl.PinterestTemplate;

import java.util.List;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class UserTest {

	String key = "4807113954438426320";
	String token = "AVC1b4Emnf8rvHTZH4J9gopJZnBVFCCc4WI_YJxCtmEPYoBGWgAAAAA";

	Pinterest pinterest = null;

	@Before
	public void before() {
		pinterest = new PinterestTemplate(token, key);
	}

	@Test
	public void getMe() {
		final Data<User> me = pinterest.userOperations().getMe();
		System.out.println(me.getData().getBio());
		System.out.println(me.getData().getId());
		System.out.println(me.getData().getImage().getOriginal());
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

}
