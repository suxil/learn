package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:33
 */
@Data
public class OAuthFlows {

    private OAuthFlow implicit; //  	OAuth Flow Object 	Configuration for the OAuth Implicit flow
    private OAuthFlow password; //  	OAuth Flow Object 	Configuration for the OAuth Resource Owner Password flow
    private OAuthFlow clientCredentials; //  	OAuth Flow Object 	Configuration for the OAuth Client Credentials flow. Previously called application in OpenAPI 2.0.
    private OAuthFlow authorizationCode; //  	OAuth Flow Object 	Configuration for the OAuth Authorization Code flow. Previously called accessCode in OpenAPI 2.0.

}
