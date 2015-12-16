package org.springframework.social.pinterest.connect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import java.io.IOException;
import java.util.List;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class ConnectTest {

    private String APP_ID="4807113954438426320";
    private String SECRET_KEY = "c9dcf505406df635a9047afa354cb8f3f4207f7ce0202ca856d4c9af2caf7a27";

    PinterestConnectionFactory pinterestConnectionFactory = null;
    ConnectionFactoryRegistry connectionFactoryRegistry = null;
    OAuth2Parameters oAuth2Parameters = null;

    @Before
    public void befofe() {
        pinterestConnectionFactory = new PinterestConnectionFactory(APP_ID, SECRET_KEY);
        connectionFactoryRegistry = new ConnectionFactoryRegistry();
        connectionFactoryRegistry.addConnectionFactory(pinterestConnectionFactory);
        oAuth2Parameters = new OAuth2Parameters();
        oAuth2Parameters.setRedirectUri("https://localhost:8080/pinterest/callback");
        oAuth2Parameters.setScope("read_public,write_public,read_relationships,write_relationships");
    }

    @Test
    public void connectTest(){
        OAuth2Operations oAuth2Operations = pinterestConnectionFactory.getOAuthOperations();
        String authurl = oAuth2Operations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
        System.out.println(String.format("authurl : %s", authurl));
    }

    @Test
    public void accessTokenTest() throws IOException {
        String code = "7f926bfbfe6156e3";
        OAuth2Operations oAuth2Operations = pinterestConnectionFactory.getOAuthOperations();
        AccessGrant accessGrant = oAuth2Operations.exchangeForAccess(code, "https://localhost:8080/pinterest/callback", null);
        printAcess(accessGrant);
    }

    private void printAcess(AccessGrant accessGrant) throws IOException {
        System.out.println(String.format("accessToken : %s", accessGrant.getAccessToken()));
//        System.out.println(String.format("expireTime : %s", accessGrant.getExpireTime()));
//        System.out.println(String.format("refreshToken : %s", accessGrant.getRefreshToken()));
//        System.out.println(String.format("scope : %s", accessGrant.getScope()));

//        ObjectMapper objectMapper = new ObjectMapper();
//        List<String> scopes = objectMapper.readValue(accessGrant.getScope(), List.class);
//        System.out.println(scopes);
    }
}
