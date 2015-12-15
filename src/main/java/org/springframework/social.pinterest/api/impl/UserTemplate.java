package org.springframework.social.pinterest.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.social.pinterest.api.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class UserTemplate extends AbstractPinterestOperations implements UserOperations {

    private RestTemplate restTemplate;
    private String prefix = "me/";
    private PinterestRestApi pinterestRestApi;

    public UserTemplate(PinterestRestApi pinterestRestApi, RestTemplate restTemplate, boolean authorized) {
        super(authorized);
        this.restTemplate = restTemplate;
        this.pinterestRestApi = pinterestRestApi;
    }

    @Override
    public UserData<User> getMe(String fields) {
        requireAuthorization();
        final ResponseEntity<UserData<User>> exchange = pinterestRestApi.getExchange(prefix + "?fields={fields}", new ParameterizedTypeReference<UserData<User>>() {
        },fields);
        return exchange.getBody();
    }

    @Override
    public UserData<User> getMe() {
        return getMe("id,image,username,first_name,last_name,bio,created_at,counts,account_type,url");
    }

    @Override
    public UserData<List<Boards>> getBoards(String fields, Integer limit) {
        requireAuthorization();
        final ResponseEntity<UserData<List<Boards>>> exchange = pinterestRestApi.getExchange(prefix + "boards?fields={fields}&limit={limit}",
                new ParameterizedTypeReference<UserData<List<Boards>>>() {
        },fields,limit);
        return exchange.getBody();
    }

    @Override
    public UserData<List<Boards>> getBoards(String fields) {
        return getBoards(fields, 25);
    }

    @Override
    public UserData<List<Boards>> getBoards() {
        return getBoards("counts,created_at,creator,description,id,image,name,privacy,reason,url");
    }
}

