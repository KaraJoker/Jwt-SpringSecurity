package com.noriman.zoom.controller;

import com.noriman.zoom.domain.User;
import com.noriman.zoom.domain.UserExample;
import com.noriman.zoom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: Jwt-SpringSecurity
 * @description:
 * @author: Outcaster
 * @create: 2018-07-30 16:47
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/")
    @PreAuthorize("hasRole('PERSONAL')")
    public String getUserGreeting () {
        return "hello , this is " + this.getClass().getSimpleName();
    }

    @RequestMapping("/list")
    @PreAuthorize("hasRole('BOSS')")
    public String list () {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIsNotNull();
        List<User> lists = userMapper.selectByExample(userExample);
        return lists.toString();
    }

    
}
