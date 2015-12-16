package org.springframework.social.pinterest.api;

import java.util.List;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public interface UserOperations {

	Data<User> getMe(String fields);

	Data<User> getMe();

	Data<List<Boards>> getBoards(String fields);

	Data<List<Boards>> getBoards();

}
