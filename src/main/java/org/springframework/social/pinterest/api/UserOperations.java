package org.springframework.social.pinterest.api;

import java.util.List;

/**
 *
 *
 *
 * Created by wonwoo on 15. 12. 15..
 */
public interface UserOperations {

	/**
	 * <strong>get me</strong><br>
	 * <br>
	 * files ex) counts,created_at,creator,description
	 * 
	 * @param fields
	 * @return
	 */
	Data<User> getMe(String fields);

	/**
	 * <strong>get me</strong><br>
	 * <br>
	 * The default field <br>
	 * <strong> id,image,username,first_name,last_name,bio,created_at,counts,
	 * account_type,url </strong>
	 * 
	 * @return
	 */
	Data<User> getMe();

	/**
	 * <strong>user search</strong><br>
	 * user <br>
	 * The default field <br>
	 * <strong> account_type,bio,counts,created_at,first_name,id,image,last_name
	 * ,url,username </strong>
	 * 
	 * @param user
	 * @return
	 */
	Data<User> getUserSearch(String user);

	/**
	 * <strong>user search</strong><br>
	 * user <br>
	 * field ex)
	 * <strong> account_type,bio,counts,created_at,first_name,id,image,last_name
	 * ,url,username </strong>
	 * 
	 * @param user
	 * @param fields
	 * @return
	 */
	Data<User> getUserSearch(String user, String fields);

	/**
	 * <strong>getboard</strong><br>
	 * field ex)
	 * <strong> counts,created_at,creator,description,id,image,name,privacy,
	 * reason,url</strong>
	 * 
	 * @param fields
	 * @return
	 */
	Data<List<Boards>> getBoards(String fields);

	/**
	 * <strong>getboard</strong><br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,
	 * reason,url</strong>
	 * 
	 * @return
	 */
	Data<List<Boards>> getBoards();

	/*********************************************/

	/**
	 * <strong>getSuggested</strong><br>
	 * pin, count, fields <br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 *
	 * @param pin
	 * @param count
	 * @param fields
	 * @return
	 */
	Data<List<Boards>> getSuggested(String pin, Integer count, String fields);

	/**
	 * <strong>getSuggested</strong><br>
	 * pin, count <br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 *
	 * @param pin
	 * @param count
	 * @return
	 */
	Data<List<Boards>> getSuggested(String pin, Integer count);

	/**
	 * <strong>getSuggested</strong><br>
	 * pin <br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 * @param pin
	 * @return
	 */
	Data<List<Boards>> getSuggested(String pin);


	/*********************************************/


	/**
	 * <strong>getFollowers</strong><br>
	 * limit, fields <br>
	 * The default field <br>
	 * <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 *
	 * @param limit
	 * @param fields
	 * @return
	 */

	Data<List<User>> getFollowers(Integer limit, String fields);

	/**
	 * <strong>getFollowers</strong><br>
	 * limit <br>
	 * The default field <br>
	 * <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 *
	 * @param limit
	 * @return
	 */
	Data<List<User>> getFollowers(Integer limit);

	/**
	 * <strong>getFollowers</strong><br>
	 * The default limit 25 <br>
	 * The default field <br>
	 * <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 *
	 * @return
	 */
	Data<List<User>> getFollowers();

	/**
	 * <strong>getFollowers</strong><br>
	 *  next<br>
	 * @param next
	 * @return
	 */
	Data<List<User>> getFollowersNext(String next);

	/**
	 * <strong>getFollowers</strong><br>
	 *  cursor, limit, fields
	 *  The default field <br>
	 *  <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 *
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<User>> getFollowersCursor(String cursor, Integer limit, String fields);

	/**
	 * 	<strong>getFollowers</strong><br>
	 *  cursor, limit
	 *  The default field <br>
	 *  <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<User>> getFollowersCursor(String cursor, Integer limit);

	/*********************************************/

