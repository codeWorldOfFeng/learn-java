package com.feng.learn.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author feng_Pc
 *
 */
public class User extends org.springframework.security.core.userdetails.User {

    public User() {
	super(null, null, null);
    }

    public User(String username, String password) {
	super(username, password, null);
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
	super(username, password, authorities);
    }

}
