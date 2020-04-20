package com.learn.auth.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.auth.domain.UaaUser;
import com.learn.auth.repository.UaaUserRepository;
import com.learn.core.exception.GlobalCommonException;
import com.learn.core.security.AuthoritiesConstants;
import com.learn.core.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final UaaUserRepository uaaUserRepository;

    public DomainUserDetailsService(UaaUserRepository uaaUserRepository) {
        this.uaaUserRepository = uaaUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Authenticating {}", username);

        UaaUser uaaUser = null;
        if (new EmailValidator().isValid(username, null)) {
            QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.or(true, qw -> qw.eq(UaaUser.EMAIL, username));

            uaaUser = uaaUserRepository.selectOne(queryWrapper);
            if (uaaUser == null) {
                throw new GlobalCommonException(MessageUtils.getMessage("error.not.user", username));
            }
        } else {
            QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.or(true, qw -> qw.eq(UaaUser.LOGIN_NAME, username));
            queryWrapper.or(true, qw -> qw.eq(UaaUser.USER_CODE, username));
            queryWrapper.or(true, qw -> qw.eq(UaaUser.MOBILE, username));

            uaaUser = uaaUserRepository.selectOne(queryWrapper);
            if (uaaUser == null) {
                throw new GlobalCommonException(MessageUtils.getMessage("error.not.user", username));
            }
        }

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));

        return DomainUserDetails.builder()
                .userCode(uaaUser.getUserCode())
                .userName(uaaUser.getUserName())
                .jp(uaaUser.getJp())
                .loginName(uaaUser.getLoginName())
                .password(uaaUser.getPassword())
                .mobile(uaaUser.getMobile())
                .email(uaaUser.getEmail())
                .admin(uaaUser.getAdmin())
                .authorities(Collections.unmodifiableSet(DomainUserDetails.sortAuthorities(authorityList)))
                .build();
    }

}
