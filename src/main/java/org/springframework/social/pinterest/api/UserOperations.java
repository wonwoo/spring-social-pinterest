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

	Data<List<Boards>> getFollowersBoards(Integer limit, String fields);

	Data<List<Boards>> getFollowersBoards(Integer limit);

	Data<List<Boards>> getFollowersBoards();

	Data<List<Boards>> getFollowersBoardsNext(String next);

	Data<List<Boards>> getFollowersBoardsCursor(String cursor, Integer limit, String fields);

	Data<List<Boards>> getFollowersBoardsCursor(String cursor, Integer limit);

	/*********************************************/

	Data<String> followingBoards(String board);

	void unfollowingBoards(String board);

	/*********************************/

	Data<List<Interests>> getfollowingInterests(Integer limit);

	Data<List<Interests>> getfollowingInterestsNext(String next);

	Data<List<Interests>> getfollowingInterestsCursor(String cursor, Integer limit);

	/*********************************/
	Data<List<User>> getfollowingUsers(Integer limit, String fields);

	Data<List<User>> getfollowingUsers(Integer limit);

	Data<List<User>> getfollowingUsersNext(String next);

	Data<List<User>> getfollowingUsersCursor(String cursor, Integer limit, String fields);

	Data<List<User>> getfollowingUsersCursor(String cursor, Integer limit);

	/*********************************/

	Data<String> followingUsers(String user);

	void unfollowingUsers(String user);

	/*********************************/

	Data<List<Pins>> getLike(Integer limit, String fields);

	Data<List<Pins>> getLike(Integer limit);

	Data<List<Pins>> getLikeNext(String next);

	Data<List<Pins>> getLikeCursor(String cursor, Integer limit, String fields);

	Data<List<Pins>> getLikeCursor(String cursor, Integer limit);

	/*********************************/

	Data<List<Pins>> getPins(Integer limit, String fields);

	Data<List<Pins>> getPins(Integer limit);

	Data<List<Pins>> getPinsNext(String next);

	Data<List<Pins>> getPinsCursor(String cursor, Integer limit, String fields);

	Data<List<Pins>> getPinsCursor(String cursor, Integer limit);

	/*********************************/

	Data<List<Boards>> getSearchBoards(String query, String fields);

	Data<List<Boards>> getSearchBoards(String query);

	Data<List<Boards>> getSearchBoardsNext(String next);

	Data<List<Boards>> getSearchBoardsCursor(String query, String cursor, String fields);

	Data<List<Boards>> getSearchBoardsCursor(String query, String cursor);

	/*********************************/

	Data<List<Pins>> getSearchPins(String query, Integer limit, String fields);

	Data<List<Pins>> getSearchPins(String query, Integer limit);

	Data<List<Pins>> getSearchPinsNext(String next);

	Data<List<Pins>> getSearchPinsCursor(String query, String cursor, Integer limit, String fields);

	Data<List<Pins>> getSearchPinsCursor(String query, String cursor, Integer limit);
}
