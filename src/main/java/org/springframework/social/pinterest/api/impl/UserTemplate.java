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
    public Data<User> getMe(String fields) {
        requireAuthorization();
        final ResponseEntity<Data<User>> exchange = pinterestRestApi.getExchange(prefix + "?fields={fields}", new ParameterizedTypeReference<Data<User>>() {
        },fields);
        return exchange.getBody();
    }

    @Override
    public Data<User> getMe() {
        return getMe("id,image,username,first_name,last_name,bio,created_at,counts,account_type,url");
    }

    @Override
    public Data<List<Boards>> getBoards(String fields) {
        requireAuthorization();
        final ResponseEntity<Data<List<Boards>>> exchange = pinterestRestApi.getExchange(prefix + "boards?fields={fields}",
                new ParameterizedTypeReference<Data<List<Boards>>>() {
        },fields);
        return exchange.getBody();
    }

    @Override
    public Data<List<Boards>> getBoards() {
        return getBoards("counts,created_at,creator,description,id,image,name,privacy,reason,url");
    }
}

