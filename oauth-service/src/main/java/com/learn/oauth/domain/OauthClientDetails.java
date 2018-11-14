package com.learn.oauth.domain;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/26 0026 0:03
 */
//@Entity
@Table(name = "OAUTH_CLIENT_DETAILS")
public class OauthClientDetails implements Serializable {

    private String clientId;  //           VARCHAR(256) PRIMARY KEY,
    private String resourceIds;  //              VARCHAR(256),
    private String clientSecret;  //               VARCHAR(256),
    private String scope;  //        VARCHAR(256),
    private String authorizedGrantTypes;  //                       VARCHAR(256),
    private String webServerRedirectUri;  //                       VARCHAR(256),
    private String authorities;  //              VARCHAR(256),
    private Integer accessTokenValidity;  // INTEGER,
    private Integer refreshTokenValidity;  //  INTEGER,
    private String additionalInformation;  //                        VARCHAR(4096),
    private String autoapprove;  //              VARCHAR(256)

}
