package org.springframework.social.pinterest.api;

import java.util.List;

public interface BoardsOperations {

	/**
	 * <strong>create board</strong><br>
	 * <br>
	 * board name , board description, <br>
	 * fields ex)
	 * counts,created_at,creator,description,id,image,name,privacy,reason,url
	 * 
	 * @param name
	 * @param description
	 * @param fields
	 * @return
	 */
	Data<Boards> create(String name, String description, String fields);

	/**
	 * <strong>create board</strong><br>
	 * <br>
	 * board name <br>
	 * description
	 * 
	 * @param name
	 * @param description
	 * @return
	 */
	Data<Boards> create(String name, String description);

	/**
	 * <strong>create board</strong><br>
	 * <br>
	 * board name <br>
	 * The default field
	 * <strong> counts,created_at,creator,description,id,image,name,privacy,
	 * reason,url<strong>
	 * 
	 * @param name
	 * @return
	 */
	Data<Boards> create(String name);

	/**
	 * <strong>get board</strong><br>
	 * <br>
	 * boardid <br>
	 * The default field
	 * <strong> counts,created_at,creator,description,id,image,name,privacy,
	 * reason,url<strong>
	 * 
	 * @param board
	 * @return
	 */

	Data<Boards> get(String board);

	/**
	 * <strong>get board</strong><br>
	 * <br>
	 * boardid , field
	 * 
	 * @param board
	 * @param fields
	 * @return
	 */

	Data<Boards> get(String board, String fields);

	/**
	 * <strong>board getpin</strong><br>
	 * <br>
	 * boardid , The default field
	 * <strong> attribution,board(counts,created_at,creator,description,id,image
	 * ,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,
	 * media,metadata,note,original_link,url </strong>
	 * 
	 * @param board
	 * @return
	 */

	Data<List<BoardPin>> getPin(String board);

	/**
	 * <strong>board getpin</strong><br>
	 * boardid
	 * 
	 * @param board
	 * @param fields
	 * @return
	 */

	Data<List<BoardPin>> getPin(String board, String fields);

	/**
	 * <strong>board getpin</strong><br>
	 * boardid, limit, fields
	 * 
	 * @param board
	 * @param limit
	 * @param fields
	 * @return
	 */

	Data<List<BoardPin>> getPin(String board, Integer limit, String fields);

	/**
	 * <strong>board getPinNext</strong><br>
	 * {@link Page} next is full url
	 * 
	 * @param next
	 * @return
	 */
	Data<List<BoardPin>> getPinNext(String next);

	/**
	 * <strong>board getPinCursor</strong><br>
	 * boardid , {@link Page} cursor , limit <br>
	 * <br>
	 * The default field
	 * <strong> attribution,board(counts,created_at,creator,description,id,image
	 * ,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,
	 * media,metadata,note,original_link,url </strong>
	 * 
	 * @param board
	 * @param cursor
	 * @param limit
	 * @return
	 */

	Data<List<BoardPin>> getPinCursor(String board, String cursor, Integer limit);

	/**
	 * <strong>board getPinCursor</strong><br>
	 * boardid , {@link Page} cursor , limit , fields<br>
	 * 
	 * @param board
	 * @param cursor
	 * @param limit
	 * @param fields
	 * @return
	 */
	Data<List<BoardPin>> getPinCursor(String board, String cursor, Integer limit, String fields);

	/**
	 * 
	 * @param board
	 * @param name
	 * @param description
	 * @param fields
	 * @return
	 */
	// TODO 501 error
	Data<Boards> patch(String board, String name, String description, String fields);
	
	
	/**
	 * <strong>board delete</strong><br>
	 * boardid
	 * 
	 * @param board
	 */
	void delete(String board);
}
