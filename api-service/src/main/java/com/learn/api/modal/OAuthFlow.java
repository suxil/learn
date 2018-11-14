package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:33
 */
@Data
public class OAuthFlow {

    private String authorizationUrl; //  	string 	oauth2 ("implicit", "authorizationCode") 	REQUIRED. The authorization URL to be used for this flow. This MUST be in the form of a URL.
    private String tokenUrl; //  	string 	oauth2 ("password", "clientCredentials", "authorizationCode") 	REQUIRED. The token URL to be used for this flow. This MUST be in the form of a URL.
    private String refreshUrl; //  	string 	oauth2 	The URL to be used for obtaining refresh tokens. This MUST be in the form of a URL.
    private Map<String, String> scopes; //  	Map[string, string] 	oauth2 	REQUIRED. The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.

}
