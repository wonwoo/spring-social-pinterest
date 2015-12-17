package org.springframework.social.pinterest.api;

import java.util.List;

/**
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

	Data<List<Boards>> getSuggested(String pin, Integer count, String fields);

	Data<List<Boards>> getSuggested(String pin, Integer count);

	Data<List<Boards>> getSuggested(String pin);

	/*********************************************/

	Data<List<User>> getFollowers(Integer limit, String fields);

	Data<List<User>> getFollowers(Integer limit);

	Data<List<User>> getFollowers();

	Data<List<User>> getFollowersNext(String next);

	Data<List<User>> getFollowersCursor(String cursor, Integer limit, String fields);

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

}
