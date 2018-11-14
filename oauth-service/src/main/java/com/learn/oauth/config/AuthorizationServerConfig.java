package com.learn.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/25 0025 23:09
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
    private AuthenticationManager authenticationManager;

    // 定义授权和令牌端点以及令牌服务。
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
    }

    // 定义令牌端点上的安全性约束。
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.checkTokenAccess("isAuthenticated()");
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    // 用于定义客户端详细信息服务的配置程序。可以初始化客户端详细信息，也可以只引用现有商店。
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientId")
                .secret("secret")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password").scopes("openid");
    }

}
