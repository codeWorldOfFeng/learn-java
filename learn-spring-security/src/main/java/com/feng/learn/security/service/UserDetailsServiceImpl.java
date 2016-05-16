package com.feng.learn.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.feng.learn.security.model.User;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

    private List<User> usersInDb; // 通过bean注入模拟数据库

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	if (null == username)
	    throw new IllegalArgumentException("username is null");
	for (User user : usersInDb) {
	    if (username.equals(user.getPassword())) {
		return user;
	    }
	}
	throw new UsernameNotFoundException("username is not found");
    }

}