	/**
	 * <strong>getFollowersBoards</strong><br>
	 * limit fields
	 *
	 * @param limit
	 * @param fields
	 * @return
	 */

	Data<List<Boards>> getFollowersBoards(Integer limit, String fields);

	/**
	 * <strong>getFollowersBoards</strong><br>
	 * limit <br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 *
	 * @param limit
	 * @return
	 */
	Data<List<Boards>> getFollowersBoards(Integer limit);


	/**
	 * <strong>getFollowersBoards</strong><br>
	 * The default limit 25 <br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 * @return
	 */
	Data<List<Boards>> getFollowersBoards();

	/**
	 * <strong>getFollowersBoards</strong><br>
	 * next
	 * @param next
	 * @return
	 */
	Data<List<Boards>> getFollowersBoardsNext(String next);

	/**
	 * <strong>getFollowersBoards</strong><br>
	 * cursor, limit, fields <br>
	 *
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Boards>> getFollowersBoardsCursor(String cursor, Integer limit, String fields);

	/**
	 * <strong>getFollowersBoards</strong><br>
	 * curosr , limit
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 *
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<Boards>> getFollowersBoardsCursor(String cursor, Integer limit);

	/*********************************************/

	/**
	 * <strong>followingBoards</strong><br>
	 * board
	 * @param board
	 * @return
	 */
	Data<String> followingBoards(String board);

	/**
	 * <strong>unfollowingBoards</strong><br>
	 * board
	 * @param board
	 */
	void unfollowingBoards(String board);

	/*********************************/

	/**
	 * <strong>getfollowingInterests</strong><br>
	 * limit
	 * @param limit
	 * @return
	 */
	Data<List<Interests>> getfollowingInterests(Integer limit);

	/**
	 * <strong>getfollowingInterests</strong><br>
	 * next
	 * @param next
	 * @return
	 */
	Data<List<Interests>> getfollowingInterestsNext(String next);

	/**
	 * <strong>getfollowingInterests</strong><br>
	 *  cursor, limit
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<Interests>> getfollowingInterestsCursor(String cursor, Integer limit);

	/*********************************/


	/**
	 * <strong>getfollowingUsers</strong><br>
	 * limit
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<User>> getfollowingUsers(Integer limit, String fields);

	/**
	 * <strong>getfollowingUsers</strong><br>
	 * limit <br>
	 *  The default field <br>
	 *  <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 * @param limit
	 * @return
	 */
	Data<List<User>> getfollowingUsers(Integer limit);

	/**
	 * <strong>getfollowingUsers</strong><br>
	 * next
	 * @param next
	 * @return
	 */

	Data<List<User>> getfollowingUsersNext(String next);

	/**
	 * <strong>getfollowingUsers</strong><br>
	 * cursor, limit
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<User>> getfollowingUsersCursor(String cursor, Integer limit, String fields);

	/**
	 * <strong>getfollowingUsers</strong><br>
	 * cursor, limit, fields <br>
	 * The default field <br>
	 *  <strong>account_type,bio,counts,created_at,first_name,id,image,last_name,url,username</strong>
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<User>> getfollowingUsersCursor(String cursor, Integer limit);

	/*********************************/

	/**
	 * <strong>followingUsers</strong><br>
	 * user
	 * @param user
	 * @return
	 */
	Data<String> followingUsers(String user);

	/**
	 * <strong>unfollowingUsers</strong><br>
	 * @param user
	 */
	void unfollowingUsers(String user);

	/*********************************/

	/**
	 * <strong>getLike</strong><br>
	 * limit, fields
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Pins>> getLike(Integer limit, String fields);

	/**
	 * <strong>getLike</strong><br>
	 * limit <br>
	 * The default field <br>
	 *  <strong>attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url</strong>
	 * @param limit
	 * @return
	 */
	Data<List<Pins>> getLike(Integer limit);

