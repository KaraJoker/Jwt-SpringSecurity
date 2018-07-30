package com.noriman.zoom.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @program: Jwt-SpringSecurity
 * @description: 登陆校验接口
 * @author: Outcaster
 * @create: 2018-07-30 16:47
 **/
public interface MultyUserDetailsService extends UserDetailsService {

    UserDetails loadUserByEmail(String var1) throws UsernameNotFoundException;

    UserDetails loadUserByPhone(String var1) throws UsernameNotFoundException;

}
