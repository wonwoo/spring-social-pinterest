package org.springframework.social.pinterest.connect;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestOAuth2Template extends OAuth2Template {

    private Logger logger = LoggerFactory.getLogger(PinterestOAuth2Template.class);

    public PinterestOAuth2Template(String clientId, String appSecret) {
        super(clientId, appSecret, "https://api.pinterest.com/oauth/", "https://api.pinterest.com/v1/oauth/token");
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.ALL}));
        HttpEntity<?> requestEntity = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
        AccessToken response = getRestTemplate().postForObject(accessTokenUrl, requestEntity, AccessToken.class);
        if (logger.isDebugEnabled()) {
            logger.debug("respones : {}", response);
        }
        return new AccessGrant(response.getAccess_token());
    }

    private static class AccessToken{
        private String access_token;

        private String token_type;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }


        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("AccessToken{");
            sb.append("access_token='").append(access_token).append('\'');
            sb.append(", token_type='").append(token_type).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}