//package com.learn.auth.security;
//
//import com.learn.auth.domain.UaaUser;
//import com.learn.auth.repository.UaaUserRepository;
//import com.learn.core.security.AuthoritiesConstants;
//import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component("userDetailsService")
//public class DomainUserDetailsService implements UserDetailsService {
//
//    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);
//
//    private final UaaUserRepository uaaUserRepository;
//
//    public DomainUserDetailsService(UaaUserRepository uaaUserRepository) {
//        this.uaaUserRepository = uaaUserRepository;
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.debug("Authenticating {}", username);
//
//        UaaUser uaaUser = null;
//        if (new EmailValidator().isValid(username, null)) {
//            uaaUser = uaaUserRepository.selectOne(null);
//            if (uaaUser == null) {
//                throw new UsernameNotFoundException("User with email " + username + " was not found in the database");
//            }
//        } else {
//            uaaUser = uaaUserRepository.selectOne(null);
//            if (uaaUser == null) {
//                throw new UsernameNotFoundException("User " + username + " was not found in the database");
//            }
//        }
//
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
//
//        return new User(uaaUser.getLoginName(), uaaUser.getPassword(), authorityList);
//    }
//
//}
