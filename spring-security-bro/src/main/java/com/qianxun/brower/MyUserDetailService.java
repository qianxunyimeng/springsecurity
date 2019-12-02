package com.qianxun.brower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-11-28 22:36
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    private  Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("登录用户名:" + username);
        //向数据库查询用户信息
        String encode = passwordEncoder.encode("123456");
        User user = new User(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
        return user;
    }
}
