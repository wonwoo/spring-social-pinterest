package org.springframework.social.pinterest.api;

import java.util.List;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public interface UserOperations {

    UserData<User> getMe(String fields);

    UserData<User> getMe();

    UserData<List<Boards>> getBoards(String fields, Integer limit);

    UserData<List<Boards>> getBoards(String fields);

    UserData<List<Boards>> getBoards();

}