	/**
	 * <strong>getLike</strong><br>
	 * next
	 * @param next
	 * @return
	 */
	Data<List<Pins>> getLikeNext(String next);

	/**
	 * <strong>getLike</strong><br>
	 * cursor, limit, fields
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Pins>> getLikeCursor(String cursor, Integer limit, String fields);

	/**
	 * <strong>getLike</strong><br>
	 * cursor, limit <br>
	 * The default field <br>
	 *  <strong>attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url</strong>
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<Pins>> getLikeCursor(String cursor, Integer limit);

	/*********************************/


	/**
	 * <strong>getPins</strong><br>
	 * limit, fields
	 *
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Pins>> getPins(Integer limit, String fields);

	/**
	 * <strong>getPins</strong><br>
	 * limit <br>
	 * The default field <br>
	 *  <strong>attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url</strong>
	 * @param limit
	 * @return
	 */
	Data<List<Pins>> getPins(Integer limit);

	/**
	 * <strong>getPins</strong><br>
	 * next
	 * @param next
	 * @return
	 */
	Data<List<Pins>> getPinsNext(String next);

	/**
	 * <strong>getPins</strong><br>
	 * cursor, limit, fields
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Pins>> getPinsCursor(String cursor, Integer limit, String fields);

	/**
	 * <strong>getPins</strong><br>
	 * cursor, limi <br>
	 * The default field <br>
	 *  <strong>attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url</strong>
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<Pins>> getPinsCursor(String cursor, Integer limit);

	/*********************************/

	/**
	 * <strong>getSearchBoards</strong><br>
	 * query, fields
	 * @param query
	 * @param fields
	 * @return
	 */
	Data<List<Boards>> getSearchBoards(String query, String fields);

	/**
	 * <strong>getSearchBoards</strong><br>
	 * query<br>
	 *     The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 *
	 * @param query
	 * @return
	 */
	Data<List<Boards>> getSearchBoards(String query);

	/**
	 * <strong>getSearchBoards</strong><br>
	 * next
	 * @param next
	 * @return
	 */
	Data<List<Boards>> getSearchBoardsNext(String next);

	/**
	 * <strong>getSearchBoards</strong><br>
	 * query, cursor, fields
	 * @param query
	 * @param cursor
	 * @param fields
	 * @return
	 */
	Data<List<Boards>> getSearchBoardsCursor(String query, String cursor, String fields);

	/**
	 * <strong>getSearchBoards</strong><br>
	 * query, cursor <br>
	 * The default field <br>
	 * <strong>counts,created_at,creator,description,id,image,name,privacy,reason,url</strong>
	 * @param query
	 * @param cursor
	 * @return
	 */
	Data<List<Boards>> getSearchBoardsCursor(String query, String cursor);

	/*********************************/


	/**
	 * <strong>getSearchPins</strong><br>
	 * query, limit, fields
	 * @param query
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Pins>> getSearchPins(String query, Integer limit, String fields);

	/**
	 * <strong>getSearchPins</strong><br>
	 * query, limit
	 * The default field <br>
	 *  <strong>attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url</strong>
	 * @param query
	 * @param limit
	 * @return
	 */
	Data<List<Pins>> getSearchPins(String query, Integer limit);

	/**
	 * <strong>getSearchPins</strong><br>
	 * next
	 * @param next
	 * @return
	 */
	Data<List<Pins>> getSearchPinsNext(String next);

	/**
	 * <strong>getSearchPins</strong><br>
	 * query, cursor, limit
	 * @param query
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<Pins>> getSearchPinsCursor(String query, String cursor, Integer limit, String fields);

	/**
	 * <strong>getSearchPins</strong><br>
	 * query, cursor, limit<br>
	 *     The default field <br>
	 *  <strong>attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url</strong>
	 * @param query
	 * @param cursor
	 * @param limit
	 * @return
	 */
	Data<List<Pins>> getSearchPinsCursor(String query, String cursor, Integer limit);
}
