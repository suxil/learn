//package com.learn.auth.security;
//
//import com.learn.auth.repository.UaaUserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component("oAuth2UserService")
//public class DomainOAuth2UserService implements OAuth2UserService {
//
//    private final Logger log = LoggerFactory.getLogger(DomainOAuth2UserService.class);
//
//    private final UaaUserRepository uaaUserRepository;
//
//    public DomainOAuth2UserService(UaaUserRepository uaaUserRepository) {
//        this.uaaUserRepository = uaaUserRepository;
//    }
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        log.debug("Oauth Authenticating Load User");
//
//        OAuth2AccessToken auth2AccessToken = userRequest.getAccessToken();
//
//        ClientRegistration clientRegistration = userRequest.getClientRegistration();
//
//        Map<String, Object> parameter = userRequest.getAdditionalParameters();
//
//        return null;
//    }
//
//}
