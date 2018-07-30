package com.noriman.zoom.auth.service.impl;

import com.noriman.zoom.auth.user.JwtUserFactory;
import com.noriman.zoom.auth.service.MultyUserDetailsService;
import com.noriman.zoom.domain.User;
import com.noriman.zoom.domain.UserExample;
import com.noriman.zoom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @program: Jwt-SpringSecurity
 * @description: 登陆校验类
 * @author: Outcaster
 * @create: 2018-07-30 16:47
 **/
@Service
public class JwtUserDetailsServiceImpl implements MultyUserDetailsService {

    @Autowired
    private  UserMapper userMapper;

    /**
     * @param username
     * @return UserDetail
     * @throws UsernameNotFoundException not found user
     */
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            userDetails = this.loadUserByEmail(username);
        } catch (UsernameNotFoundException e1) {
            try {
                userDetails = this.loadUserByPhone(username);
            } catch (UsernameNotFoundException e2) {
                throw e2;
            }
        }

        return userDetails;
    }

    @Override
    public UserDetails loadUserByEmail (String email) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andEmailEqualTo(email);

        List<User> tmp =  userMapper.selectByExample(userExample);
        LinkedList<User> users = new LinkedList<User>(tmp);

        User user = null;
        try {
            user = users.pop();
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("not found user by email : " + email);
        }

        return JwtUserFactory.create(user);

    }

    @Override
    public UserDetails loadUserByPhone (String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andPhoneEqualTo(phone);

        List<User> tmp = userMapper.selectByExample(userExample);
        LinkedList<User> users = new LinkedList<User>(tmp);

        User user = null;
        try {
            user = users.pop();
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("not found user by phone " + phone);
        }

        return JwtUserFactory.create(user);
    }

}
