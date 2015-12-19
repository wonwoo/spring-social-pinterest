package org.springframework.social.pinterest.connect;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class ConnectTest {

    //insert appid
    private String APP_ID="";
    //insert app secret
    private String APP_SECRET = "";

    PinterestConnectionFactory pinterestConnectionFactory = null;
    ConnectionFactoryRegistry connectionFactoryRegistry = null;
    OAuth2Parameters oAuth2Parameters = null;

    @Before
    public void befofe() {
        pinterestConnectionFactory = new PinterestConnectionFactory(APP_ID, APP_SECRET);
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
        //insert result code
        String code = "";
        OAuth2Operations oAuth2Operations = pinterestConnectionFactory.getOAuthOperations();
        AccessGrant accessGrant = oAuth2Operations.exchangeForAccess(code, "https://localhost:8080/pinterest/callback", null);
        printAcess(accessGrant);
    }

    private void printAcess(AccessGrant accessGrant) throws IOException {
        System.out.println(String.format("accessToken : %s", accessGrant.getAccessToken()));
    }
}
