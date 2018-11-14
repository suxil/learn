package com.learn.oauth.config;

import com.learn.oauth.domain.OrgEmployee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/12 0012 11:18
 */
public class CustomUserDetails implements UserDetails {

  private static final long serialVersionUID = 1L;
  private Collection<? extends GrantedAuthority> authorities;
  private String password;
  private String username;

  public CustomUserDetails(OrgEmployee user) {
    this.username = user.getEmpName();
    this.password = user.getPassword();
    this.authorities = translate(null);
  }

  private Collection<? extends GrantedAuthority> translate(List roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
//    for (Role role : roles) {
//      String name = role.getName().toUpperCase();
//      if (!name.startsWith("ROLE_")) {
//        name = "ROLE_" + name;
//      }
//      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }
    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    return authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
