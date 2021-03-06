package com.moviemanager.moviemanager.UserAuthorization;

import com.moviemanager.moviemanager.model.Role;
import com.moviemanager.moviemanager.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {
    private User user;
    PasswordEncoder passwordEncoder;

    public MyUserDetails(User user){
        this.user=user;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = user.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole_name());

    return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return this.passwordEncoder.encode(user.getPassword());
    }

    @Override
    public String getUsername() {
        return user.getUser_name();
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
        return user.isEnabled();
    }
}
