//package com.learn.auth.security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.stereotype.Component;
//
//@Component("clientRegistrationRepository")
//public class DomainClientRegistrationRepository implements ClientRegistrationRepository {
//
//    private final Logger log = LoggerFactory.getLogger(DomainClientRegistrationRepository.class);
//
////    private
//
//    @Override
//    public ClientRegistration findByRegistrationId(String registrationId) {
//        ClientRegistration clientRegistration = ClientRegistration
//                .withRegistrationId("registration-id")
//                .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .scope("read:user")
//                .authorizationUri("https://localhost:18091/oauth/authorize")
//                .tokenUri("https://localhost:18091/login/oauth/access_token")
//                .jwkSetUri("https://localhost:18091/oauth2/jwk")
//                .userInfoUri("https://localhost:18091/api/v1/uaa-user/current")
//                .userNameAttributeName("id")
//                .clientName("Client Name")
//                .clientId("client-id")
//                .clientSecret("client-secret")
//                .build();
//        return clientRegistration;
//    }
//
//}
