package org.springframework.social.pinterest.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.social.pinterest.api.Boards;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.PinterestRestApi;
import org.springframework.social.pinterest.api.User;
import org.springframework.social.pinterest.api.UserOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

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
        requiredParameters(fields);
        String url = getBaseUrl() + prefix + "?fields={fields}";
        URI expanded = new UriTemplate(url).expand(fields);
        final ResponseEntity<Data<User>> exchange = pinterestRestApi.getExchange(expanded, new ParameterizedTypeReference<Data<User>>() {
        });
        return exchange.getBody();
    }

    @Override
    public Data<User> getMe() {
        return getMe("id,image,username,first_name,last_name,bio,created_at,counts,account_type,url");
    }

    @Override
    public Data<List<Boards>> getBoards(String fields) {
        requireAuthorization();
        requiredParameters(fields);
        String url = getBaseUrl() + prefix + "boards?fields={fields}";
        URI expanded = new UriTemplate(url).expand(fields);
        final ResponseEntity<Data<List<Boards>>> exchange = pinterestRestApi.getExchange(expanded,
                new ParameterizedTypeReference<Data<List<Boards>>>() {
        });
        return exchange.getBody();
    }

    @Override
    public Data<List<Boards>> getBoards() {
        return getBoards("counts,created_at,creator,description,id,image,name,privacy,reason,url");
    }
}

