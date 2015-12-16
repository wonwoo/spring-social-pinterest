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
    String token = "AZNTDA3sbdXlTuq7EmVWV-A2Sx29FCAfWKqyZWlCtluhkKAsGwAAAAA";

    Pinterest pinterest = null;
    @Before
    public void before(){
        pinterest = new PinterestTemplate(token,key);
    }
    @Test
    public void getMe(){
        pinterest = new PinterestTemplate(token,key);
        final Data<User> me = pinterest.userOperation().getMe();
        System.out.println(me.getData().getBio());
        System.out.println(me.getData().getId());
        System.out.println(me.getData().getImage().get("60x60").get("url"));
        System.out.println(me);
    }

    @Test
    public void getBoards(){
        pinterest = new PinterestTemplate(token,key);
        final Data<List<Boards>> boards = pinterest.userOperation().getBoards();
        for(Boards board : boards.getData()){
            System.out.println(board.getCounts().getCollaborators());
            System.out.println(board);
        }
    }
}//ASUtqaV-j1ZP1S90Nns0Y9BtHK1yFCAcfv8LnthCtk-Q4UAufgAAAAA
